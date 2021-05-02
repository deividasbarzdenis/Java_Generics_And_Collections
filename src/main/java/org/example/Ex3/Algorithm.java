package org.example.Ex3;

public class Algorithm {

    /**
    Write a generic method to exchange the positions of two different elements in an array
    */
    public static <T> void swap(T[] a, int i, int j) {
        T temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
