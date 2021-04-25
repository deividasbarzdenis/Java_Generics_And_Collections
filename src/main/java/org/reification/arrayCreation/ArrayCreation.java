package org.reification.arrayCreation;

public class ArrayCreation {
    /**
     *Arrays reify their component types, meaning that they carry run-time information about
     * the type of their components. This reified type information is used in instance tests and
     * casts, and also used to check whether assignments into array components are permitted.
     *
     * Integer[] ints = new Integer[] {1,2,3};
     * Number[] nums = ints;
     * nums[2] = 3.14; // array store exception
     *
     * The first line allocates a new array, with reified type information indicating that it is an
     * array of integers. The second line assigns this array to a variable containing an array of
     * numbers; this is permitted because arrays, unlike generic types, are covariant. The assignment on the third line
     * raises an array store exception at run time because the assigned value is of type double, and this is not
     * compatible with the reified type attached
     * to the array.
     * Because arrays must reify their component types, it is an error to create a new array
     * unless its component type is reifiable. The two main problems you are likely to encounter are when the type of
     * the array is a type variable, and when the type of the array
     * is a parameterized type.
     * Consider the following (incorrect) code to convert a collection to an array:
     *
     * import java.util.*;
     * class Annoying {
     * public static <T> T[] toArray(Collection<T> c) {
     * T[] a = new T[c.size()]; // compile-time error
     * int i=0; for (T x : c) a[i++] = x;
     * return a;
     * }
     * }
     *
     * This is an error, because a type variable is not a reifiable type. An attempt to compile
     * this code reports a generic array creation error:
     *
     * % javac Annoying.java
     * Annoying.java:4: generic array creation
     * T[] a = new T[c.size()]; // compile-time error
     * ^
     * 1 error
     * We discuss workarounds for this problem shortly.
     * As a second example, consider the following (incorrect) code that returns an array
     * containing two lists:
     *
     * import java.util.*;
     * class AlsoAnnoying {
     * public static List<Integer>[] twoLists() {
     * List<Integer> a = Arrays.asList(1,2,3);
     * List<Integer> b = Arrays.asList(4,5,6);
     * return new List<Integer>[] {a, b}; // compile-time error
     * }
     * }
     *
     * This is an error, because a parameterized type is not a reifiable type. An attempt to
     * compile this code also reports a generic array creation error:
     *
     * % javac AlsoAnnoying.java
     * AlsoAnnoying.java:6: generic array creation
     * return new List<Integer>[] {a, b}; // compile-time error
     * ^
     * 1 error
     * We also discuss workarounds for this problem shortly.
     * Inability to create generic arrays is one of the most serious restrictions in Java. Because
     * it is so annoying, it is worth reiterating the reason it occurs: generic arrays are problematic because generics
     * are implemented via erasure, but erasure is beneficial because
     * it eases evolution.
     * The best workaround is to use ArrayList or some other class from the Collections
     * Framework in preference to an array. We discussed the tradeoffs between collection
     * classes and arrays in Section 2.5, and we noted that in many cases collections are preferable to arrays:
     * because they catch more errors at compile time, because they provide
     * more operations, and because they offer more flexibility in representation. By far, the
     * best solution to the problems offered by arrays is to “just say no”: use collections in
     * preference to arrays.
     * Sometimes this won’t work, because you need an array for reasons of compatibility or
     * efficiency. Examples of this occur in the Collections Framework: for compatibility, the
     * method toArray converts a collection to an array; and, for efficiency, the class Array
     * List is implemented by storing the list elements in an array. We discuss both of these
     * cases in detail in the following sections, together with associated pitfalls and principles
     * that help you avoid them: the Principle of Truth in Advertising and the Principle of
     * Indecent Exposure. We also consider problems that arise with varargs and generic array
     * creation.*/
}
