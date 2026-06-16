package com.microservice.course.appredisspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class AppRedisSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppRedisSpringbootApplication.class, args);
    }

}
