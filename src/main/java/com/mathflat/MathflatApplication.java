package com.mathflat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class MathflatApplication {

    public static void main(String[] args) {
        SpringApplication.run(MathflatApplication.class, args);
    }
}
