package org.comparator.example3_3;

import java.util.Collection;
import java.util.Comparator;

public class Comparators {
    public static <T> T max(Collection<? extends T> coll, Comparator<? super T> cmp){
        T candidate = coll.iterator().next();
        for(T elt : coll){
            if(cmp.compare(candidate, elt) < 0){
                candidate = elt;
            }
        }
        return candidate;
    }
    public static <T extends Comparable<? super T>> T max(Collection<? extends T> coll){
        return max(coll, naturalOrder());
    }

    public static <T> T min(Collection<? extends T> coll, Comparator<? super T> cmp){
        return max(coll, reverseOrder(cmp));
    }

     private static <T extends Comparable<? super T>> Comparator<T> naturalOrder() {
        return new Comparator<T>(){
            public int compare(T o1, T o2){
                return o1.compareTo(o2);
            }
        };
    }

    private static <T> Comparator<T> reverseOrder(final Comparator<T> cmp) {
        return new Comparator<T>(){
            public int compare(T o1, T o2){
                return cmp.compare(o1,o2);
            }
        };
    }

    public static <T extends Comparable<? super T>> Comparator<T> reverseOrder(){
        return new Comparator<T>() {
            public int compare(T o1, T o2){
                return o2.compareTo(o2);
            }
        };
    }

}
