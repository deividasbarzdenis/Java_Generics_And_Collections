package org.declarations.staticMembers;

import java.util.ArrayList;
import java.util.List;

public class Cell2<T> {
/**
 * Since the class may be used with different type parameters at different places, it makes
no sense to refer to T in the declaration of the static field values or the static method
getValues(), and these lines are reported as errors at compile time. If we want a list of
all values kept in cells, then we need to use a list of objects, as in the following variant:
 *
 **/
    private final T value;
    private static List<Object> values = new ArrayList<>(); // ok
    public Cell2(T value) { this.value=value; values.add(value); }
    public T getValue() { return value; }
    public static List<Object> getValues() { return values; } // ok

}
