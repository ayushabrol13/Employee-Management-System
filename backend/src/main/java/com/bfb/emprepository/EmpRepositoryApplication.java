package com.bfb.emprepository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@EnableJpaRepositories("com.bfb.emprepository.dao")
@EnableCaching

public class EmpRepositoryApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmpRepositoryApplication.class, args);
    }

}
