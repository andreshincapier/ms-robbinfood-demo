package com.robinfood.demo;

import com.robinfood.demo.command.CustomerAnswersCommandUseCase;
import com.robinfood.demo.handler.ObserverHandlerUseCase;
import com.robinfood.demo.handler.SurveyHandlerUseCase;
import com.robinfood.demo.repository.ConfigurationRepository;
import com.robinfood.demo.repository.CustomersRepository;
import com.robinfood.demo.repository.QuestionRepository;
import com.robinfood.demo.repository.SurveyRepository;
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
    public ObserverHandlerUseCase observerUseCase(ConfigurationRepository configurationRepository) {
        return new ObserverHandlerUseCase(configurationRepository);
    }

    @Bean
    public SurveyHandlerUseCase surveyUseCase(SurveyRepository surveyRepository, QuestionRepository questionRepository) {
        return new SurveyHandlerUseCase(surveyRepository, questionRepository);
    }

    @Bean
    public CustomerAnswersCommandUseCase surveyCustomerAnswersCommandUseCaseyUseCase(SurveyRepository surveyRepository, QuestionRepository questionRepository, CustomersRepository customersRepository) {
        return new CustomerAnswersCommandUseCase(surveyRepository, questionRepository, customersRepository);
    }
}
