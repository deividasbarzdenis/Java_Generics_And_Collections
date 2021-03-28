package org.comparator.bridges.example3_6;

// Legacy code for comparable integers
public class Integer implements Comparable{
    /**
     * Example 3-6 shows the Comparable interface and a simplified version of the Integer
class in Java before generics. In the nongeneric interface, the compareTo method takes
an argument of type Object. In the nongeneric class, there are two compareTo methods.
The first is the naïve method you might expect, to compare an integer with another
integer. The second compares an integer with an arbitrary object: it casts the object to
an integer and calls the first method. The second method is necessary in order to override
the compareTo method in the Comparable interface, because overriding occurs only
when the method signatures are identical. This second method is called a bridge.
     **/

    private final int value;

    public Integer(int value){
        this.value = value;
    }

    public int compareTo(Integer i) {
        return (value < i.value) ? -1 : (value == i.value) ? 0 : 1;
    }

    @Override
    public int compareTo(Object obj ){
        return compareTo((Integer) obj);
    }
}
