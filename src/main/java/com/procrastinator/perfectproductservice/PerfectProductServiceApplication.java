package com.procrastinator.perfectproductservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class PerfectProductServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PerfectProductServiceApplication.class, args);
    }

} 