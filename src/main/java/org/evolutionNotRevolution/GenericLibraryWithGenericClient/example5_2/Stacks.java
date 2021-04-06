package org.evolutionNotRevolution.GenericLibraryWithGenericClient.example5_2;

public class Stacks {
    public static <T> Stack<T> reverse(Stack<T> in) {
        Stack<T> out = new ArrayStack();
        while (!in.empty()) {
            T elt = in.pop();
            out.push(elt);
        }
        return out;
    }
}
