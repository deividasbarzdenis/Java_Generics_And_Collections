package org.collections.The_Collection_Interface.Ex12_2.Merging_collections_using_natural_ordering;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class MergeCollections {
    static <T extends Comparable<? super T>>
    List<T> merge(Collection<? extends T> c1, Collection<? extends T> c2) {
        List<T> mergedList = new ArrayList<T>();
        Iterator<? extends T> itr1 = c1.iterator();
        Iterator<? extends T> itr2 = c2.iterator();
        T c1Element = getNextElement(itr1);
        T c2Element = getNextElement(itr2);
        // each iteration will take a task from one of the iterators;
        // continue until neither iterator has any further tasks
        while (c1Element != null || c2Element != null) {
            // use the current c1 element if either the current c2
            // element is null, or both are non-null and the c1 element
            // precedes the c2 element in the natural order
            boolean useC1Element = c2Element == null ||
                    c1Element != null && c1Element.compareTo(c2Element) < 0;
            if (useC1Element) {
                mergedList.add(c1Element);
                c1Element = getNextElement(itr1);
            } else {
                mergedList.add(c2Element);
                c2Element = getNextElement(itr2);
            }
        }
        return mergedList;
    }

    static <E> E getNextElement(Iterator<E> itr) {
        if (itr.hasNext()) {
            E nextElement = itr.next();
            if (nextElement == null) throw new NullPointerException();
            return nextElement;
        } else {
            return null;
        }
    }
    /**
     * For another example, suppose we are fastidious people that like to keep all our lists of
     * tasks in ascending order, and we want to merge two lists of tasks into a single list, while
     * maintaining the order. Example 12-2 shows how we can merge two collections into a
     * third, provided that the iterators of each return their elements ascending in natural
     * order. This method relies on the fact that the collections to be merged contain no
     * null elements; if one is encountered, the method throws a NullPointerException. As it
     * happens, the collections mondayTasks and tuesdayTasks in Example 12-1 are both in
     * ascending order, and we can merge them as follows:
     * Collection<Task> mergedTasks =
     * MergeCollections.merge(mondayTasks, tuesdayTasks);
     * assert mergedTasks.toString().equals(
     * "[code db, code gui, code logic, phone Mike, phone Paul]");
     * */
}
