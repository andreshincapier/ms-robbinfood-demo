package com.survey.demo.handler;

import com.survey.demo.command.CustomerAnswersCommandUseCase;
import com.survey.demo.dto.CommandResponseDTO;
import com.survey.demo.dto.UserAnswersDTO;
import com.survey.demo.dto.UserSurveyAnswersDTO;
import com.survey.demo.entity.CustomerAnswers;
import com.survey.demo.entity.CustomerAnswersDetail;
import com.survey.demo.entity.Customers;
import com.survey.demo.repository.CustomersAnswerDetailRepository;
import com.survey.demo.repository.CustomersAnswerRepository;
import com.survey.demo.repository.CustomersRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.List;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class CustomerAnswersCommandUseCaseTest {

    private CustomerAnswersCommandUseCase useCase;

    @Mock
    private CustomersRepository customersRepository;
    @Mock
    private CustomersAnswerRepository customersAnswerRepository;
    @Mock
    private CustomersAnswerDetailRepository customersAnswerDetailRepository;


    @Before
    public void init() {
        useCase = new CustomerAnswersCommandUseCase(customersRepository, customersAnswerRepository, customersAnswerDetailRepository);
    }

    @Test
    public void shouldCreateGetHeaderByDate() {
        when(customersRepository.save(any())).thenReturn(Mono.just(customer));
        when(customersAnswerRepository.save(any())).thenReturn(Mono.just(customerAnswers));
        when(customersAnswerDetailRepository.save(any())).thenReturn(Mono.just(detail));

        StepVerifier.withVirtualTime(() -> useCase.saveCustomersAnswers(surveyAnswersDTO))
                .expectNext(commandResponseDTO)
                .verifyComplete();
    }

    final Customers customer = Customers
            .builder()
            .id("one")
            .name("two")
            .lastName("two")
            .phone(10044848L)
            .email("two")
            .status("ACTIVE")
            .build();


    final UserAnswersDTO userAnswersDTO = UserAnswersDTO
            .builder()
            .questionId("two")
            .answer("two")
            .build();

    final UserSurveyAnswersDTO surveyAnswersDTO = UserSurveyAnswersDTO
            .builder()
            .name("two")
            .lastName("two")
            .phoneNumber(10044848L)
            .email("algo@example.com")
            .surveyId("two")
            .questionList(List.of(userAnswersDTO))
            .build();

    final CustomerAnswers customerAnswers = CustomerAnswers
            .builder()
            .id("two")
            .customerId("two")
            .creationDate(10044848L)
            .surveyId("two")
            .build();

    final CustomerAnswersDetail detail = CustomerAnswersDetail
            .builder()
            .id("two")
            .customersAnswersId("two")
            .questionId("10044848L")
            .answer("two")
            .build();

    final CommandResponseDTO commandResponseDTO = CommandResponseDTO
            .builder()
            .message("Survey has send successful")
            .build();
}