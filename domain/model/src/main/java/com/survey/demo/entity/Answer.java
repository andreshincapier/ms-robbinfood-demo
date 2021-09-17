package com.survey.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder(toBuilder = true)
public class Answer {

    private String id;
    private String name;
    private String lastName;
    private Long phone;
    private String email;
    private String status;

}
