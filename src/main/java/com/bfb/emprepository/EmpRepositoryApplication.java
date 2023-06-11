package com.bfb.emprepository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
//For enabling caffeine caching
@EnableCaching
public class EmpRepositoryApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmpRepositoryApplication.class, args);
    }

}
