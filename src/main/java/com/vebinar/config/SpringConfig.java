package com.vebinar.config;

import com.vebinar.service.TestBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    @Bean
    public TestBean getTestBean () {
        return new TestBean("Hello!");
    }

    @Bean
    public JdbcTemplate getJdbcTemplate() {
        return new JdbcTemplate(getDataSource());
    }

    private DataSource getDataSource() {
    }

}
