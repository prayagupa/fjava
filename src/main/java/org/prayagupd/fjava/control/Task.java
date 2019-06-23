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

    private CompletableFuture<A> future;

    private Task(CompletableFuture<A> f) {
        future = f;
    }

    public Task(Supplier<A> a) {
        future = CompletableFuture.supplyAsync(a);
    }

    public Task<A> unit(A a) {
        future = CompletableFuture.completedFuture(a);
        return this;
    }

    public <B> Task<B> map(Function<A, B> fn) {
        CompletableFuture<B> bCompletableFuture = future.thenApplyAsync(fn);
        return new Task<B>(bCompletableFuture);
    }

    public Task<A> fmap(Function<A, Task<A>> taskFn) {
        var r = future.thenCompose(v -> taskFn.apply(v).future);
        return new Task<A>(r);
    }

    public A unsafeRunSync() throws ExecutionException, InterruptedException {
        return future.get();
    }
}
