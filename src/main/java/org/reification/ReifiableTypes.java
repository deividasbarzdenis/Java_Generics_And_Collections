package org.reification;

public interface ReifiableTypes {
    /**
     *
     * In Java, we say that a type is reifiable if the type is completely represented at run time
     * — that is, if erasure does not remove any useful information. To be precise, a type is
     * reifiable if it is one of the following:
     * • A primitive type
     * (such as int)
     * • A non-parameterized class or interface type
     * (such as Number, String, or Runnable)
     * • A parameterized type in which all type arguments are unbounded wildcards
     * (such as List<?>, ArrayList<?>, or Map<?, ?>)
     * • A raw type
     * (such as List, ArrayList, or Map)
     * • An array whose component type is reifiable
     * (such as int[], Number[], List<?>[], List[], or int[][])
     * A type is not reifiable if it is one of the following:
     * • A type variable
     * (such as T)
     * • A parameterized type with actual parameters
     * (such as List<Number>, ArrayList<String>, or Map<String, Integer>)
     * • A parameterized type with a bound
     * (such as List<? extends Number> or Comparable<? super String>)
     * So the type List<? extends Object> is not reifiable, even though it is equivalent to
     * List<?>. Defining reifiable types in this way makes them easy to identify syntactically.
     *
     * */
}
