package org.effectiveGenerics.maintainBinaryCompatibility.Ex8_3;

import org.junit.Test;

import static org.junit.Assert.*;

public class SimpleNameTest {

    @Test
    public void test(){
        Name m = new ExtendedName("a","b");
        Name n = new ExtendedName("a","c");
        assert m.compareTo(n) == 0;
    }

}
