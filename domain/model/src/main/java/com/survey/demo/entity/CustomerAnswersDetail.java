package com.survey.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder(toBuilder = true)
public class CustomerAnswersDetail {

    private String id;
    private String customersAnswersId;
    private String questionId;
    private String answer;
}
