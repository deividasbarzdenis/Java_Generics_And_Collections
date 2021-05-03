package org.effectiveGenerics.takeCareWhenCallingLegacyCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WaryClient {
    /**
     * If the legacy library has been generified by applying the minimal changes or stubs techniques
     * (see Sections Section 5.4.1 and Section 5.4.2), then these problems cannot arise
     * as long as generic types have been assigned correctly.
     * A less-naïve client may design code that catches the error earlier and is easier to debug.
     * */
    public static void processItems() {
        List<Integer> list = new ArrayList<Integer>();
        List<Integer> view = Collections.checkedList(list, Integer.class);
        LegacyLibrary.addItems(view); // class cast exception
        List<Integer> list2 = LegacyLibrary.getItems(); // unchecked
        for (int i : list2) {} // class cast exception
// sometime later ...
        int s = 0;
        for (int i : list) s += i;
        for (int i : list2) s += i;
    }
    /**
     * The method checkedList in the convenience class Collections takes a list and a class
     * token and returns a checked view of the list; whenever an attempt is made to add an
     * element to the checked view, reflection is used to check that the element belongs to the
     * specified class before adding it to the underlying list (see Section 17.3.3). Using a
     * checked list view will cause a class cast exception to be raised inside the method addI
     * tems when it attempts to add a string to the list. Since the method getItems creates its
     * own list, the client cannot use a wrapper in the same way. However, adding an empty
     * loop at the point where the list is returned can guarantee that the error is caught close
     * to the offending method call.
     * Checked lists provide useful guarantees only when the list elements are of a reifiable
     * type. If you want to apply these techniques when the list is not of a reifiable type, you
     * might want to consider applying the specialization technique of Section 8.3.*/
}
