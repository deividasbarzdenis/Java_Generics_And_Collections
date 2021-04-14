package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayExampleGenerics {

    public static <T> List<T> remove(List<T> list, T t1) {
        List<T> removeList = list.
                stream()
                .filter(x -> !x.equals(t1))
                .collect(Collectors.toList());

        return removeList;
    }
    public static void main(String[] args) {
        String[] cities = {"Vilnius", "Riga", "Tallinn", "Helsinki", "Oslo", "Vilnius"};
        List<String> citiesList = new ArrayList<>(Arrays.asList(cities));
        List<String> newList = remove(citiesList, "Vilnius");
        System.out.println(newList);

        Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8 ,9};
        List<Integer> numbersList = new ArrayList<>(Arrays.asList(numbers));
        List<Integer> newList1 = remove(numbersList, 1);
        System.out.println(newList1);
    }
}

