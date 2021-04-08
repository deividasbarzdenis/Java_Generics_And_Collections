package org.reification.instanceTestsAndCasts;

public class Integer extends Number{
    /**
     *
     * The equality method takes an argument of type Object, checks whether the object is
     * an instance of class Integer, and, if so, casts it to Integer and compares the values of
     * the two integers. This code works because Integer is a reifiable type: all of the information
     * needed to check whether an object is an instance of Integer is available at run
     * time.
     *
     * */
    private final int value;
    public Integer(int value) { this.value=value; }
    public int intValue() { return value; }

    public boolean equals(Object o) {
        if (o instanceof Integer) {
            return value == ((Integer)o).intValue();
        } else return false;
    }

    @Override
    public long longValue() {
        return 0;
    }

    @Override
    public float floatValue() {
        return 0;
    }

    @Override
    public double doubleValue() {
        return 0;
    }


}
