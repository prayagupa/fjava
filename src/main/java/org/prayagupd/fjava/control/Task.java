package org.prayagupd.fjava.control;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * functional Task<A>
 * http://hackage.haskell.org/package/monad-task-0.2.0/docs/Control-Monad-Task.html
 * TODO make lazy eval
 * @param <A>
 */
public class Task<A> {

    private CompletableFuture<A> promise;

    private Task(CompletableFuture<A> f) {
        promise = f;
    }

    public Task(Supplier<A> a) {
        promise = CompletableFuture.supplyAsync(a);
    }

    public Task<A> unit(A a) {
        promise = CompletableFuture.completedFuture(a);
        return this;
    }

    public <B> Task<B> map(Function<A, B> fn) {
        CompletableFuture<B> bCompletableFuture = promise.thenApplyAsync(fn);
        return new Task<B>(bCompletableFuture);
    }

    public <B> Task<B> fmap(Function<A, Task<B>> taskFn) {
        return new Task<B>(promise.thenCompose(c -> taskFn.apply(c).promise));
    }

    public CompletableFuture<A> promise() {
        return promise;
    }

    public A unsafeRunSync() {
        try {
            return promise.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
