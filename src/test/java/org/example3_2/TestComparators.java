package org.example3_2;

import org.comparator.example3_2.Apple;
import org.comparator.example3_2.Fruit;
import org.comparator.example3_2.Orange;
import org.junit.Test;

import java.util.*;

public class TestComparators {
    @Test
    public void testComparator() {
        Apple a1 = new Apple(1);
        Apple a2 = new Apple(2);
        Orange o3 = new Orange(3);
        Orange o4 = new Orange(4);

        List<Apple> apples = Arrays.asList(a1, a2);
        assert max(apples).equals(a2);

        List<Orange> oranges = Arrays.asList(o3, o4);
        assert max(oranges).equals(o4);

//        List<Fruit> mixed = Arrays.asList(a1, o3);  //compile time error
//        assert max(mixed).equals(o3);
    }
    @Test
    public void testComparatorString() {
        assert "two".compareTo("three") > 0;
        assert sizeOrder.compare("two", "three") < 0;
    }

    private <T extends Comparable<? super T>> T max(Collection<? extends T> coll) {
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

    //Here is a comparator that considers the shorter of two strings to be smaller. Only if two strings have same
    // length are they compared using the natural (alphabetic) ordering:
    private Comparator<String> sizeOrder = new Comparator<String>() {
        @Override
        public int compare(String s1, String s2) {
            return
                    s1.length() < s2.length() ? -1 :
                            s1.length() > s2.length() ? 1 :
                                    s1.compareTo(s2);

        }
    };
}
