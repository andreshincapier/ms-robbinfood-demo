package com.survey.demo.postgres.detailanswers;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@NoArgsConstructor
@Table(name = "customers_answers_detail")
public class CustomersAnswerDetailData {

    @Id
    private String id;

    @Column(name = "customers_answers_fk")
    private String customersAnswersId;

    @Column(name = "question_fk")
    private String questionId;

    @Column(name = "answer")
    private String answer;

}
