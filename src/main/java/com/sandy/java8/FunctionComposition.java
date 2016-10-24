package com.sandy.java8;


import java.util.Arrays;
import java.util.List;

// You have chaining or pipelining of functions
public class FunctionComposition {

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        System.out.println(
            integers.stream()
                    .filter(i -> i % 2 == 0)
                    .mapToInt(i -> i * 2)
                    .sum());
    }

}
