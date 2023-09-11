package com.spring.annotation.SpringAnnotation.model;

import org.springframework.stereotype.Component;

@Component
public class EagerLoadingBean {
    public EagerLoadingBean() {
        System.out.println("EagerLoadingBean constructor called..spring bean created");
    }
}
