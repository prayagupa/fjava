package org.prayagupd.fjava.control;

public interface Monad<A> extends Semigroup<A> {
    Monad<A> identity();
    Monad<A> combine(A b);
}
