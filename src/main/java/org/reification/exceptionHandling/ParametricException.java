package org.reification.exceptionHandling;

public class ParametricException<T>{
}
/**
 * In contrast, the following definition of a new exception is prohibited, because it creates
 * a parameterized type:
 *
 * class ParametricException<T> extends Exception { // compile-time error
 * private final T value;
 * public ParametricException(T value) { this.value = value; }
 * public T getValue() { return value; }
 * }
 * An attempt to compile the above reports an error:
 * % javac ParametricException.java
 * ParametricException.java:1: a generic class may not extend
 * java.lang.Throwable
 * class ParametricException<T> extends Exception { // compile-time error
 * ^
 *
 * 1 error
 * This restriction is sensible because almost any attempt to catch such an exception must
 * fail, because the type is not reifiable. One might expect a typical use of the exception
 * to be something like the following:
 *
 * class ParametricExceptionTest {
 * public static void main(String[] args) {
 * try {
 * throw new ParametricException<Integer>(42);
 * } catch (ParametricException<Integer> e) { // compile-time error
 * assert e.getValue()==42;
 * }
 * }
 * }
 * */

/**
 * Type Variable in a Throws Clause Although subclasses of Throwable cannot be parametric, it is possible to
 * use a type variable in the throws clause of a method declaration
 * */
