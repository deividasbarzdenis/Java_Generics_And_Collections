package org.designPatterns.visitor.Ex_9_4An_interpreter_with_generics;

public class Pair<A, B> {
    /**
     * In practice, you will often use a combination of the simple approach and the Visitor
     * pattern. For instance, you might choose to define standard methods, such as
     * toString, using the simple approach, while using Visitor for other methods, such as sum
     * */
    private final A left;
    private final B right;
    public Pair(A l, B r) { left=l; right=r; }
    public A left() { return left; }
    public B right() { return right; }
}
