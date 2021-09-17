package com.survey.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder(toBuilder = true)
public class Survey {

    private String id;
    private String name;
    private String description;
    private String status;

}
