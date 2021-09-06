package com.robinfood.demo;

import com.robinfood.demo.command.CustomerAnswersCommandUseCase;
import com.robinfood.demo.handler.SurveyHandlerUseCase;
import com.robinfood.demo.repository.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.reactivecommons.utils.ObjectMapper;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class UseCaseConfigTest {

    @InjectMocks
    UseCaseConfig useCaseConfig;

    @Mock
    SurveyRepository surveyRepository;

    @Mock
    QuestionRepository questionRepository;

    @Mock
    CustomersRepository customersRepository;

    @Mock
    CustomersAnswerRepository customersAnswerRepository;

    @Mock
    CustomersAnswerDetailRepository customersAnswerDetailRepository;

    @Test
    public void objectMapperIsNotNull() {
        ObjectMapper objectMapper = useCaseConfig.objectMapper();
        assertThat(objectMapper).isNotNull();
    }

    @Test
    public void surveyUseCase() {
        SurveyHandlerUseCase messageUseCase = useCaseConfig.surveyUseCase(surveyRepository, questionRepository);
        assertThat(messageUseCase).isNotNull();
    }

    @Test
    public void surveyCustomerAnswersCommandUseCaseyUseCase() {
        CustomerAnswersCommandUseCase messageUseCase = useCaseConfig.surveyCustomerAnswersCommandUseCaseyUseCase(
                customersRepository,
                customersAnswerRepository,
                customersAnswerDetailRepository);
        assertThat(messageUseCase).isNotNull();
    }

}