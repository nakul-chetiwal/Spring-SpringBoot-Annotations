package com.spring.annotation.SpringAnnotation.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("prod")
public class DBConfig {

    @Value("${db.driverClass}")
    private String driverClass;
    @Value("${db.url}")
    private String url;
    @Value("${db.username}")
    private String username;
    @Value("${db.password}")
    private String password;

    // There is no difference if @Profiles annotation is placed below @Bean instead of at class level
    @Bean
    public String dataSourceProps() {
        System.out.println("key values from DBConfig Bean" + driverClass + " : " + url + " : " + username + " : " + password);
        return "DataSource connection for dev";
    }
}