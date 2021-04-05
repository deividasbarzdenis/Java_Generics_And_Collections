package org.declarations.nestedClasses.example4_1;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedCollection<E> extends AbstractCollection<E> {
    /**
     * Example 4-1 shows a class implementing collections as a singly-linked list. The class
extends java.util.AbstractCollection, so it only needs to define the methods size,
add, and iterator. The class contains an inner class, Node, for the list nodes, and an
anonymous inner class implementing Iterator<E>. The type parameter E is in scope
within both of these classes.*/

    //Inner class Node
    private class Node {
        private E element;
        private Node next = null;
        private Node(E elt) { element = elt; }
    }
    // LinkedCollection class fields
    private Node first = new Node(null);
    private Node last = first;
    private int size = 0;
    // empty LinkedCollection class constructor
    public LinkedCollection() {

    }
    // LinkedCollection class constructor with value c
    public LinkedCollection(Collection<? extends E> c) {
        addAll(c);
    }

    public int size() {
        return size;
    }

    public boolean add(E elt) {
        last.next = new Node(elt);
        last = last.next;
        size++;
        return true;
    }

    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node current = first;
            public boolean hasNext() {
                return current.next != null;
            }
            public E next() {
                if (current.next != null) {
                    current = current.next;
                    return current.element;
                } else throw new NoSuchElementException();
            }
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}
