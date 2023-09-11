package com.spring.annotation.SpringAnnotation.model;

public class TestBean {
    public void TestBeanMethod(){
        System.out.println("TestBean method-TestBeanMethod logic executed ");
    }
}

// Above we could have also made a Spring bean through @Component but we did it with the
// help of @configuration and @bean annotation