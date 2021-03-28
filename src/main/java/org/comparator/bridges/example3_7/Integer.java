package org.comparator.bridges.example3_7;

// Generic code for comparable integers
public class Integer implements Comparable<Integer>{

    private final int value;

    public Integer(int value) {
        this.value = value;
    }
    @Override
    public int compareTo(Integer i) {
        return (value < i.value) ? -1 : (value == i.value) ? 0 : 1;
    }
}
