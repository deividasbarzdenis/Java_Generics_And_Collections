package org.reification.thePrincipleOfIndecentExposure;

import java.util.Arrays;
import java.util.List;

public class InnocentClient {
    public static void main(String[] args) {
        List<Integer>[] intLists = DeceptiveLibrary.intLists(1);
        List<? extends Number>[] numLists = intLists;
        numLists[0] = Arrays.asList(1.01);
        int i = intLists[0].get(0); // class cast error!

    }
    /**
     * As in the previous section, this error message may be confusing, since that line does
     * not appear to contain a cast!
     * In order to avoid this problem, you must stick to the following principle:
     * Principle of Indecent Exposure: never publicly expose an array where the components do not have a reifiable type.
     * Again, this is a case where an unchecked cast in one part of the program may lead to a
     * class cast error in a completely different part, where the cast does not appear in the
     * source code but is instead introduced by erasure. Since such errors can be extremely
     * confusing, unchecked casts must be used with extreme caution.
     * The Principle of Truth in Advertising and the Principle of Indecent Exposure are closely
     * linked. The first requires that the run-time type of an array is properly reified, and the
     * second requires that the compile-time type of an array must be reifiable.
     * It has taken some time for the importance of the Principle of Indecent Exposure to be
     * understood, even among the designers of generics for Java. For example, the following
     * two methods in the reflection library violate the principle:
     * TypeVariable<Class<T>>[] java.lang.Class.getTypeParameters()
     * TypeVariable<Method>[] java.lang.Reflect.Method.getTypeParameters()
     *
     * Following the preceding model, it is not hard to create your own version of Innocent
     * Client that throws a class cast error at a point where there is no cast, where in this case
     * the role of DeceptiveLibrary is played by the official Java library! (At the time of going
     * to press, remedies for this bug are under consideration. Possible fixes are to delete the
     * type parameter from TypeVariable so that the methods return an array of reified type,
     * or to replace the arrays with lists.)
     *
     * Don’t get caught out in the same way—be sure to follow the Principle of Indecent
     * Exposure rigorously in your own code!*/
}
