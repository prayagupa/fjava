package org.prayagupd.fjava.control;

public class IntMonad implements Monad<Integer> {

    private Integer monadValue;

    public IntMonad(Integer monadValue) {
        this.monadValue = monadValue;
    }

    @Override
    public Monad<Integer> identity() {
        return new IntMonad(0);
    }

    @Override
    public Monad<Integer> combine(Integer b) {
        return new IntMonad(monadValue + b);
    }
}
