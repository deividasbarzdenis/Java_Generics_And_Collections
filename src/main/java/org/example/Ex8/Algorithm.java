package org.example.Ex8;

import java.util.List;

public class Algorithm {
    /*Write a generic method to find the maximal element in the range [begin, end) of a list.*/
    public static <T extends Object & Comparable<? super T>>
    T max(List<? extends T> list, int begin, int end) {

        T maxElem = list.get(begin);

        for (++begin; begin < end; ++begin)
            if (maxElem.compareTo(list.get(begin)) < 0)
                maxElem = list.get(begin);
        return maxElem;
    }
}
