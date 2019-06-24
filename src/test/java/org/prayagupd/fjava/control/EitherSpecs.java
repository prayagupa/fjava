package org.prayagupd.fjava.control;

import org.junit.Test;

import static org.junit.Assert.*;

public class EitherSpecs {

    @Test
    public void right() {
        Right<String, Integer> price = new Right<>(100);

        var addTax = price.map(s -> s + s * 0.20);

        addTax.map(v -> {
            System.out.println("value is: " + v);
            return v;
        });
    }

    @Test
    public void left() {
        Left<String, Integer> price = new Left<>("Error");

        var addTax = price.map(s -> s + s * 0.20);

        addTax.map(v -> {
            System.out.println("value is : " + v);
            return v;
        });
    }
}
