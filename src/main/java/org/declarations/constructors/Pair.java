package org.declarations.constructors;
/*In a generic class, type parameters appear in the header that declares the class, but not
in the constructor:*/
/*In a generic class, type parameters appear in the header that declares the class, but not
in the constructor:*/
public class Pair<T, U> {
    private final T first;
    private final U second;

    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public U getSecond() {
        return second;
    }
}
