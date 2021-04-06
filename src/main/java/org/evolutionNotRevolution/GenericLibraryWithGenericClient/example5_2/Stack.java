package org.evolutionNotRevolution.GenericLibraryWithGenericClient.example5_2;

public interface Stack<E> {
    /**
     Next, we update the library and client to use generics, as presented in Example 5-2.
     This is generic code, written for Java 5 and its version of the Collections Framework.
     The interface now takes a type parameter, becoming Stack<E> (analogous to List<E>),
     and so does the implementing class, becoming ArrayStack<E> (analogous to Array
     List<E>), but no type parameter is added to the utility class Stacks (analogous to Collections).
     The type Object in the signatures and bodies of push and pop is replaced by
     the type parameter E. Note that the constructor in ArrayStack does not require a type
     parameter. In the utility class, the reverse method becomes a generic method with
     argument and result of type Stack<T>. Appropriate type parameters are added to the
     client, and boxing and unboxing are now implicit.
     In short, the conversion process is straightforward: just add a few type parameters and
     replace occurrences of Object by the appropriate type variable. All differences between
     the legacy and generic versions can be spotted by comparing the highlighted portions
     of the two examples. The implementation of generics is designed so that the two versions
     generate essentially equivalent class files. Some auxiliary information about the
     types may differ, but the actual bytecodes to be executed will be identical. Hence,
     executing the legacy and generic versions yields the same results. The fact that legacy
     and generic sources yield identical class files eases the process of evolution, as we discuss next.
     * */

    public boolean empty();
    public void push(E elt);
    public E pop();
}
