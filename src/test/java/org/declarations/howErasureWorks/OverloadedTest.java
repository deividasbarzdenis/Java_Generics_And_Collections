package org.declarations.howErasureWorks;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class OverloadedTest {

    @Test
    public void testSum(){
        assert Overloaded.sumNumbers(Arrays.asList(1,2,3)) == 6;
        assert Overloaded.sumStrings(Arrays.asList("a","b")).equals("ab");
    }

}