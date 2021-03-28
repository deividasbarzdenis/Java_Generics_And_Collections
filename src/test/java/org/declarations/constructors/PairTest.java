package org.declarations.constructors;

import org.declarations.constructors.Pair;
import junit.framework.TestCase;
import org.junit.Test;

public class PairTest {

    @Test
    public void testPair(){
        Pair<String, Integer> pair = new Pair<String, Integer>("one", 2);
        assert pair.getFirst().equals("one") && pair.getSecond() == 2;
    }

}