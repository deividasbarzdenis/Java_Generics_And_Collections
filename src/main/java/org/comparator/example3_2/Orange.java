package org.comparator.example3_2;

public class Orange extends Fruit implements Comparable<Orange>{

    public Orange(int size) {
        super("Orange", size);
    }

    @Override
    public int compareTo(Orange o) {
        return super.compareTo(o);
    }

}
