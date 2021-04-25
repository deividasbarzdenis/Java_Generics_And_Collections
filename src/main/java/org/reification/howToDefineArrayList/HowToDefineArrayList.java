package org.reification.howToDefineArrayList;

public class HowToDefineArrayList {
    /**
     * We have argued elsewhere that it is usually preferable to use a list than to use an array.
     * There are a few places where this is not appropriate. In rare circumstances, you will
     * need to use an array for reasons of efficiency or compatibility. Also, of course, you need
     * to use arrays to implement ArrayList itself. Here we present the implementation of
     * ArrayList as a model of what to do in the rare circumstance where you do need to use
     * an array. Such implementations need to be written with care, as they necessarily involve
     * use of unchecked casts. We will see how the Principles of Indecent Exposure and of
     * Truth in Advertising figure in the implementation.
     * Example 6-2 shows the implementation. We have derived ArrayList by subclassing
     * from AbstractList. Classes derived from this class need to define only four methods,
     * namely get, set, add, and remove; the other methods are defined in terms of these.We
     * also indicate that the class implements RandomAccess, indicating that clients of the class
     * will have more efficient access using get than using the list iterator.
     * The class represents a list with elements of type E by two private fields: size of type
     * int containing the length of the list, and arr of type E[] containing the elements of
     * the list. The array must have a length at least equal to size, but it may have additional
     * unused elements at the end.
     * There are two places where new instances of the array are allocated, one in the initializer
     * for the class and one in the method that increases the array capacity (which in turn is
     * called from the add method). In both places, the array is allocated as an Object[] and
     * an unchecked cast is made to type E[].
     * It is essential that the field containing the array is private; otherwise, it would violate
     * both the Principle of Truth in Advertising and the Principle of Indecent Exposure. It
     * would violate the Principle of Truth in Advertising because E might be bound to a type
     * (such as String) other than Object. It would violate the Principle of Indecent Exposure
     * because E might be bound to a type (such as List<Integer>) that is not a reifiable type.
     * However, neither of these principles is violated because the array is not public: it is
     * stored in a private field, and no pointer to the array escapes from the class.We might
     * call this the Principle of Anything Goes Behind Closed Doors.
     * The way we’ve defined ArrayList here is close to the actual definition in the source
     * released by Sun. Recently, Neal Gafter, the coauthor of that library, has argued that he
     * used bad style—that it would have been better to declare the private array to have type
     * Object[] and use casts to type (E) when retrieving elements from the array. There is
     * something to be said for this point, although there is also something to be said for the
     * style we have used here, which minimizes the need for unchecked casts.
     * The method toArray does return an array in public, but it uses the techniques described
     * in Section 6.5 in accordance with the Principle of Truth in Advertising. As before, there
     * is an argument array, and if it is not big enough to hold the collection, then reflection
     * is used to allocate a new array with the same reified type. The implementation is similar
     * to the one we saw earlier, except that the more efficient arraycopy routine can be used
     * to copy the private array into the public array to be returned*/
}
