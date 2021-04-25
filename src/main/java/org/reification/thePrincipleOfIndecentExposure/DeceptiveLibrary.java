package org.reification.thePrincipleOfIndecentExposure;

import java.util.Arrays;
import java.util.List;

public class DeceptiveLibrary {
    /**
     * Although it is an error to create an array with a component type that is not reifiable, it
     * is possible to declare an array with such a type and to perform an unchecked cast to
     * such a type. These features must be used with extreme caution, and it is worthwhile to
     * understand what can go wrong if they are not used properly. In particular, a library
     * should never publicly expose an array with a nonreifiable type.
     * This assigns an array of lists of integers to an array of lists of numbers, and then attempts
     * to store a list of doubles into the array of lists of numbers. This time the attempted store
     * does not fail, even though it should, because the check against the reified type is inadequate: the reified
     * information contains only the erasure of the type, indicating that it
     * is an array of List, not an array of List<Integer>. Hence the store succeeds, and the
     * program fails unexpectedly elsewhere.
     *
     * Example 6-1. Avoid arrays of nonreifiable type:
     * */
    public static List<Integer>[] intLists(int size) {
        List<Integer>[] intLists =
                (List<Integer>[]) new List[size]; // unchecked cast
        for (int i = 0; i < size; i++)
            intLists[i] = Arrays.asList(i+1);
        return intLists;
    }
}
