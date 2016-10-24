package com.sandy.java8;

public class LambdaClass {

    public static void main(String[] args) {

        // Non Lambda
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Inside Thread 1");
            }
        });
        thread1.start();

        // Lambda
        Thread thread2 = new Thread(() -> System.out.println("Inside Thread 2"));
        thread2.start();

        System.out.println("Inside main");

    }

}
