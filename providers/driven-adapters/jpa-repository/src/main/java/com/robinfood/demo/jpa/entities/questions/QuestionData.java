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
@Table(name = "survey")
public class QuestionData {

    @Id
    private String id;

    @Column(name = "content")
    private String name;

    @Column(name = "survey_id")
    private String lastName;

    @Column(name = "status")
    private String status;

}
