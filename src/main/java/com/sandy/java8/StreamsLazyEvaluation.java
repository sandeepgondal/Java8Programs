package com.sandy.java8;

import java.util.Arrays;
import java.util.List;

public class StreamsLazyEvaluation {

    // Get double of first even number which is greater than 3
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2, 5, 3, 6, 4, 8, 7, 9, 10, 11, 13, 12, 15, 14, 16, 17, 18, 20, 19);

        // Old way
        int result = 0;
        for (int i = 0; i < integers.size(); i++) {
            int n = integers.get(i);
            if (isGreaterThan3(n) && isEven(n)) {
                result = doubleIt(n);
                break;
            }
        }
        System.out.println("*** From iteration : " + result);

        // Streams way -- these are evaluated in a lazy way. Every value goes through all the functions and when value is identified, it will be terminated.
        System.out.println("*** From Streams : " +
                integers.stream()
                        .filter(StreamsLazyEvaluation::isGreaterThan3)
                        .filter(StreamsLazyEvaluation::isEven)
                        .mapToInt(StreamsLazyEvaluation::doubleIt)
                        .findFirst()
        );

    }

    private static int doubleIt(final int n) {
        System.out.println("doubleIt : " + n);
        return n * 2;
    }

    private static boolean isEven(final int n) {
        System.out.println("isEven : " + n);
        return n % 2 == 0;
    }

    private static boolean isGreaterThan3(final int n) {
        System.out.println("isGreaterThan3 : " + n);
        return n > 3;
    }

}
