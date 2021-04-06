package org.evolutionNotRevolution.evolvingLibraryUsingWrappers.example5_5;

import org.junit.Test;

public class ClientTest {

    @Test
    public void testClient5(){
        GenericStack<Integer> stack
                = new GenericStackWrapper<>(new ArrayStack());
        for (int i = 0; i<4; i++) stack.push(i);
        assert stack.toString().equals("stack[0, 1, 2, 3]");
        int top = stack.pop();
        assert top == 3 && stack.toString().equals("stack[0, 1, 2]");
        GenericStack<Integer> reverse = GenericStacks.reverse(stack);
        assert stack.empty();
        assert reverse.toString().equals("stack[2, 1, 0]");
    }

}