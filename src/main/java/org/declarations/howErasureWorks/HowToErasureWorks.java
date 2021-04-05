package org.declarations.howErasureWorks;

public class HowToErasureWorks {
    /**
     Generics were introduced to the Java language to provide tighter type checks at compile time and to support generic
     programming. To implement generics, the Java compiler applies type erasure to:

     Replace all type parameters in generic types with their bounds or Object if the type parameters are unbounded.
     The produced bytecode, therefore, contains only ordinary classes, interfaces, and methods.

     Insert type casts if necessary to preserve type safety.

     Generate bridge methods to preserve polymorphism in extended generic types.

     Type erasure ensures that no new classes are created for parameterized types; consequently, generics incur no
     runtime overhead.
     */

    /**
     * The erasure of a type is defined as follows: drop all type parameters from parameterized
     types, and replace any type variable with the erasure of its bound, or with Object if it
     has no bound, or with the erasure of the leftmost bound if it has multiple bounds. Here
     are some examples:
     • The erasure of List<Integer>, List<String>, and List<List<String>> is List.
     • The erasure of List<Integer>[] is List[].
     • The erasure of List is itself, similarly for any raw type (see Section 5.3 for an explanation of raw types).
     • The erasure of int is itself, similarly for any primitive type.
     • The erasure of Integer is itself, similarly for any type without type parameters.
     • The erasure of T in the definition of asList (see Section 1.4) is Object, because T
     has no bound.
     • The erasure of T in the definition of max (see Section 3.2) is Comparable, because T
     has bound Comparable<? super T>.
     • The erasure of T in the final definition of max (see Section 3.6) is Object, because
     T has bound Object & Comparable<T> and we take the erasure of the leftmost bound.

     • The erasures of S and T in the definition of copy (see Section 3.6) are Readable and
     Appendable, because S has bound Readable & Closeable and T has bound Appendable & Closeable.
     • The erasure of LinkedCollection<E>.Node or LinkedCollection.Node<E> (see Section 4.3) is LinkedCollection.Node
     */
}
