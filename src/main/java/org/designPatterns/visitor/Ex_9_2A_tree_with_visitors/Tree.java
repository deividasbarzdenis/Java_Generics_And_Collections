package org.designPatterns.visitor.Ex_9_2A_tree_with_visitors;

public abstract class Tree<E> {
    /**
     * The Visitor pattern makes it possible to provide new operations without modifying the
     * classes that define the data structure. In this pattern, the abstract class that represents
     * the structure declares an abstract visit method, which takes a visitor as an argument.
     * The visitor implements an interface that specifies one method for each case in the
     * specification of the structure. Each subclass implements the visit method by calling
     * the method of the visitor for the corresponding case
     *
     * */
    public interface Visitor<E, R> {
        public R leaf(E elt);
        public R branch(R left, R right);
    }
    public abstract <R> R visit(Visitor<E, R> v);
    public static <T> Tree<T> leaf(final T e) {
        return new Tree<T>() {
            public <R> R visit(Visitor<T, R> v) {
                return v.leaf(e);
            }
        };
    }
    public static <T> Tree<T> branch(final Tree<T> l, final Tree<T> r) {
        return new Tree<T>() {
            public <R> R visit(Visitor<T, R> v) {
                return v.branch(l.visit(v), r.visit(v));
            }
        };
    }

    /**
     * Example 9-2 illustrates this pattern applied to trees. Now the abstract class Tree<E> has
     * only one abstract method, visit, which accepts an argument of type Visitor<E, R>.
     * The interface Visitor<E, R> specifies two methods, a leaf method that accepts a value
     * of type E and returns a value of type R, and a branch method that accepts two values of
     * type R and returns a value of type R. The subclass corresponding to a leaf implements
     * visit by invoking the leaf method of the visitor on the element in the leaf, and the
     * subclass corresponding to a branch implements visit by invoking the branch method
     * of the visitor on the result of recursive calls of the visitor on the left and right subtrees
     * */
}
