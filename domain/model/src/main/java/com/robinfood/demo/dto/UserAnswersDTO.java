package com.robinfood.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder(toBuilder = true)
public class UserAnswersDTO {

    private String questionId;
    private String answer;

}
