package com.survey.demo.dto;

import lombok.*;

import java.util.List;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class UserSurveyAnswersDTO {

    private String name;
    private String lastName;
    private Long phoneNumber;
    private String email;
    private String surveyId;
    private List<UserAnswersDTO> questionList;
}
