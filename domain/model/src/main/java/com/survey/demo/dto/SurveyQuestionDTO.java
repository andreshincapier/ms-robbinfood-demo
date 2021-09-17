package com.survey.demo.dto;

import com.survey.demo.entity.Question;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@Builder(toBuilder = true)
public class SurveyQuestionDTO {

    private String id;
    private String name;
    private String description;
    private String status;
    private List<Question> questionList;

}
