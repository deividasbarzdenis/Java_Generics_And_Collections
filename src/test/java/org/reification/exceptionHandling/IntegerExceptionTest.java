package org.reification.exceptionHandling;

import org.junit.Test;

public class IntegerExceptionTest {

    @Test
    public void testExceptionHandling(){
            try {
                throw new IntegerException(42);
            } catch (IntegerException e) {
                assert e.getValue() == 42;
            }
    }

}