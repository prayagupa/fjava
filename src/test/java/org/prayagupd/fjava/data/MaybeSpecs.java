package org.prayagupd.fjava.data;

import org.junit.Assert;
import org.junit.Test;
import org.prayagupd.fjava.data.Maybe.Just;

public class MaybeSpecs {

    @Test
    public void fmap() {
        var data = new Just<>(1)
                .map(a -> a * 2)
                .fmap(a -> new Just<>(a * 2.0));

        Assert.assertEquals(data.toString(), new Just<>(4.0).toString());
    }

}
