package org.designPatterns.visitor.Ex_9_1A_simple_tree_and_client;

public abstract class Tree<E>{
    /**
     * Often, a data structure is defined by case analysis and recursion. For example, a binary
     * tree of type Tree<E> is one of the following:
     * • A leaf, containing a single value of type E
     * • A branch, containing a left subtree and a right subtree, both of type Tree<E>
     * It is easy to think of many other examples: a shape may be either a triangle, a rectangle,
     * a combination of two shapes, or the transposition of a shape; an XML node is either a
     * text node, an attribute node, or an element node (which may contain other nodes); and
     * so on.
     * To represent such a structure in an object-oriented language, the data structure is represented by
     * an abstract class, and each case is represented by a subclass. The abstract
     * class declares an abstract method for each possible operation on the data structure, and
     * each subclass implements the method as appropriate for the corresponding case.
     * Example 9-1 illustrates this technique applied to trees. There is an abstract class,
     * Tree<E>, with two abstract methods, toString and sum. (The former applies to any tree,
     * while the latter applies only to a tree of numbers—for simplicity, this restriction is
     * enforced by a cast at run time rather than a type at compile time, as discussed later.)
     * There are two static factory methods, one to construct a leaf and one to construct a
     * branch. Each of these contains a nested class that extends Tree<E> and implements each
     * of the methods toString and sum.
     * This approach is adequate if you know in advance all of the operations required on the
     * data structure, or can modify the classes that define the structure when the requirements
     * change. However, sometimes this is not the case, particularly when different
     * developers are
     * */
    abstract public String toString();
    abstract public Double sum();
    public static <E> Tree<E> leaf(final E e) {
        return new Tree<E>() {
            public String toString() {
                return e.toString();
            }
            public Double sum() {
                return ((Number)e).doubleValue();
            }
        };
    }
    public static <E> Tree<E> branch(final Tree<E> l, final Tree<E> r) {
        return new Tree<E>() {
            public String toString() {
                return "("+l.toString()+"^"+r.toString()+")";
            }
            public Double sum() {
                return l.sum() + r.sum();
            }
        };
    }
}
