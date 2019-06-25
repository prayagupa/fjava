package org.prayagupd.fjava.control;

import org.junit.Assert;
import org.junit.Test;

import java.util.function.Function;

public class TaskSpecs {

    @Test
    public void asyncTask() {

        Function<Integer, Integer> ff = a -> a * 2;

        var taskFn = new Function<Integer, Task<Integer>>() {

            @Override
            public Task<Integer> apply(Integer in) {
                return new Task<Integer>(() -> in * 2);
            }
        };

        var task = new Task<Integer>(() -> 2);

        var task2 = task
                .map(data -> data * 2)
                .fmap(data -> new Task<Integer>(() -> data * 3));

        System.out.println(task2.unsafeRunSync());

        Assert.assertEquals(task2.unsafeRunSync(), new Integer(12));
    }

}
