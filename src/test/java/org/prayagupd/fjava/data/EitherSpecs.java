package org.prayagupd.fjava.data;

import org.junit.Test;
import org.prayagupd.fjava.data.Either.Left;
import org.prayagupd.fjava.data.Either.Right;

import java.util.Optional;

import static org.prayagupd.fjava.data.EitherSpecs.Error.Error;
import static org.prayagupd.fjava.data.Unit.Unit;

public class EitherSpecs {

    @Test
    public void right() {
        Either<String, Integer> price = new Right<>(100);

        var addTax = price.map(s -> s + s * 0.20);

        addTax.map(v -> {
            System.out.println("value is: " + v);
            return v;
        });
    }

    @Test
    public void left() {
        Either<String, Integer> price = new Left<>("Error");

        var addTax = price.map(s -> s + s * 0.20);

        addTax.map(v -> {
            System.out.println("value is : " + v);
            return v;
        });
    }

    static class Error {
        String errorMessage;
        Optional<Throwable> errorDetail;

        public Error(String errorMessage, Optional<Throwable> t) {
            this.errorMessage = errorMessage;
            this.errorDetail = t;
        }

        public static Error Error(String errorMessage, Optional<Throwable> t) {
            return new Error(errorMessage, t);
        }

        @Override
        public String toString() {
            return "errorMessage: " + errorMessage;
        }
    }

    @Test
    public void either() {
        Either<Error, Integer> price = new Left<>(Error("could not do the stuff", Optional.empty()));

        var addTax = price.map(s -> s + s * 0.20);

        addTax.either(
                l -> {
                    System.out.println(l);
                    return Unit();
                },
                r -> {
                    return Unit();
                }
        );
    }
}
