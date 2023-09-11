package com.spring.annotation.SpringAnnotation.config;

import com.spring.annotation.SpringAnnotation.model.TestBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public TestBean testBean(){
        System.out.println("testBean object created");

        return new TestBean();
    }

}