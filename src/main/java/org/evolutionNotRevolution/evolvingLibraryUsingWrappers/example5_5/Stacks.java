package org.evolutionNotRevolution.evolvingLibraryUsingWrappers.example5_5;



public class Stacks {
    public static Stack reverse(Stack in) {
        Stack out = new ArrayStack();
        while (!in.empty()) {
            Object elt = in.pop();
            out.push(elt);
        }
        return out;
    }
}
