package org.reification.thePrincipleOfTruthInAdvertising;

import java.util.Collection;

public class Right {
    /**
     * The Principle of Truth in Advertising: the reified type of an array must be a subtype
     * of the erasure of its static type.
     * The principle is obeyed within the body of toArray itself, where the erasure of T is
     * Object, but not within the main method, where T has been bound to String but the
     * reified type of the array is still Object.
     * Before we see how to create arrays in accordance with this principle, there is one more
     * point worth stressing. Recall that generics for Java are accompanied by a cast-iron
     * guarantee: no cast inserted by erasure will fail, so long as there are no unchecked warnings.
     * The preceding principle illustrates the converse: if there are unchecked warnings,
     * then casts inserted by erasure may fail. Further, the cast that fails may be in a different
     * part of the source code than was responsible for the unchecked warning! This is why code
     * that generates unchecked warnings must be written with extreme care.
     * Array Begets Array “Tis money that begets money,” said Thomas Fuller in 1732,
     * observing that one way to get money is to already have money. Similarly, one way to
     * get a new array of a generic type is to already have an array of that type. Then the reified
     * type information for the new array can be copied from the old.
     * We therefore alter the previous method to take two arguments, a collection and an
     * array. If the array is big enough to hold the collection, then the collection is copied into
     * the array. Otherwise, reflection is used to allocate a new array with the same reified
     * type as the old, and then the collection is copied into the new array.*/
    public static <T> T[] Array(Collection<T> c, T[] a) {
        if (a.length < c.size())
            a = (T[]) java.lang.reflect.Array. // unchecked cast
                    newInstance(a.getClass().getComponentType(), c.size());
        int i = 0;
        for (T x : c) a[i++] = x;
        if (i < a.length) a[i] = null;
        return a;
    }
    /**
     * This uses three methods from the reflection library to allocate a new array with the
     * same component type as the old array: the method getClass (in java.lang.Object)
     * returns a Class object representing the array type, T[]; the method getComponentType
     * (from java.lang.Class) returns a second Class object representing the array’s component type, T;
     * and the method newInstance (in java.lang.reflect.Array) allocates a new
     * array with the given component type and size, again of type T[]. The result type of the
     * call to newInstance is Object, so an unchecked cast is required to cast the result to the
     * correct type T[].
     * In Java 5, the class Class has been updated to a generic class Class<T>; more on this
     * shortly.
     * (A subtle point: in the call to newInstance, why is the result type Object rather than
     * Object[]? Because, in general, newInstance may return an array of a primitive type such
     * as int[], which is a subtype of Object but not of Object[]. However, that won’t happen
     * here because the type variable T must stand for a reference type.)
     * The size of the new array is taken to be the size of the given collection. If the old array
     * is big enough to hold the collection and there is room left over, a null is written just
     * after the collection to mark its end.
     * The test code creates a list of strings of length two and then performs two demonstration
     * calls. Neither encounters the problem described previously, because the returned array
     * has the reified type String[], in accordance with the Principle of Truth in Advertising.
     * The first call is passed an array of length zero, so the list is copied into a freshly allocated
     * array of length two. The second call is passed an array of length four, so the list is copied
     * into the existing array, and a null is written past the end; the original array content after
     * the null is not affected. The utility method toString (in java.util.Arrays) is used to
     * convert the array to a string in the assertions.*/
}
