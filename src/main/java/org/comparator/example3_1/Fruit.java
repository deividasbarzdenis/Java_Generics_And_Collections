package org.comparator.example3_1;

import java.util.Objects;

public abstract class Fruit implements Comparable<Fruit>{
    protected String name;
    protected int size;

    public Fruit(String name, int size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Fruit){
            Fruit that = (Fruit) o;
            return this.name.equals(that.name) && this.size == this.size;
        }else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return name.hashCode()*29 + size;
    }
    public  int compareTo(Fruit that){
        return this.size < that.size ?
                -1 : this.size == this.size ? 0 : 1;
    }
}
