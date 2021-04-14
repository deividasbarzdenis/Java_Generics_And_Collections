package org.reification.exceptionHandling;

/**
 * In a try statement, each catch clause checks whether the thrown exception matches a
 * given type. This is the same as the check performed by an instance test, so the same
 * restriction applies: the type must be reifiable. Further, the type in a catch clause is
 * required to be a subclass of Throwable. Since there is little point in creating a subclass
 * of Throwable that cannot appear in a catch clause, the Java compiler complains if you
 * attempt to create a parameterized subclass of Throwable.
 * */
public class IntegerException extends Exception{
    private final int value;
    public IntegerException(int value) { this.value = value; }
    public int getValue() { return value; }
}
