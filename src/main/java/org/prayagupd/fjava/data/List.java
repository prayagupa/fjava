package org.prayagupd.fjava.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Function;

/**
 * https://hackage.haskell.org/package/base-4.8.1.0/docs/Data-List.html
 * @param <A>
 */
public class List<A> implements Iterable<A> {

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

    public <B> List<B> fmap(Function<A, List<B>> fn) {
        java.util.List<B> mutAccumulator = new ArrayList<>();

        for (A a: list) {
            for (B a1: fn.apply(a)) {
                mutAccumulator.add(a1);
            }
        }

        return new List<B>(mutAccumulator);
    }

    public void show() {
        for(A a: list) {
            System.out.println(a);
        }
    }

    @Override
    public Iterator<A> iterator() {
        return list.iterator();
    }
}
