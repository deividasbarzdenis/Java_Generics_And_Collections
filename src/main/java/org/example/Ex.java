package org.example;

import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Ex {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ts = new int[n];
        for(int i = 0; i < n; i++){
            ts[i] = in.nextInt();
        }
        PrintStream outStream = System.out;
        System.setOut(System.err);
        int solution = computeClosesToZero(ts);
        System.out.println(outStream);
        System.out.println(solution);
    }

    private static int computeClosesToZero(int[] ts) {
        if (ts.length != 0) {
            double near = ts[0];
            for (int i = 0; i < ts.length; i++) {
                // here we are using Math.abs to manage the negative and positive number
                if (Math.abs(ts[i]) <= Math.abs(near)) {
                    // manage the case when we have two equal negative numbers
                    if (ts[i] == -near) {
                        near = Math.abs(ts[i]);
                    } else {
                        near = ts[i];
                    }
                }
            }
            return (int) near;
        } else {
            return 0;
        }
    }
}
