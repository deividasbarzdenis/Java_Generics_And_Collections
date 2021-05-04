package org.designPatterns.function.Ex_9_5Type_parameter_in_a_throws_clause;

public interface Function<A, B, X extends Throwable> {
    /**
     * The Function pattern converts an arbitrary method into an object. The relation between
     * a function and the corresponding method is similar to the relation between Compara
     * tor and the compareTo method.
     * The generic version of the Function pattern demonstrates how to use a type variable
     * in the throws clause of a method declaration. This may be useful when different instances
     * of a class contain methods that may raise different checked exceptions.
     * Recall that the class Throwable has two major subclasses, Exception and Error, and that
     * the first of these has another major subclass, RuntimeException. An exception is
     * checked if it is a subclass of RuntimeException or Error. The throws clause of a method
     * may list any subclass of Throwable, but must list any checked exception that might be
     * thrown by the method body, including any checked exceptions declared for the methods invoked within the body.
     * An example of the use of a type variable in a throws clause is shown in Example 9-5.
     * The example defines an interface, Function<A, B, X>, which represents a function. The
     * interface contains a method, apply, that accepts an argument of type A, returns a result
     * of type B, and may throw an exception of type X. There is also a class Functions containing an applyAll method
     * */
    public B apply(A x) throws X;
}
