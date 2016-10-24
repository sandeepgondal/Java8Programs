package com.sandy.java8;

import java.util.Arrays;
import java.util.List;

public class LambdaMethodReference {

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

/*
        // Basic iteration to print all numbers
        for (int i = 0; i < integers.size(); i++) {
            System.out.println(integers.get(i));
        }
*/

/*
        // enhanced for loop
        for (Integer i : integers) {
            System.out.println(i);
        }

*/

/*
        // Internal iterator
        integers.forEach(new Consumer<Integer>() {
            @Override
            public void accept(final Integer i) {
                System.out.println(i);
            }
        });
*/

/*
        // Internal iterator with lambda
        integers.forEach((Integer i) -> System.out.println(i));
*/

/*
        // Lambda without parenthesis
        integers.forEach(i -> System.out.println(i));
*/

        // Replacing lambdas with method references
        integers.forEach(System.out::println);

        // Sum all integers
        Integer sum = integers.stream()
//                  .reduce(0, (total, i) -> Integer.sum(total, i));
                    .reduce(0, Integer::sum);
        System.out.println(sum);

        // Concatenate all integers
        String con = integers.stream()
                .map(String::valueOf)
//                .reduce("", (c, s) -> c.concat(s));
                .reduce("", String::concat);
        System.out.println(con);
    }

}
