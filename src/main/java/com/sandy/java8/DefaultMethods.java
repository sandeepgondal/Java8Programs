package com.sandy.java8;

public interface DefaultMethods {

    void nonDefaultMethod();

    default void defaultMethod() {
        System.out.println("Withing default method");
    }

}
