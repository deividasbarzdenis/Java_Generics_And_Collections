package org.evolutionNotRevolution.legacyLibraryWithLegacyClient.example5_1;

import org.junit.Test;

public class ClientTest {

    @Test
    public void testClient(){
        Stack stack = new ArrayStack();
        for (int i = 0; i<4; i++) stack.push(new Integer(i));
        assert stack.toString().equals("stack[0, 1, 2, 3]");
        int top = ((Integer)stack.pop()).intValue();
        assert top == 3 && stack.toString().equals("stack[0, 1, 2]");
        Stack reverse = Stacks.reverse(stack);
        assert stack.empty();
        assert reverse.toString().equals("stack[2, 1, 0]");
    }

}