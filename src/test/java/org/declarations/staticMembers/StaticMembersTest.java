package org.declarations.staticMembers;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class StaticMembersTest {

    /*Because generics are compiled by erasure, at run time the classes List<Integer>,
List<String>, and List<List<String>> are all implemented by a single class, namely
List. You can see this using reflection:*/
// Here the class associated with a list of integers at run time is the same as the class
// associated with a list of strings.
    @Test
    public void testStaticMembers(){
        List<Integer> ints = Arrays.asList(1, 2, 3);
        List<String> strings = Arrays.asList("one", "two");
        assert ints.getClass() == strings.getClass();
    }
    @Test
    public void testCellClass(){
        Cell<String> a = new Cell<String>("one");
        Cell<Integer> b = new Cell<Integer>(2);
        assert a.getId() == 0 && b.getId() == 1 && Cell.getCount() == 2;
    }
    @Test
    public void testCell2Class(){
        Cell2<String> a = new Cell2<>("one");
        Cell2<Integer> b = new Cell2<>(2);
        assert Cell2.getValues().toString().equals("[one, 2]");
    }

}