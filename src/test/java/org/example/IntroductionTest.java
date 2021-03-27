package org.example;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class IntroductionTest {

    @Test
    public void testSumOfNumbers(){
        List<Integer> ints = Arrays.asList(1,2,3);
        int s = 0;
        for (int n : ints){
            s += n;
        }
        assert s == 6;
    }

    @Test
    public void testOrStringsEquals(){
        List<String> words = new ArrayList<>();
        words.add("Hello ");
        words.add("world!");
        String s = words.get(0) + words.get(1);
        assert s.equals("Hello world!");
    }
    @Test
    public void testArrayIsEquals(){
        List<Integer> ints = new ArrayList<>();
        addAll(ints, 1,2);
        addAll(ints, new Integer[] {3, 4});
        assert ints.toString().equals("[1, 2, 3, 4]");
    }
    @Test
    public void testEqualSubtypes(){
        List<Number> nums = new ArrayList<>();
        nums.add(2);
        nums.add(3.14);
        assert  nums.toString().equals("[2, 3.14]");
    }

    @Test
    public void testWildCardsExample(){
        List<Number> nums = new ArrayList<>();
        List<Integer> ints = Arrays.asList(1, 2);
        List<Double> dbls = Arrays.asList(2.78, 3.14);
        nums.addAll(ints);
        nums.addAll(dbls);
        assert nums.toString().equals("[1, 2, 2.78, 3.14]");
    }
    @Test
    public void testWildCardsWithSuper(){
        List<Object> objs = Arrays.<Object>asList(2, 3.14, "four");
        List<Integer> ints = Arrays.asList(5, 6);
        copy(objs, ints);
        assert objs.toString().equals("[5, 6, four]");
    }
    @Test
    public void testExtendWildcard(){
        List<Integer> ints = Arrays.asList(1, 2, 3);
        assert sum(ints) == 6.0;

        List<Double> doubles = Arrays.asList(2.78, 3.14);
        assert sum(doubles) == 5.92;

        List<Number> nums = Arrays.<Number>asList(1,2,2.78, 3.14);
        assert sum(nums) == 8.92;
    }

    @Test
    public void testSuperWildcard(){
        List<Integer> ints = new ArrayList<>();
        count(ints, 5);
        assert ints.toString().equals("[0, 1, 2, 3, 4]");

        List<Number> nums = new ArrayList<>();
        count(nums, 5); nums.add(5.0);
        assert nums.toString().equals("[0, 1, 2, 3, 4, 5.0]");

        List<Object> objs = new ArrayList<>();
        count(objs, 5); objs.add("five");
        assert objs.toString().equals("[0, 1, 2, 3, 4, five]");
    }

    @Test
    public void testPutAndGetToStructure(){
        List<Number> nums = new ArrayList<>();
        double sum = sumCount(nums, 5);
        assert sum == 10;
    }
    //accept any type of list and reverse it
    private <T> void reverse(List<T> list){
        List<T> tmp = new ArrayList<>();
        for (int i = 0; i < list.size(); i++){
            list.set(i, tmp.get(list.size()-i-1));
        }
    }
    //Method to sort Array
    private <T> void sort(T[] a){

    }
    //Method to fill Array
    private <T> void fill(T[] a, T val){

    }

    //method takes a collection of numbers, coverts each to a double, and sums them up.
    // HOW TO USE EXTEND IN GENERICS
    private double sum(Collection<? extends Number> nums){
        double s = 0.0;
        for(Number num : nums) s += num.doubleValue();
        return s;
    }
    //method that takes a collection of numbers and integer n, and puts the first n integers,  starting from zero,
    // into collection
    // HOW TO USE SUPER IN GENERICS
    private void count(Collection<? super Integer> ints, int n){
        for(int i=0; i<n; i++) ints.add(i);
    }
//Where both put values into and get values out of the same structure, you should not use a wildcard:
    private double sumCount(Collection<Number> nums, int n){
        count(nums, n);
        return sum(nums);
    }

    /*The Get and Put Principle: use an extends wildcards when you only get values out of a structure,
    use  a super wildcards when you only put values into a structure, and don't use a wildcard when you both
    get and put*/

    //copies destination list all of the elements from a source list, from the convenience class Collections:
    private  <T> void copy(List<? super T> dst, List<? extends T> src){
        //? super T means that the destination list may have elements of any type that is a supertype of T.
        //source list may have elements of any type that is a subtype of T.
        for(int i=0; i < src.size(); i++){
            dst.set(i, src.get(i));
        }
    }
    //Array covert to list
    private <T> List<T> toList(T[] arr){
        List<T> list = new ArrayList<>();
        for (T elt : arr) list.add(elt);
        return list;
    }
    //Array convert to list with varargs
    private <T> List<T> toListWithVarrags(T... arr){
        List<T> list = new ArrayList<>();
        for(T elt : arr) list.add(elt);
        return list;
    }
    //add additional items to the end of the list
    private <T> void addAll(List<T> list, T... arr){
        for(T elt : arr) list.add(elt);
    }
}
