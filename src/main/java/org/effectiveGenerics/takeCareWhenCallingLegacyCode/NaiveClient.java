package org.effectiveGenerics.takeCareWhenCallingLegacyCode;

import java.util.ArrayList;
import java.util.List;

public class NaiveClient {
    /**
     * Now consider a client that uses this legacy library, having been told (incorrectly) that
     * the items are always integers:*/

    public static void processItems() {
        List<Integer> list = new ArrayList<Integer>();
        LegacyLibrary.addItems(list);
        List<Integer> list2 = LegacyLibrary.getItems(); // unchecked
// sometime later ...
        int s = 0;
        for (int i : list) s += i; // class cast exception
        for (int i : list2) s += i; // class cast exception
    }
    /**
     * There is no warning when passing the integer list to the method addItems, because the
     * parameterized type List<Integer> is considered a subtype of List. The conversion from
     * List to List<Integer> of the list returned by getItems does issue an unchecked warning.
     * At run-time, a class cast exception will be raised when attempting to extract data from
     * these lists, since the cast to type Integer implicitly inserted by erasure will fail. (The
     * failure of these casts does not constitute a violation of the cast-iron guarantee, because
     * this guarantee doesn’t hold in the presence of legacy code or unchecked warnings.)
     * Because the exception is raised far from the place where the strings are added to the
     * lists, the bug may be hard to pinpoint
     * */
}
