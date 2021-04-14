package org.reification.thePrincipleOfTruthInAdvertising;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class RightTest {

    @Test
    public void testPrincipleOfTruthInAdvertising(){
        List<String> strings = Arrays.asList("one", "two");
        String[] a = Right.Array(strings, new String[0]);
        assert Arrays.toString(a).equals("[one, two]");
        String[] b = new String[] { "x","x","x","x" };
        Right.Array(strings, b);
        assert Arrays.toString(b).equals("[one, two, null, x]");
    }

}