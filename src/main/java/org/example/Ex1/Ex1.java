package org.example.Ex1;

import java.util.Arrays;
import java.util.Collection;

public class Ex1 {
    public static void main(String[] args) {
        Collection<Integer> cNumbers = Arrays.asList(1, 2, 3, 4);
        int count = Algoritm.countIf(cNumbers, new OddPredicate());
        System.out.println("Number of odd integers: " + count);
    }
}
