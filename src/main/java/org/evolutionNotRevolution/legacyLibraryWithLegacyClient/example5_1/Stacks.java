package org.evolutionNotRevolution.legacyLibraryWithLegacyClient.example5_1;

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
