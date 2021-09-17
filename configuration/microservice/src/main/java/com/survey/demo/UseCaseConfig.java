package com.survey.demo;

import com.survey.demo.command.CustomerAnswersCommandUseCase;
import com.survey.demo.handler.SurveyHandlerUseCase;
import com.survey.demo.repository.*;
import org.reactivecommons.utils.ObjectMapper;
import org.reactivecommons.utils.ObjectMapperImp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapperImp();
    }

    @Bean
    public SurveyHandlerUseCase surveyUseCase(SurveyRepository surveyRepository, QuestionRepository questionRepository) {
        return new SurveyHandlerUseCase(surveyRepository, questionRepository);
    }

    @Bean
    public CustomerAnswersCommandUseCase surveyCustomerAnswersCommandUseCaseyUseCase(CustomersRepository customersRepository, CustomersAnswerRepository customersAnswerRepository,
                                                                                     CustomersAnswerDetailRepository customersAnswerDetailRepository) {
        return new CustomerAnswersCommandUseCase(customersRepository, customersAnswerRepository, customersAnswerDetailRepository);
    }
}
