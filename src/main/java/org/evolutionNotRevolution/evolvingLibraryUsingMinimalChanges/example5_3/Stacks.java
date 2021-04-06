package org.evolutionNotRevolution.evolvingLibraryUsingMinimalChanges.example5_3;

@SuppressWarnings("unchecked")
public class Stacks {
    public static <T> Stack<T> reverse(Stack<T> in) {
        Stack out = new ArrayStack();
        while (!in.empty()) {
            Object elt = in.pop();
            out.push(elt); // unchecked call
        }
        return out; // unchecked conversion
    }
}
