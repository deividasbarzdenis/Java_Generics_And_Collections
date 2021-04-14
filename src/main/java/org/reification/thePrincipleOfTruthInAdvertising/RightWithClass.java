package org.reification.thePrincipleOfTruthInAdvertising;

import java.util.Collection;

public class RightWithClass {
    public static <T> T[] toArray(Collection<T> c, Class<T> k) {
        T[] a = (T[]) java.lang.reflect.Array. // unchecked cast
                newInstance(k, c.size());
        int i = 0;
        for (T x : c) a[i++] = x;
        return a;
    }
    /**
     * A Classy Alternative Some days it may seem that the only way to get money is to have
     * money. Not quite the same is true for arrays. An alternative to using an array to create
     * an array is to use an instance of class Class.
     * Instances of the class Class represent information about a class at run time; there are
     * also instances of this class that represent primitive types and arrays. In this text, we will
     * refer to instances of the Class class as class tokens.
     * In Java 5, the class Class has been made generic, and now has the form Class<T>. What
     * does the T stand for? An instance of type Class<T> represents the type T. For example,
     * String.class has type Class<String>.
     * We can define a variant of our previous method that accepts a class token of type
     * Class<T> rather than an array of type T[]. Applying newInstance to a class token of type
     * Class<T> returns a new array of type T[], with the component type specified by the class
     * token. The newInstance method still has a return type of Object (because of the same
     * problem with primitive arrays), so an unchecked cast is still required.
     * The conversion method is now passed the class token String.class rather than an array
     * of strings.
     * */
}
