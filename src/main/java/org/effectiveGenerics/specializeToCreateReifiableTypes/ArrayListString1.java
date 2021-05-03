package org.effectiveGenerics.specializeToCreateReifiableTypes;

import java.util.ArrayList;
import java.util.Collection;

public class ArrayListString1 extends ArrayList<String> implements ListString {
    /**
     * The security properties of specialization by inheritance can be improved by declaring
     * a specialized signature for any method that adds an element to the list or sets an element:
     */
    public ArrayListString1() {
        super();
    }

    public ArrayListString1(Collection<? extends String> c) {
        this.addAll(c);
    }

    public ArrayListString1(int capacity) {
        super(capacity);
    }

    public boolean addAll(Collection<? extends String> c) {
        for (String s : c) {
        } // check that c contains only strings
        return super.addAll(c);
    }

    public boolean add(String element) {
        return super.add(element);
    }

    public void add(int index, String element) {
        super.add(index, element);
    }

    public String set(int index, String element) {
        return super.set(index, element);
    }
    /**
     * Now, any attempt to add or set an element that is not a string will raise a class cast
     * exception. However, this property depends on a subtle implementation detail, namely
     * that any other methods that add or set an element (for instance, the add method in
     * listIterator) are implemented in terms of the methods specialized above. In general,
     * if security is desired, delegation is more robust.
     * Other Types Specialization at other types works similarly. For example, replacing
     * String by Integer in Example 8-1 gives an interface ListInteger and classes ListInteg
     * ers and ArrayListInteger. This even works for lists of lists. For example, replacing
     * String by ListString in Example 8-1 gives an interface ListListString and classes
     * ListListStrings and ArrayListListString.
     * However, specialization at wildcard types can be problematic. Say we wanted to specialize
     * both of the types List<Number> and List<? extends Number>. We might expect
     * to use the following declarations:
     * // illegal
     * interface ListNumber extends List<Number>, ListExtendsNumber {}
     * interface ListExtendsNumber extends List<? extends Number> {}
     * This falls foul of two problems: the first interface extends two different interfaces with
     * the same erasure, which is not allowed (see Section 4.4), and the second interface has
     * a supertype with a wildcard at the top level, which is also not allowed (see Section 2.8).
     * The only workaround is to avoid specialization of types containing wildcards;
     * fortunately, this should rarely be a problem.
     * */
}
