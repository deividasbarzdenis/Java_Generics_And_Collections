package org.evolutionNotRevolution.evolvingLibraryUsingWrappers.example5_5;

public class GenericStacks {

        public static <T> GenericStack<T> reverse(GenericStack<T> in) {
        Stack rawIn = in.unwrap();
        Stack rawOut = Stacks.reverse(rawIn);
        return new GenericStackWrapper<T>(rawOut);
    }
}
