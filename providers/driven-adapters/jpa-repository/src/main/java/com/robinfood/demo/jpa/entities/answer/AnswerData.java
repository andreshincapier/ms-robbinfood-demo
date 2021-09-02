package com.robinfood.demo.jpa.entities.answer;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@NoArgsConstructor
@Table(name = "answer")
public class AnswerData {

    @Id
    private String id;

    @Column(name = "description")
    private String lastName;

    @Column(name = "question_id")
    private String questionId;

    @Column(name = "name")
    private String name;

    @Column(name = "is_correct")
    private Boolean isCorrect;

    @Column(name = "status")
    private Boolean status;

}
