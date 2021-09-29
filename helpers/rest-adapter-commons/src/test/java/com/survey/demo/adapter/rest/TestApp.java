package com.survey.demo.adapter.rest;

import org.modelmapper.ModelMapper;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import static org.springframework.boot.SpringApplication.run;

@SpringBootApplication
public class TestApp {
    public static void main(String[] args) {
        run(TestApp.class, args);
    }

    @Bean
    public ModelMapper objectMapper() {
        return new ModelMapper();
    }

}
