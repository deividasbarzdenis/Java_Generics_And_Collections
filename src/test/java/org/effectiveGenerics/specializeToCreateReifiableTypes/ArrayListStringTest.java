package org.effectiveGenerics.specializeToCreateReifiableTypes;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;


public class ArrayListStringTest {

    /**
     * Delegation To specialize by delegation, we define a static method wrap that takes an
     * argument of type List<String> and returns a result of type ListString. The Java library
     * places methods that act on the interface Collection in a class called Collections, so we
     * place the method wrap in a class called ListStrings.
     * Here is an example of its use:
     * */
    @Test
    public void test() {
        List<? extends List<?>> lists =
                Arrays.asList(
                        ListStrings.wrap(Arrays.asList("one", "two")),
                        Arrays.asList(3, 4),
                        Arrays.asList("five", "six"),
                        ListStrings.wrap(Arrays.asList("seven", "eight"))
                );

        ListString[] array = new ListString[2];
        int i = 0;
        for (List<?> list : lists) {
            if (list instanceof ListString) {
                array[i++] = (ListString) list;
            }
        }
        assert Arrays.toString(array).equals("[[one, two], [seven, eight]]");
    }
    /**
     * This creates a list of lists, then scans it for those lists that implement ListString and
     * places those into an array. Array creation, instance tests, and casts nowpose no problems, as they act on
     * the reifiable type ListString rather than the nonreifiable type
     * List<String>. Observe that a List<String> that has not been wrapped will not be recognized as an instance
     * of ListString; this is why the third list in the list of lists is not
     * copied into the array.
     * The ListStrings class is straightforward to implement, although some care is required
     * to preserve good performance. The Java Collections Framework specifies that whenever a list supports fast
     * random access it should implement the marker interface Ran
     * domAccess, to allow generic algorithms to perform well when applied to either random
     * or sequential access lists. It also provides two abstract classes, AbstractList and
     * AbstractSequentialList, suitable for defining random and sequential access lists. For
     * example, ArrayList implements RandomAccess and extends AbstractList, while Linked
     * List extends Abstract-SequentialList. Class AbstractList defines the methods of the
     * List interface in terms of five abstract methods that provide random access and must
     * be defined in a subclass (size, get, set, add, remove). Similarly, class AbstractSequen
     * tialList defines all methods of the List interface in terms of two abstract methods that
     * provide sequential access and must be defined in a subclass (size, listIterator).
     * The wrap method checks whether the given list implements the interface RandomAc
     * cess. If so, it returns an instance of class Random that extends AbstractList and implements
     * RandomAccess, and otherwise it returns an instance of class Sequential that extends AbstractSequentialList.
     * Class Random implements the five methods that must be
     * provided by a subclass of AbstractList. Similarly, class Sequential implements the two
     * methods that must be provided by a subclass of AbstractSequentialList, where the
     * second of these returns a class that implements the nine methods of the ListIterato
     * interface. Implementing the list iterator by delegation instead of simply returning the
     * original list iterator improves the security properties of the wrapper, as discussed below.
     * All of these methods are implemented straightforwardly by delegation.
     * The wrap method returns a view of the underlying list that will raise a class cast exception
     * if any attempt is made to insert an element into the list that is not of type String. These
     * checks are similar to those provided by the checkedList wrapper. However, for wrap
     * the relevant casts are inserted by the compiler (one reason for implementing the nine
     * methods of the listIterator interface by delegation is to ensure that these casts are
     * inserted), while for checked lists the casts are performed by reflection. Generics usually
     * render these checks redundant, but they can be helpful in the presence of legacy code
     * or unchecked warnings, or when dealing with security issues such as those discussed
     * in Section 8.2
     * The code shown here was designed to balance power against brevity (it’s only thirythree lines),
     * but other variations are possible. A less complete version might implement
     * only random access if one could guarantee it was never applied to a sequential access
     * list, or vice versa. A more efficient version might skip the use of AbstractList and
     * Abstract-SequentialList, and instead directly delegate all 25 methods of the List interface
     * together with the toString method (see the source code for Collections.check
     * edList for a model). You also might want to provide additional methods in the List
     * String interface, such as an unwrap method that returns the underlying List<String>,
     * or a version of subList that returns a ListString rather than a List<String> by recursively applying wrap
     * to the delegated call.
     * */
}
