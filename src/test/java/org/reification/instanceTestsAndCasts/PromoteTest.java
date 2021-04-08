package org.reification.instanceTestsAndCasts;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class PromoteTest {

    @Test
    public void testUncheckedCats(){
        List<Object> objs1 = Arrays.<Object>asList("one","two");
        List<Object> objs2 = Arrays.<Object>asList(1,"two");
        List<String> strs1 = Promote.promote(objs1);
        assert (List<?>)strs1 == (List<?>)objs1;
        boolean caught = false;
        try {
            List<String> strs2 = Promote.promote(objs2);
        } catch (ClassCastException e) { caught = true; }
        assert caught;
    }

}