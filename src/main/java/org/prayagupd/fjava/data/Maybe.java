package org.prayagupd.fjava.data;

import java.util.function.Function;

public interface Maybe<A> {}

class Just<A> implements Maybe {
    private A a;

    public Just(A a) {
        this.a = a;
    }

    <B> Just<B> map(Function<A, B> fn) {
        return new Just<>(fn.apply(a));
    }
}

class Nothing<A> implements Maybe {

    public Nothing(){

    }

    <B> Nothing<B> map(Function<A, B> fn) {
        return new Nothing<>();
    }
}
