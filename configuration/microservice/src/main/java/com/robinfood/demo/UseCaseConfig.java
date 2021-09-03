package com.robinfood.demo;

import com.robinfood.demo.repository.ConfigurationRepository;
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
    public ObserverUseCase observerUseCase(ConfigurationRepository configurationRepository) {
        return new ObserverUseCase(configurationRepository);
    }

    @Bean
    public SurveyUseCase surveyUseCase(SurveyRepository surveyRepository, QuestionRepository questionRepository) {
        return new SurveyUseCase(surveyRepository, questionRepository);
    }
}
