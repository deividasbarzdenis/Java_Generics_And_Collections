package org.example.Ex12;

import java.util.List;

public class Algorithm {
    /**
     * How do you invoke the following method to find the first integer in a list that is relatively prime to a
     * list of specified integers?
     * public static <T> int findFirst(List<T> list, int begin, int end, UnaryPredicate<T> p)
     * Note that two integers a and b are relatively prime if gcd(a, b) = 1, where gcd is short for greatest common divisor.
     * */

    public static <T>
    int findFirst(List<T> list, int begin, int end, UnaryPredicate<T> p) {

        for (; begin < end; ++begin)
            if (p.test(list.get(begin)))
                return begin;
        return -1;
    }

    // x > 0 and y > 0
    public static int gcd(int x, int y) {
        for (int r; (r = x % y) != 0; x = y, y = r) { }
        return y;
    }
}
