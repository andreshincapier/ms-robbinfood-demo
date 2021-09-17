package com.survey.demo.postgres.customeranswers;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@NoArgsConstructor
@Table(name = "customers_answers")
public class CustomersAnswerData {

    @Id
    private String id;

    @Column(name = "customer_id_fk")
    private String customerId;

    @Column(name = "creation_date")
    private Long creationDate;

    @Column(name = "customer_survey_id_fk")
    private String surveyId;

}
