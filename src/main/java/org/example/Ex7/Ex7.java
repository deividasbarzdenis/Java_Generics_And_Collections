package org.example.Ex7;

import java.util.List;

public class Ex7 {
    /*Will the following method compile? If not, why?*/
    public static void print(List<? extends Number> list) {
        for (Number n : list)
            System.out.print(n + " ");
        System.out.println();
    }
    // Answer: Yes.
}
