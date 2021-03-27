package org.example;

import org.junit.Test;

import java.util.*;

public class ComparisonAndBounds {

    //For Comparable interface you cannot choose Number, because it does not implement
    @Test
    public void testMaxMethod() {
        List<Integer> ints = Arrays.asList(1, 2, 3, 4);
        assert max(ints) == 4;
    }

    @Test
    public void testMax1Method() {
        List<String> strings = Arrays.asList("zero", "one", "two");
        assert maxEfficient(strings).equals("zero");
    }


    //Type variables must always be bounded using "extends", never "super"
    //Here is code to find the maximum element in a nonempty collection, from the class Collections:
    private static <T extends Comparable<? super T>> T max(Collection<T> coll) {
        T candidate = coll.iterator().next();
        for (T elt : coll) {
            if (candidate.compareTo(elt) < 0) {
                candidate = elt;
            }
        }
        return candidate;
    }

    // Efficiency tip of max() method. The preceding implementation used a foreach loop to increase brevity and clarity
    // If efficiency is a pressing concern, you might want to rewrite the method to use an explicit iterator
    // Signatures for methods should be as general as possible to maximize utility . If you can replace a type parameter
    // with a wildcard then you should do so. We can improve the Signature of max by:
    private <T extends Comparable<? super T>> T maxEfficient(Collection<? extends T> coll) {
        Iterator<? extends T> it = coll.iterator();
        T candidate = it.next();
        while (it.hasNext()) {
            T elt = it.next();
            if (candidate.compareTo(elt) < 0) {
                candidate = elt;
            }
        }
        return candidate;
    }

}

// COMPARABLE INTERFACE IS CALLED THE NATURAL ORDERING, SO THE COMPARATOR INTERFACE PROVIDES AN UNNATURAL ORDERING