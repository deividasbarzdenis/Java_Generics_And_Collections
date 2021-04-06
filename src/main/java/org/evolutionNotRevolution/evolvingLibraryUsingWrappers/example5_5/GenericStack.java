package org.evolutionNotRevolution.evolvingLibraryUsingWrappers.example5_5;

public interface GenericStack<E> {
    /**
     The wrappers technique is shown in Example 5-5. Here we leave the legacy source and
     class files unchanged, and provide a generic wrapper class that accesses the legacy class
     via delegation.We present this technique mainly in order to warn you against its use—
     it is usually better to use minimal changes or stubs.
     This techique creates a parallel hierarchy of generic interfaces and wrapper classes. To
     be precise, we create a new interface GenericStack corresponding to the legacy interface
     Stack, we create a new class GenericWrapperClass to access the legacy implementation
     ArrayStack, and we create a new class GenericStacks corresponding to the legacy convenience class Stacks.
     The generic interface GenericStack is derived from the legacy interface Stack by the
     same method used in the previous sections to update the signatures to use generics. In
     addition, a new method unwrap is added, that extracts the legacy implementation from
     a wrapper.
     The wrapper class GenericStackWrapper<E> implements GenericStack<E> by delegation
     to a Stack. The constructor takes an instance that implements the legacy interface
     Stack, which is stored in a private field, and the unwrap method returns this instance.
     Because delegation is used, any updates made to the underlying legacy stack will be
     seen through the generic stack view offered by the wrapper.
     The wrapper implements each method in the interface (empty, push, pop) by a call to
     the corresponding legacy method; and it implements each method in Object that is
     overridden in the legacy class (toString) similarly. As with minimal changes, we add
     an unchecked cast to the return statement when the return type contains a type parameter
     (as in pop); without this cast you will get an error rather than an unchecked
     warning.
     A single wrapper will suffice for multiple implementations of the same interface. For
     instance, if we had both ArrayStack and LinkedStack implementations of Stack, we
     could use GenericStackWrapper<E> for both.
     The new convenience class GenericStacks is implemented by delegation to the legacy
     class Stacks. The generic reverse method unwraps its argument, calls the legacy
     reverse method, and wraps its result.
     Required changes to the client in Example 5-5 are shown in boldface.
     Wrappers have a number of disadvantages compared to minimal changes or stubs.
     Wrappers require maintaining two parallel hierarchies, one of legacy interfaces and
     classes and one of generic interfaces and classes. Conversion by wrapping and unwrapping
     between these can become tedious. If and when the legacy classes are gen
     *
     * Example 5-5. Evolving a library using wrappers:
     * */

    public Stack unwrap();
    public boolean empty();
    public void push(E elt);
    public E pop();

}
