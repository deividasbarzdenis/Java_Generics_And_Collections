package org.designPatterns.visitor.Ex9_3A_client_with_visitors;

import org.designPatterns.visitor.Ex_9_2A_tree_with_visitors.Tree;

public class TreeClient {
    /**
     * Example 9-3 illustrates how to implement the toString and sum methods on trees within
     * the client, rather than within the class that defines the data structure. Whereas before
     * these were methods with the tree as the receiver, now they are static methods that take
     * the tree as an argument.
     * There is a pleasing duality between the two approaches. For simple trees, each factory
     * method (leaf and branch) groups together definitions for each operator method
     * (toString and sum). For trees with visitors, each operator method (toString and sum)
     * groups together definitions for each visitor method (leaf and branch).
     * With generics, each visitor has two type parameters, one for the element type of the
     * tree and one for the return type of the visitor. Without generics, each visitor would
     * have to return a result of type Object, and many additional casts would be required.
     * Because of this, when generics are not present, often visitors are designed not to return
     * a value; instead, the result is accumulated in a variable local to the visitor, complicating
     * the flow of data through the program
     * */
    public static <T> String toString(Tree<T> t) {
        return t.visit(new Tree.Visitor<T, String>() {
            public String leaf(T e) {
                return e.toString();
            }
            public String branch(String l, String r) {
                return "("+l+"^"+r+")";
            }
        });
    }
    public static <N extends Number> double sum(Tree<N> t) {
        return t.visit(new Tree.Visitor<N, Double>() {
            public Double leaf(N e) {
                return e.doubleValue();
            }
            public Double branch(Double l, Double r) {
                return l+r;
            }
        });
    }
    public static void main(String[] args) {
        Tree<Integer> t =
                Tree.branch(Tree.branch(Tree.leaf(1),
                        Tree.leaf(2)),
                        Tree.leaf(3));
        assert toString(t).equals("((1^2)^3)");
        assert sum(t) == 6;
    }
    /**
     * It is interesting to note that the generic type of the sum method can be more precise with
     * visitors. With simple trees, the sum method must have a type signature that indicates
     * that it works on any element type; a cast is required to convert each leaf to type Num
     * ber; and a class cast error is raised at run time if sum is invoked on a tree not containing
     * numbers. With visitors, the sum method may have a type signature that indicates that
     * it works only on elements that are numbers; no cast is required; and a type error is
     * reported at compile time if sum is invoked on a tree not containing numbers
     * */
}
