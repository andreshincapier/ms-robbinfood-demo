package com.robinfood.demo.jpa.entities.questions;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@NoArgsConstructor
@Table(name = "question")
public class QuestionData {

    @Id
    private String id;

    @Column(name = "content")
    private String content;

    @Column(name = "survey_id_pk")
    private String surveyId;

    @Column(name = "status")
    private String status;

}
