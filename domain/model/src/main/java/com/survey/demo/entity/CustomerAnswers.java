package com.survey.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder(toBuilder = true)
public class CustomerAnswers {

    private String id;
    private String customerId;
    private Long creationDate;
    private String surveyId;
}
