package org.reification.thePrincipleOfTruthInAdvertising;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;

public class RightWithClassTest {

    @Test
    public void testRightWithClass(){
        List<String> strings = Arrays.asList("one", "two");
        String[] a = RightWithClass.toArray(strings, String.class);
        assert Arrays.toString(a).equals("[one, two]");
    }

}