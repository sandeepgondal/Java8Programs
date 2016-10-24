package com.sandy.java8;

import org.junit.Test;

public class DefaultMethodsImplTest {

    @Test
    public void shouldBeAbleToInvokeDefaultNonDefaultMethods() throws Exception {
        DefaultMethods defaultMethods = new DefaultMethodsImpl();
        defaultMethods.defaultMethod();
        defaultMethods.nonDefaultMethod();
    }
}
