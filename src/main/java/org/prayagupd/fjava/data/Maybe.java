package org.prayagupd.fjava.data;

import java.util.function.Function;

public interface Maybe<A> {
    <B> Maybe<B> map(Function<A, B> fn);

    <B> Maybe<B> fmap(Function<A, Maybe<B>> fn);

    public static class Just<A> implements Maybe<A> {
        private A a;

        public Just(A a) {
            this.a = a;
        }

        public <B> Maybe<B> map(Function<A, B> fn) {
            return new Just<>(fn.apply(a));
        }

        public <B> Maybe<B> fmap(Function<A, Maybe<B>> fn) {
            return fn.apply(a);
        }

        @Override
        public String toString() {
            return "Just<>(" + a + ")";
        }

        @Override
        public int hashCode() {
            return a.hashCode();
        }
    }

    public static class Nothing<A> implements Maybe<A> {

        public Nothing() {

        }

        public <B> Maybe<B> map(Function<A, B> fn) {
            return new Nothing<>();
        }

        public <B> Maybe<B> fmap(Function<A, Maybe<B>> fn) {
            return new Nothing<B>();
        }

        @Override
        public String toString() {
            return "Nothing<>()";
        }
    }

}
