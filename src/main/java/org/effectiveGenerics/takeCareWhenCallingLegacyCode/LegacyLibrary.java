package org.effectiveGenerics.takeCareWhenCallingLegacyCode;

import java.util.ArrayList;
import java.util.List;

public class LegacyLibrary {

    /**
     * As we have seen, generic types are checked at compile time, not run time. Usually, this
     * is just what we want, since checking at compile time reports errors earlier and incurs
     * no runtime overhead. However, sometimes this may not be appropriate, either because
     * we can’t be sure that compile-time checks are adequate (say, because we are passing
     * an instance of a parameterized type to a legacy client or to a client we don’t trust), or
     * because we need information about types at run time (say, because we want a reifiable
     * type for use as an array component). A checked collection will often do the trick, and
     * when that will not do, we can create a specialized class. We consider checked collections
     * in this section, security issues in the next section, and specialized classes in the section
     * after that.
     * Consider a legacy library that contains methods to add items to a given list and to return
     * a new list containing given items:*/
    public static void addItems(List list) {
        list.add(new Integer(1));
        list.add("two");
    }
    public static List getItems() {
        List list = new ArrayList();
        list.add(new Integer(3));
        list.add("four");
        return list;
    }
}
