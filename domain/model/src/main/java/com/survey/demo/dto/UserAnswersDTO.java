package com.survey.demo.dto;

import lombok.*;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class UserAnswersDTO {

    private String questionId;
    private String answer;

}
