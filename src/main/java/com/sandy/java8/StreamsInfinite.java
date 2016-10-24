package com.sandy.java8;

import java.util.stream.Stream;

public class StreamsInfinite {

    public static void main(String[] args) {
        // From number k, for count n, find total of double of n, where n is even and sqrt(n) > 20

        int k = 123;
        int n = 20;

        // Normal way
        int index = k;
        int count = 0;
        int result = 0;
        while (count < n) {
            if (isEven(index) && isSqrtGreaterThan20(index)) {
                result += doubleIt(index);
                count++;
            }
            index++;
        }
        System.out.println(result);


        // Streams way
        System.out.println(
                Stream.iterate(k, e -> e + 1)                       // Infinite stream,
                    .filter(StreamsInfinite::isEven)                // lazy evaluation
                    .filter(StreamsInfinite::isSqrtGreaterThan20)   // lazy evaluation
                    .mapToInt(StreamsInfinite::doubleIt)            // lazy evaluation
                    .limit(n)                                       // lazy evaluation
                    .sum()
        );

    }

    private static int doubleIt(final int index) {
        return index * 2;
    }

    private static boolean isSqrtGreaterThan20(final int index) {
        return Math.sqrt(index) > 2;
    }

    private static boolean isEven(final int index) {
        return index % 2 == 0;
    }

}
