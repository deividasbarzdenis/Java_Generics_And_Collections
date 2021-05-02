package org.reflection.aGenericReflectionLibrary;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

public class GenericReflection {
    /**
     * The first takes an object, finds the class of that object, and returns a new instance of
     * the class; this must have the same type as the original object. The second takes an array
     * and returns a class token for its component type, as carried in its run-time type information.
     * Conversely, the third allocates a new array with its component type specified
     * by a given class token and a specified size. The fourth takes an array and a size, and
     * allocates a new array with the same component type as the given array and the given
     * size; it simply composes calls to the previous two methods. The code for each of the
     * first three methods consists of a call to one or two corresponding methods in the Java
     * reflection library and an unchecked cast to the appropriate return type.
     * Unchecked casts are required because the methods in the Java reflection library cannot
     * return sufficiently accurate types, for various reasons. The method getComponentType
     * is in the class Class<T>, and Java provides no way to restrict the receiver type to be
     * Class<T[]> in the signature of the method (though the call raises an exception if the
     * receiver is not a class token for an array type). The method newInstance in
     * java.lang.reflect.Array must have the return type Object rather than the return type
     * T[], because it may return an array of a primitive type. The method getClass, when
     * called on a receiver of type T, returns a token not of type Class<? extends T> but of
     * type Class<?>, because of the erasure that is required to ensure that class tokens always
     * have a reifiable type. However, in each case the unchecked cast is safe, and users can
     * call on the four library routines defined here without violating the cast-iron guarantee.
     *
     * Example 7-1. A type-safe library for generic reflection
     * */
    public static <T> T newInstance(T obj)
            throws InstantiationException,
            IllegalAccessException,
            InvocationTargetException,
            NoSuchMethodException {
        Object newobj = obj.getClass().getConstructor().newInstance();
        return (T) newobj; // unchecked cast
    }

    public static <T> Class<? extends T> getComponentType(T[] a) {
        Class<?> k = a.getClass().getComponentType();
        return (Class<? extends T>) k; // unchecked cast
    }

    public static <T> T[] newArray(Class<? extends T> k, int size) {
        if (k.isPrimitive())
            throw new IllegalArgumentException
                    ("Argument cannot be primitive: " + k);
        Object a = java.lang.reflect.Array.newInstance(k, size);
        return (T[]) a; // unchecked cast
    }

    public static <T> T[] newArray(T[] a, int size) {
        return newArray(getComponentType(a), size);
    }
    /**
     * The first method uses Constructor.newInstance (in java.lang.reflect) in preference
     * to Class.newInstance, in order to avoid a known problem with the latter. To quote from
     * Sun’s documentation for Class.newInstance: “Note that this method propagates any
     * exception thrown by the nullary constructor, including a checked exception. Use of
     * this method effectively bypasses the compile-time exception checking that would otherwise
     * be performed by the compiler. The Constructor.newInstance method avoids this
     * problem by wrapping any exception thrown by the constructor in a (checked)
     * InvocationTargetException.”
     * The second method is guaranteed to be well typed in any program that obeys the
     * Principle of Indecent Exposure and the Principle of Truth in Advertising. The first
     * principle guarantees that the component type at compile time will be a reifiable type,
     * and then the second principle guarantees that the reified component type returned at
     * run time must be a subtype of the reifiable component type declared at compile time.
     * The third method raises an illegal argument exception if its class argument is a primitive
     * type. This catches the following tricky case: if the first argument is, say, int.class then
     * its type is Class<Integer>, but the new array will have type int[], which is not a subtype
     * of Integer[]. This problem would not have arisen if int.class had the type Class<?>
     * rather than Class<Integer>, as discussed in the preceding section.
     * */

   /* As an example of the use of the first method, here is a method that copies a collection
    into a fresh collection of the same kind, preserving the type of the argument*/
    public static <T, C extends Collection<T>> C copy(C coll)
            throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        C copy = GenericReflection.newInstance(coll);
        copy.addAll(coll); return copy;
    }

    /*As an example of the use of the last method, here is the toArray method of Section 6.5,
    rewritten to replace its unchecked casts by a call to the generic reflection library:*/
    public static <T> T[] toArray(Collection<T> c, T[] a) {
        if (a.length < c.size())
            a = GenericReflection.newArray(a, c.size());
        int i=0; for (T x : c) a[i++] = x;
        if (i < a.length) a[i] = null;
        return a;
    }
}
