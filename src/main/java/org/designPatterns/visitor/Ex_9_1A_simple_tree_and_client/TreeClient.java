package org.designPatterns.visitor.Ex_9_1A_simple_tree_and_client;

public class TreeClient {
    public static void main(String[] args) {
        Tree<Integer> t =
                Tree.branch(Tree.branch(Tree.leaf(1),
                        Tree.leaf(2)),
                        Tree.leaf(3));
        assert t.toString().equals("((1^2)^3)");
        assert t.sum() == 6;
    }
}
