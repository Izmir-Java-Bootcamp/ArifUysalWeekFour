package com.kodluyoruz.homeworkfourv1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaAuditing
@EnableJpaRepositories
public class Homeworkfourv1Application {

    public static void main(String[] args) {
        SpringApplication.run(Homeworkfourv1Application.class, args);
    }

}
