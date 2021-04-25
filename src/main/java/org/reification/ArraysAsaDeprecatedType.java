package org.reification;

public interface ArraysAsaDeprecatedType {
    /**
     * We have seen that collections are superior to arrays in a number of ways:
     * • Collections provide more precise typing than arrays. With lists, one can write
     * List<T>, List<? extends T>, or List<? super T>; whereas with arrays, one can only
     * write T[], which corresponds to the second of the three options for lists. Moreprecise typing enables more errors
     * to be detected at compile time rather than run
     * time. This makes coding, debugging, testing, and maintenance easier, and also
     * improves efficiency. (See Section 2.5.)
     * • Collections are more flexible than arrays. Collections offer a variety of representations, including arrays,
     * linked lists, trees, and hash tables, whereas arrays have a
     * fixed representation, and the libraries offer a larger variety of methods and convenience algorithms on
     * collections than on arrays. (See Section 2.5.)
     * • Collections may have elements of any type, whereas arrays should only have components of reifiable type.
     * When creating an array, one must adhere to the Principle
     * of Truth in Advertising—the reified type must conform to the static type—and the
     * Principle of Indecent Exposure—never publicly expose an array where the components do not have reifiable type.
     * (See Sections Section 6.5 and Section 6.6).
     * In retrospect, there are several places in Java 5 where avoiding the use of arrays might
     * have improved the design:
     * Variable-length arguments (varargs) are represented by an array, and so are subject
     * to the same restrictions. If a vararg is bound to actual arguments of nonreifiable
     * type then a generic array creation warning is issued (which raises the same concerns
     * as an unchecked warning). For instance, the function Arrays.asList takes a vararg. There is no difficulty in applying this function to return a result of type
     * List<Integer>, but it is problematic to create a result of type List<List<Inte
     * ger>> or of type List<E>. This problem would not arise if lists had been used in
     * preference to arrays. (See Section 6.8.)
     * • Some methods in the Java library have signatures that violate the Principle of Indecent Exposure:
     * TypeVariable<Class<T>>[] java.lang.Class.getTypeParameters()
     * TypeVariable<Method>[] java.lang.Reflect.Method.getTypeParameters()
     * It is possible for code that invokes these methods to violate the cast-iron guarantee
     * that accompanies generics: it may raise a class cast exception where there is no
     * explicit cast in the code, even though no unchecked warning is issued by the compiler. (A warning was issued—and
     * wrongly ignored—when the library was compiled.) Again, this problem would not arise if lists had been used in
     * preference to
     * arrays. (See Section 6.6.)
     * One reason for some of the complexities in the Java 5 design was to provide good
     * support for the use of arrays. In retrospect, it might have been better to choose a design
     * that was simpler, but made arrays not quite as convenient to use:
     * • Arrays must be created with components of reifiable type, so some attempt was
     * made to make the notion of reifiable type as general as possible in order to minimize
     * this restriction. If the designers had been willing to restrict the notion of reified
     * type, they could have simplified it by including raw types (such as List), but excluding types with unbounded
     * wildcards (such as List<?>). Had they done so,
     * reifiable types would have become synonymous with unparameterized types (that
     * is, primitive types, raw types, and types declared without a type parameter).
     * This changewould simplify the types permitted in an instance test. Consider the
     * following three tests:
     * obj instanceof List
     * obj instanceof List<?>
     * obj instanceof List<? extends Object>
     * Currently, the first two are permitted, but the third is not. With the proposed
     * restriction, only the first would be permitted. Arguably, this might be easier to
     * understand. It would also be consistent with the treatment of class tokens, since
     * currently List.class is permitted but List<?>.class is illegal.
     * • Currently, array creation is restricted to arrays of reifiable type. But it is permitted
     * to declare an array of nonreifiable type or to cast to an array type that is not reifiable,
     * at the cost of an unchecked warning somewhere in the code. As we have seen, such
     * warnings violate the cast-iron guarantee that accompanies generics, and may lead
     * to class cast errors even when the source code contains no casts.
     * A simpler and safer design would be to outlaw any reference to an array of nonreifiable type (using the simpler form of reifiable type just described). This design
     * would mean that one could never declare an array of type E[], where E is a type
     * variable.
     * This change would make it more complicated to implement ArrayList<E> (or similar classes). The type of the private variable must change from E[] to Object[],
     * and you must add an unchecked cast (E) to the result of get and similar methods.
     * But the complication is small, and arises only for the implementor of ArrayList (or
     * similar classes), not for the clients.
     * This change would also mean that you could not assign a generic type to the
     * toArray method for collections (or similar methods). Instead of:
     * public <T> T[] toArray(T[] arr)
     * we would have:
     * public Object[] toArray(Object[] arr)
     * and many uses of this method would require an explicit cast of the result. This does
     * make life more awkward for users, but arguably the improvement to simplicity and
     * safety would be worth it.
     * • The preceding changes would mean that often one would use lists in preference to
     * arrays. Use of lists could be made easier by permitting Java programmers to write
     * l[i] as an abbreviation for l.get(i), and l[i] = v as an abbreviation for
     * l.put(i,v). (Some people like this sort of “syntactic sugar,” while others think of
     * it as “syntactic rat poison.”)
     * Some of these changes can still be adapted in a backward compatible manner.We
     * mentioned in Section 6.8 that it may be desirable to add a second form of vararg based
     * on lists rather than arrays. Permitting abbreviations to make list indexing look like array
     * indexing could easily be incorporated in a future version of Java.
     * But the window for some of these changes has closed. Too many users have written
     * code with generic toArrays to permit reverting to the nongeneric version. Nonetheless,
     * it seems worthwhile to record this alternate design. Perhaps understanding how the
     * current design might have been simpler can lead to better insight and a better future
     * design.
     * Just as the Java 5 design might have been improved if it had put less emphasis on arrays,
     * your own code designs may be improved if you use collections and lists in preference
     * to arrays. Perhaps the time has come to regard arrays as a deprecated type?
     * */
}
