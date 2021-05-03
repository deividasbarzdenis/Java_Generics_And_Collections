package org.effectiveGenerics.specializeToCreateReifiableTypes;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ArrayListStringTest1 {
/**
 * To specialize by inheritance, we declare a specialized class that implements the specialized
 * interface and inherits from a suitable implementation of lists.
 * Example 8-1 shows an implementation that specializes ArrayList, which we repeat
 * here:
 * class ArrayListString extends ArrayList<String> implements ListString {
 * public ArrayListString() { super(); }
 * public ArrayListString(Collection<? extends String> c) { super(c); }
 * public ArrayListString(int capacity) { super(capacity); }
 * }
 * The code is quite compact. All methods are inherited from the superclass, so we only
 * need to define specialized constructors. If the only constructor required was the default
 * constructor, then the class body could be completely empty!
 * The previous example still works if we create the initial list using inheritance rather
 * than delegation:
 * */
    @Test
    public void test(){
        List<? extends List<?>> lists =
                Arrays.asList(
                        new ArrayListString(Arrays.asList("one","two")),
                        Arrays.asList(3,4),
                        Arrays.asList("five","six"),
                        new ArrayListString(Arrays.asList("seven","eight"))
                );
        ListString[] array = new ListString[2];
        int i = 0;
        for (List<?> list : lists)
            if (list instanceof ListString)
                array[i++] = (ListString) list;
        assert Arrays.toString(array).equals("[[one, two], [seven, eight]]");
    }

    /**
     * However, delegation and inheritance are not interchangeable. Specialization by delegation creates a
     * view of an underlying list, while specialization by inheritance constructs
     * a new list. Further, specialization by delegation has better security properties than specialization
     * by inheritance. Here is an example:
     * */
    @Test
    public void test1(){
        List<String> original = new ArrayList<String>();
        ListString delegated = ListStrings.wrap(original);
        ListString inherited = new ArrayListString(original);
        delegated.add("one");
        inherited.add("two");
        try {
            ((List)delegated).add(3); // unchecked, class cast error
        } catch (ClassCastException e) {}
        ((List)inherited).add(4); // unchecked, no class cast error!
        assert original.toString().equals("[one]");
        assert delegated.toString().equals("[one]");
        assert inherited.toString().equals("[two, 4]");
    }
    /**
     * Here an original list serves as the basis for two specialized lists, one created by delegation
     * and one by inheritance. Elements added to the delegated list appear in the original, but
     * elements added to the inherited list do not. Type checking normally would prevent any
     * attempt to add an element that is not a string to any object of type List<String>, specialized or not,
     * but such attempts may occur in the presence of legacy code or unchecked warnings. Here we cast to a raw
     * type and use an unchecked call to attempt to
     * add an integer to the delegated and inherited lists. The attempt on the delegated list
     * raises a class cast exception, while the attempt on the inherited list succeeds. To force
     * the second attempt to fail, we should wrap the inherited list using checkedList, as
     * described in Section 8.1.
     * Another difference is that inheritance can only be applied to a public implementation
     * that can be subclassed (such as ArrayList or LinkedList), whereas delegation can create
     * a view of any list (including lists returned by methods such as Arrays.asList or Collec
     * tions.immutableList, or by the subList method on lists)
     * */

    @Test
    public void test2(){

    }

}
