package org.evolutionNotRevolution.evolvingLibraryUsingWrappers.example5_5;

@SuppressWarnings("unchecked")
public class GenericStackWrapper<E> implements GenericStack<E> {
    private Stack stack;
    public GenericStackWrapper(Stack stack) { this.stack = stack; }
    public Stack unwrap() { return stack; }
    public boolean empty() { return stack.empty(); }
    public void push(E elt) { stack.push(elt); }
    public E pop() { return (E)stack.pop(); } // unchecked cast
    public String toString() { return stack.toString(); }
}
