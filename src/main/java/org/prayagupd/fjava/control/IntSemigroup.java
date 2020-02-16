package org.prayagupd.fjava.control;

public class IntSemigroup implements Semigroup<Integer> {

    private Integer a;

    public IntSemigroup(Integer a) {
        this.a = a;
    }

    @Override
    public Semigroup<Integer> combine(Integer b) {
        return new IntSemigroup(a + b);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntSemigroup that = (IntSemigroup) o;
        return this.a.equals(that.a);
    }
}
