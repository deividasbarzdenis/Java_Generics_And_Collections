package org.example3_3;

import org.junit.Test;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class TestComparator {

    @Test
    public void testMinMax(){

    }

    // define a comparator that provides the natural ordering:
    public static<T extends Comparable<? super T>> Comparator<T> naturalOrder(){
        return new Comparator<T>() {
            public int compare(T o1, T o2) {
                return o1.compareTo(o2);
            }
        };
    }

    // Here is the code for a version of max using comparators:
    public static <T> T max(Collection<? extends T> coll, Comparator<? super T> cmp){
        T candidate = coll.iterator().next();
        for(T elt : coll ){
            if(cmp.compare(candidate, elt) < 0){
                candidate = elt;
            }
        }
        return candidate;
    }

    // Using this, it easy to define the version of max that uses the natural ordering
    // in terms of the version that uses a given comparator:
    public static <T extends Comparable<? super T>> T max(Collection<? extends T> coll){
        return max(coll, Comparator.<T>naturalOrder());
    }
    // Method that takes a comparator and returns a new comparator with the reverse
    // of the given ordering:
    public static <T> Comparator<T> reverseOrder(final Comparator<T> cmp){
        return new Comparator<T>(){
          public int compare(T o1, T o2){
              return cmp.compare(o2, o1);
          }
        };
    }
    // Method that returns the reverse of the natural ordering:
    public static <T extends Comparable<? super T>> Comparator<T> reverseOrder(){
        return new Comparator<T>(){
            public int compare(T o1, T o2){
                return o2.compareTo(o1);
            }
        };
    }

    //Finally we can define the two versions of min in terms of the two versions
    // of max by using the two versions of reverseOrder:
    public static <T> T min(Collection<? extends T> coll, Comparator<? super T> cmp){
        return max(coll, reverseOrder(cmp));
    }
    public static <T extends  Comparable<? super T>> T min(Collection<? extends T> coll){
        return max(coll, reverseOrder());
    }
    // Method takes a comparator on elements and returns a comparator on lists of elements:
    public static <E> Comparator<List<E>> listComparator(final Comparator<? super E> comp){
        return new Comparator<List<E>>(){
            public int compare(List<E> list1, List<E> list2){
                int n1 = list1.size();
                int n2 = list2.size();
                for(int i=0; i<Math.min(n1, n2); i++){
                    int k = comp.compare(list1.get(i), list2.get(i));
                    if (k != 0) return k;
                }
                return (n1 < n2) ? -1 : (n1 == n2) ? 0 : 1;
            }
        };
    }
}
