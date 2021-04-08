package org.reification.instanceTestsAndCasts;

import java.util.Arrays;
import java.util.List;

public class Promote {
    /**
     * Unchecked casts Only rarely will the compiler be able to determine that if a cast to a
     * non reifiable type succeeds then it must yield a value of that type. In the remaining cases,
     * a cast to a type that is not reifiable is flagged with an unchecked warning, whereas an
     * instance test against a type that is not reifiable is always caught as an error. This is
     * because there is never any point to an instance test that cannot be performed, but there
     * may be a point to a cast that cannot be checked.
     * Type systems deduce facts about programs—for instance, that a certain variable always
     * contains a list of strings. But no type system is perfect; there will always be some facts
     * that a programmer can deduce but that the type system does not. To permit the programmer
     * a workaround in such circumstances, the compiler issues warnings rather
     * than errors when performing some casts.
     * For example, here is code that promotes a list of objects into a list of strings, if the list
     * of objects contains only strings, and throws a class cast exception otherwise:
     * */
    public static List<String> promote(List<Object> objs) {
        for (Object o : objs)
            if (!(o instanceof String))
                throw new ClassCastException();
        return (List<String>)(List<?>)objs; // unchecked cast
    }
    public static void main(String[] args) {
        List<Object> objs1 = Arrays.<Object>asList("one","two");
        List<Object> objs2 = Arrays.<Object>asList(1,"two");
        List<String> strs1 = promote(objs1);
        assert (List<?>)strs1 == (List<?>)objs1;
        boolean caught = false;
        try {
            List<String> strs2 = promote(objs2);
        } catch (ClassCastException e) { caught = true; }
        assert caught;
    }
}
