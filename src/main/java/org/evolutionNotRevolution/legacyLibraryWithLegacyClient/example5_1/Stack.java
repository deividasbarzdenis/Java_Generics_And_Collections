package org.evolutionNotRevolution.legacyLibraryWithLegacyClient.example5_1;

public interface Stack {
    /**
     * We begin with a simple library of stacks and an associated client, as presented in
     * Example 5-1. This is legacy code, written for Java 1.4 and its version of the Collections
     * Framework. Like the Collections Framework, we structure the library as an interface
     * Stack (analogous to List), an implementation class ArrayStack (analogous to Array
     * List), and a utility class Stacks (analogous to Collections). The interface Stack provides
     * just three methods: empty, push, and pop. The implementation class ArrayStack provides
     * a single constructor with no arguments, and implements the methods empty, push, and
     * pop using methods size, add, and remove on lists. The body of pop could be shorter—
     * instead of assigning the value to the variable, it could be returned directly—but it will
     * be interesting to see how the type of the variable changes as the code evolves. The utility
     * class provides just one method, reverse, which repeatedly pops from one stack and
     * pushes onto another.
     * The client allocates a stack, pushes a few integers onto it, pops an integer off, and then
     * reverses the remainder into a fresh stack. Since this is Java 1.4, integers must be explicitly
     * boxed when passed to push, and explicitly unboxed when returned by pop.
     * */
    public boolean empty();
    public void push(Object elt);
    public Object pop();
}
