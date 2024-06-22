package com.example.apre;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.apre")
@EntityScan(basePackages = "com.example.apre.entity")
public class ApreApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApreApplication.class, args);
    }
}
