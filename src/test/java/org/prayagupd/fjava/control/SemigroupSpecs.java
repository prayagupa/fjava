package org.prayagupd.fjava.control;

import org.junit.Assert;
import org.junit.Test;

public class SemigroupSpecs {

    @Test
    public void semigrgoupTest() {
        Semigroup<Integer> left = new IntSemigroup(1).combine(2);
        Semigroup<Integer> right = new IntSemigroup(2).combine(1);

        Assert.assertEquals(left, right);
    }
}
