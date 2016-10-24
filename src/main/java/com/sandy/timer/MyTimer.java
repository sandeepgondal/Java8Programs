package com.sandy.timer;

public class MyTimer {

    public static void compute(Runnable runnable) {
        long start = System.currentTimeMillis();
        runnable.run();
        long end = System.currentTimeMillis();
        long totalTime = end - start;
        System.out.println("Total time taken: " + totalTime / 1000);
    }

}
