package org.reification.arrayCreationAndVarargs;

import java.util.AbstractList;
import java.util.Collection;
import java.util.RandomAccess;

public class ArrayList<E> extends AbstractList<E> implements RandomAccess {
/**
 * The convenient vararg notation allows methods to accept a variable number of arguments and packs them into an array,
 * as discussed in Section 1.4. This notation is not
 * as convenient as you might like, because the arrays it creates suffer from the same issues
 * involving reification as other arrays
 * */
    private E[] arr;
    private int size = 0;
    public ArrayList(int cap) {
        if (cap < 0)
            throw new IllegalArgumentException("Illegal Capacity: "+cap);
        arr = (E[])new Object[cap]; // unchecked cast
    }
    public ArrayList() {
        this(10);
    }
    public ArrayList(Collection<? extends E> c) {
        this(c.size()); addAll(c);
    }
    public void ensureCapacity(int mincap) {
        int oldcap = arr.length;
        if (mincap > oldcap) {
            int newcap = Math.max(mincap, (oldcap*3)/2+1);
            E[] oldarr = arr;
            arr = (E[])new Object[newcap]; // unchecked cast
            System.arraycopy(oldarr,0,arr,0,size);
        }
    }
    public int size() {
        return size;
    }
    private void checkBounds(int i, int size) {
        if (i < 0 || i >= size)
            throw new IndexOutOfBoundsException("Index: "+i+", Size: "+size);
    }
    public E get(int i) {
        checkBounds(i,size); return arr[i];
    }

    public E set(int i, E elt) {
        checkBounds(i,size); E old = arr[i]; arr[i] = elt; return old;
    }
    public void add(int i, E elt) {
        checkBounds(i,size+1); ensureCapacity(size+1);
        System.arraycopy(arr,i,arr,i+1,size-i); arr[i] = elt; size++;
    }
    public E remove(int i) {
        checkBounds(i,size); E old = arr[i]; arr[i] = null; size--;
        System.arraycopy(arr,i+1,arr,i,size-i); return old;
    }
    public <T> T[] toArray(T[] a) {
        if (a.length < size)
            a = (T[])java.lang.reflect.Array. // unchecked cast
                    newInstance(a.getClass().getComponentType(), size);
        System.arraycopy(arr,0,a,0,size);
        if (size < a.length) a[size] = null;
        return a;
    }
    public Object[] toArray() {
        return toArray(new Object[0]);
    }
    /**
     * In Section 1.4 we discussed the method java.util.Arrays.asList, which is declared as
     * follows:
     * public static <E> List<E> asList(E... arr)
     *
     * For instance, here are three calls to this method:
     * List<Integer> a = Arrays.asList(1, 2, 3);
     * List<Integer> b = Arrays.asList(4, 5, 6);
     * List<List<Integer>> x = Arrays.asList(a, b); // generic array creation
     *
     * Recall that an argument list of variable length is implemented by packing the arguments
     * into an array and passing that. Hence these three calls are equivalent to the following:
     *
     * List<Integer> a = Arrays.asList(new Integer[] { 1, 2, 3 });
     * List<Integer> b = Arrays.asList(new Integer[] { 4, 5, 6 });
     * List<List<Integer>> x
     * = Arrays.asList(new List<Integer>[] { a, b }); // generic array creation
     *
     * The first two calls are fine, but since List<Integer> is not a reifiable type, the third
     * warns of an unchecked generic array creation at compile time
     *
     * This warning can be confusing, particularly since that line of source code does not
     * contain an explicit instance of array creation!
     * A similar problem occurs if one attempts to create a list of a generic type. Here is a
     * method that uses Arrays.asList to create a list of length one containing a given element:
     *
     * public static List<E> singleton(E elt) {
     * return Arrays.asList(elt); // generic array creation
     * }
     *
     * This also generates a warning, which can be confusing for the same reasons.
     * Normally, generic array creation reports an error. As a workaround, one can create the
     * array at a reifiable type and perform an unchecked cast. That workaround is not available for the array creation
     * that is implicit in the use of varargs, so in this case generic
     * array creation issues a warning rather than an error. A generic array creation warning
     * is just like an unchecked warning, in that it invalidates the cast-iron guarantee that
     * accompanies generics. It is not too difficult to take each of the previous examples where
     * a mishap occurs as the result of an unchecked warning, and create a similar example
     * using varargs where a generic array creation warning is issued instead.
     * In our opinion, the convenience offered by varargs is outweighed by the danger inherent
     * in unchecked warnings, and we recommend that you never use varargs when the argument is of a nonreifiable type.
     * For instance, in both of the preceding examples, instead of using Arrays.asList, we would have created a new
     * ArrayList and used the
     * add method, even though this is less convenient and less efficient.
     * The need for generic array creation warnings and the associated workarounds would
     * not have arisen if the vararg notation had been defined to pack arguments into a list
     * rather than an array, taking T… to be equivalent to List<T> rather than T[]. Unfortunately, the vararg notation
     * was designed before this problem was fully understood.*/
}
