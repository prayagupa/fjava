package org.prayagupd.fjava.data;

import java.util.function.Function;

/**
 * http://hackage.haskell.org/package/base-4.12.0.0/docs/Data-Either.html
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

    public abstract Boolean isLeft();
    public abstract Boolean isRight();
    public abstract <R1> R1 either(Function<L, R1> lf, Function<R, R1> rf);

    public abstract <R1> Either<L, R1> map(Function<R, R1> f);
    public abstract <R1> Either<L, R1> fmap(Function<R, Either<L, R1>> f);

    public final static class Left<L, R> extends Either<L, R> {
        private L l;

        public Left(L l) {
            this.l = l;
        }

        @Override
        public <R1> Either<L, R1> map(Function<R, R1> f) {
            return new Left<L, R1>(l);
        }

        @Override
        public <R1> Either<L, R1> fmap(Function<R, Either<L, R1>> f) {
            return new Left<>(l);
        }

        @Override
        public Boolean isLeft() {
            return true;
        }

        @Override
        public Boolean isRight() {
            return false;
        }

        @Override
        public <R1> R1 either(Function<L, R1> lf, Function<R, R1> rf) {
            return lf.apply(l);
        }

        @Override
        public String toString() {
            return "Left(" + l + ")";
        }
    }

    public final static class Right<L, R> extends Either<L, R> {
        private R r;

        public Right(R r) {
            this.r = r;
        }

        @Override
        public <R1> Either<L, R1> map(Function<R, R1> f) {
            return new Right<L, R1>(f.apply(r));
        }

        @Override
        public <R1> Either<L, R1> fmap(Function<R, Either<L, R1>> f) {
            return f.apply(r);
        }

        @Override
        public Boolean isLeft() {
            return false;
        }

        @Override
        public Boolean isRight() {
            return false;
        }

        @Override
        public <R1> R1 either(Function<L, R1> lf, Function<R, R1> rf) {
            return rf.apply(r);
        }

        @Override
        public String toString() {
            return "Right(" + r + ")";
        }
    }

}
