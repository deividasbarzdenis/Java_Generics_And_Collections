package org.reflection.reflectionForGenerics;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionForGenerics {
    /**
     * Generics change the reflection library in two ways. We have discussed generics for
     * reflection, where Java added a type parameter to the class Class<T>. We now discuss
     * reflection for generics, where Java adds methods and classes that support access to
     * generic types.
     * Example 7-2 shows a simple demonstration of the use of reflection for generics. It uses
     * reflection to find the class associated with a given name, and it prints out the fields,
     * constructors, and methods associated with the class, using the reflection library classes
     * Field, Constructor, and Method. Two different methods are available for converting a
     * field, constructor, or method to a string for printing: the old toString method and the
     * new toGenericString method. The old method is maintained mainly for backward
     * compatibility. A small sample class is shown in Example 7-3, and a sample run with
     *
     * this class is shown in Example 7-4.
     * */
    public static void toString(Class<?> k) {
        System.out.println(k + " (toString)");
        for (Field f : k.getDeclaredFields())
            System.out.println(f.toString());
        for (Constructor c : k.getDeclaredConstructors())
            System.out.println(c.toString());
        for (Method m : k.getDeclaredMethods())
            System.out.println(m.toString());
        System.out.println();
    }
    public static void toGenericString(Class<?> k) {
        System.out.println(k + " (toGenericString)");
        for (Field f : k.getDeclaredFields())
            System.out.println(f.toGenericString());
        for (Constructor c : k.getDeclaredConstructors())
            System.out.println(c.toGenericString());
        for (Method m : k.getDeclaredMethods())
            System.out.println(m.toGenericString());
        System.out.println();
    }
    public static void main (String[] args)
            throws ClassNotFoundException {
        for (String name : args) {

            Class<?> k = Class.forName(name);
            toString(k);
            toGenericString(k);
        }
    }
}
