package org.prayagupd.fjava.data;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.prayagupd.fjava.data.List.List;

public class ListSpecs {

    @Test
    public void map() {
        var data = List(1, 2, 3, 4)
                .map(a -> a * 2)
                .map(b -> b * 3);

        data.show();
    }
}
