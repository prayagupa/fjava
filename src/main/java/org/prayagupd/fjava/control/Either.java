package org.prayagupd.fjava.control;

import java.util.function.Function;

/**
 * https://hackage.haskell.org/package/category-extras-0.52.0/docs/Control-Monad-Either.html
 * @param <L>
 * @param <R>
 */
public abstract class Either<L, R> {
    private Left<L, R> left;
    private Right<L, R> right;

    public static <L, R> Left<L, R> left(L l) {
        return new Left<>(l);
    }

    public static <L, R> Right<L, R> right(R r) {
        return new Right<>(r);
    }

    public abstract <R1> Either<L, R1> map(Function<R, R1> f);

}

class Left<L, R> extends Either<L, R> {
    private L l;

    public Left(L l) {
        this.l = l;
    }

    @Override
    public <R1> Either<L, R1> map(Function<R, R1> f) {
        return new Left<L, R1>(l);
    }
}

class Right<L, R> extends Either<L, R> {
    private R r;

    public Right(R r) {
        this.r = r;
    }

    @Override
    public <R1> Either<L, R1> map(Function<R, R1> f) {
        return new Right<L, R1>(f.apply(r));
    }
}
