package org.declarations.nestedClasses.example4_2;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedCollection<E> extends AbstractCollection<E> {
    /**
     * For contrast, Example 4-2 shows a similar implementation, but this time the nested
Node class is static, and so the type parameter E is not in scope for this class. Instead,
the nested class is declared with its own type parameter, T. Where the previous version
referred to Node, the new version refers to Node<E>. The anonymous iterator class in the
preceding example has also been replaced by a nested static class, again with its own
type parameter.
If the node classes had been made public rather than private, you would refer to the
node class in the first example as LinkedCollection<E>.Node, whereas you would refer
to the node class in the second example as LinkedCollection.Node<E>.*/

    private static class Node<T> {
        private T element;
        private Node<T> next = null;
        private Node(T elt) { element = elt; }
    }
    private Node<E> first = new Node<E>(null);
    private Node<E> last = first;
    private int size = 0;
    public LinkedCollection() {}
    public LinkedCollection(Collection<? extends E> c) { addAll(c); }
    public int size() { return size; }
    public boolean add(E elt) {
        last.next = new Node<E>(elt); last = last.next; size++;
        return true;
    }
    private static class LinkedIterator<T> implements Iterator<T> {
        private Node<T> current;
        public LinkedIterator(Node<T> first) { current = first; }
        public boolean hasNext() {
            return current.next != null;
        }
        public T next() {
            if (current.next != null) {
                current = current.next;
                return current.element;
            } else throw new NoSuchElementException();
        }
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
    public Iterator<E> iterator() {
        return new LinkedIterator<E>(first);
    }
}
