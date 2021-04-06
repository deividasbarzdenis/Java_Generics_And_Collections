package org.evolutionNotRevolution.evolvingLibraryUsingMinimalChanges.example5_3;

public interface Stack<E> {
    /**
     The minimal changes technique is shown in Example 5-3. Here the source of the library
     has been edited, but only to change method signatures, not method bodies. The exact
     changes required are highlighed in boldface. This is the recommended technique for
     evolving a library to be generic when you have access to the source.
     To be precise, the changes required are:
     • Adding type parameters to interface or class declarations as appropriate (for interface Stack<E> and class ArrayStack<E>)
     • Adding type parameters to any newly parameterized interface or class in an extends
     or implements clause (for Stack<E> in the implements clause of ArrayStack<E>),
     • Adding type parameters to each method signature as appropriate (for push and
     pop in Stack<E> and ArrayStack<E>, and for reverse in Stacks)
     Adding an unchecked cast to each return where the return type contains a type
     parameter (for pop in ArrayStack<E>, where the return type is E)—without this cast,
     you will get an error rather than an unchecked warning
     • Optionally adding annotations to suppress unchecked warnings (for Array
     Stack<E> and Stacks)
     It is worth noting a few changes that we do not need to make. In method bodies, we
     can leave occurrences of Object as they stand (see the first line of pop in ArrayStack),
     and we do not need to add type parameters to any occurrences of raw types (see the
     first line of reverse in Stacks). Also, we need to add a cast to a return clause only when
     the return type is a type parameter (as in pop) but not when the return type is a parameterized type (as in reverse).

     Example 5-3. Evolving a library using minimal changes:
     * */
    public boolean empty();
    public void push(E elt);
    public E pop();
}
