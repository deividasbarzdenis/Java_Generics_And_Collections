package org.evolutionNotRevolution.evolvingLibraryUsingStubs.example5_4;

public class ArrayStack<E> implements Stack<E> {
    public boolean empty() { throw new StubException(); }
    public void push(E elt) { throw new StubException(); }
    public E pop() { throw new StubException(); }
    public String toString() { throw new StubException(); }
}
