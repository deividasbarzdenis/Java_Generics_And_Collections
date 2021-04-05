package org.declarations.howErasureWorks;

import java.util.List;

public class Overloaded {
    public static int sumNumbers(List<Integer> ints) {
        int sum = 0;
        for (int i : ints) sum += i;
        return sum;
    }

    public static String sumStrings(List<String> strings) {
        StringBuffer sum = new StringBuffer();
        for (String s : strings) sum.append(s);
        return sum.toString();
    }

    /*
Here are the erasures of the signatures of the two methods:
int sum(List)
String sum(List)

The two methods have different return types, which is sufficient for Java to distinguish them. However, say we change
the methods so that each appends its result to the end of the argument list rather than returning a value:

class Overloaded2 {
// compile-time error, cannot overload two methods with same erasure
public static boolean allZero(List<Integer> ints) {
for (int i : ints) if (i != 0) return false;
return true;
}
public static boolean allZero(List<String> strings) {
for (String s : strings) if (s.length() != 0) return false;
return true;
}
}
We intend this code to work as follows:
assert allZero(Arrays.asList(0,0,0));
assert allZero(Arrays.asList("","",""));

However, in this case the erasures of the signatures of both methods are identical:
boolean allZero(List)

Therefore, a name clash is reported at compile time. It is not possible to give both
methods the same name and try to distinguish between them by overloading, because
after erasure it is impossible to distinguish one method call from the other.
*/

    /*
For another example, here is a bad version of the integer class, that tries to make it
possible to compare an integer with either an integer or a long:

class Integer implements Comparable<Integer>, Comparable<Long> {
// compile-time error, cannot implement two interfaces with same erasure
private final int value;
public Integer(int value) { this.value = value; }
public int compareTo(Integer i) {
return (value < i.value) ? -1 : (value == i.value) ? 0 : 1;
}
public int compareTo(Long l) {
return (value < l.value) ? -1 : (value == l.value) ? 0 : 1;
}
}
*/

}
