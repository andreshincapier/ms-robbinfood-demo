package com.robinfood.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
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
