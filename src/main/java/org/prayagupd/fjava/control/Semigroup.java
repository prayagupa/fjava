package org.prayagupd.fjava.control;

public interface Semigroup<A> {
    Semigroup<A> combine(A a);
}
