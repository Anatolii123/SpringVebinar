package com.vebinar.config;

import com.vebinar.service.TestBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public TestBean getTestBean () {
        return new TestBean("Hello!");
    }
}
