package org.comparator.example3_4;

public abstract class Enum1<E extends Enum1<E>> implements Comparable<E> {

    private final String name;
    private final int ordinal;

    protected Enum1(String name, int ordinal) {
        this.name = name;
        this.ordinal = ordinal;
    }

    public String name() {
        return name;
    }

    public int ordinal() {
        return ordinal;
    }

    @Override
    public String toString() {
        return  name;
    }

    @Override
    public final int compareTo(E o) {
        return ordinal - o.ordinal();
    }
}
