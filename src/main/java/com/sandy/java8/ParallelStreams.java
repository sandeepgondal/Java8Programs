package com.sandy.java8;

import com.sandy.timer.MyTimer;

import java.util.Arrays;
import java.util.List;

//Use parallel stream only when:
//        1	Problem on hand is actually parallelizable.
//        2	You are willing to spend lot more resource.
//        3	When number of items are big enough, then you will get performance benefits.
//        4	Task computation is big enough.
public class ParallelStreams {

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);

        // Non Parallel
        MyTimer.compute(() -> System.out.println("\nNon Parallel: " +
                integers.stream()
                        .mapToInt(ParallelStreams::compute)
                        .sum()));

        // Parallel
        MyTimer.compute(() -> System.out.println("\nParallel: " +
                integers.parallelStream()
                        .mapToInt(ParallelStreams::compute)
                        .sum()));
    }

    private static int compute(final Integer integer) {
        // This is time intensive
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return integer * 2;
    }

}
