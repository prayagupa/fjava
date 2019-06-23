package org.prayagupd.fjava.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Function;

public class List<A> {

    private java.util.List<A> list = new ArrayList<>();

    public List(A ... list) {
        this.list = Arrays.asList(list);
    }

    public static <C> List<C> List(C ... args) {
        return new List<C>(args);
    }

    private List(java.util.List<A> as) {
        this.list = as;
    }

    public <B> List<B> map(Function<A, B> fn) {
        java.util.List<B> mutAccumulator = new ArrayList<>();

        for (A a: list) {
            mutAccumulator.add(fn.apply(a));
        }

        return new List<B>(mutAccumulator);
    }

    public void show() {
        for(A a: list) {
            System.out.println(a);
        }
    }
}
