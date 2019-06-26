package org.prayagupd.fjava.control;

import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

public class TaskSpecs {

    @Test
    public void fmap() {

        var task = new Task<>(() -> 2)
                .map(data -> data * 2)
                .fmap(data -> new Task<>(() -> data * 3));

        System.out.println(task.unsafeRunSync());

        Assert.assertEquals(task.unsafeRunSync(), new Integer(12));
    }

    @Test
    public void underlyingPromiseTest() throws InterruptedException {

        var promise = CompletableFuture.supplyAsync(() -> {
            System.out.println("executing exception code");
            Integer res = (1 / 0);
            System.out.println("executed exception code");
            return res;
        }).thenApply(c -> {
            return c * 100;
        });

        Thread.sleep(1000);

        Assert.assertEquals(promise.isCompletedExceptionally(), Boolean.TRUE);

    }

    @Test
    public void failedTask() throws InterruptedException {

        var promise = CompletableFuture.supplyAsync(() -> {
            System.out.println("executing exception code");
            Integer res = (1 / 0);
            System.out.println("executed exception code");
            return res;
        }).thenApply(c -> {
            return c * 100;
        });

        Thread.sleep(1000);

        Assert.assertEquals(promise.isCompletedExceptionally(), Boolean.TRUE);

    }
}
