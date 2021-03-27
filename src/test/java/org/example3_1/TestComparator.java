package org.example3_1;

import org.comparator.example3_1.Apple;
import org.comparator.example3_1.Fruit;
import org.comparator.example3_1.Orange;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class TestComparator {

    @Test
    public void testComparator(){
        Apple a1 = new Apple(1);
        Apple a2 = new Apple(2);
        Orange o3 = new Orange(3);
        Orange o4 = new Orange(4);

        List<Apple> apples = Arrays.asList(a1, a2);
        assert max(apples).equals(a2);

        List<Orange> oranges = Arrays.asList(o3, o4);
        assert max(oranges).equals(o4);

        List<Fruit> mixed = Arrays.asList(a1, o3);
        assert max(mixed).equals(o3);
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
}
