package com.survey.demo.command;

import com.survey.demo.dto.CommandResponseDTO;
import com.survey.demo.dto.UserSurveyAnswersDTO;
import com.survey.demo.entity.CustomerAnswers;
import com.survey.demo.entity.CustomerAnswersDetail;
import com.survey.demo.entity.Customers;
import com.survey.demo.repository.CustomersAnswerDetailRepository;
import com.survey.demo.repository.CustomersAnswerRepository;
import com.survey.demo.repository.CustomersRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

import static com.survey.demo.util.DateFunctions.getActualTimeLong;
import static com.survey.demo.util.RandomUtil.unique;
import static java.util.Objects.nonNull;
import static reactor.core.publisher.Flux.fromIterable;
import static reactor.core.publisher.Mono.just;

@Slf4j
@RequiredArgsConstructor
public class CustomerAnswersCommandUseCase {

    private final CustomersRepository customersRepository;
    private final CustomersAnswerRepository customersAnswerRepository;
    private final CustomersAnswerDetailRepository customersAnswerDetailRepository;

    public Mono<CommandResponseDTO> saveCustomersAnswers(UserSurveyAnswersDTO surveyAnswers) {
        log.info("ENTER IN CustomerAnswersCommandUseCase :: saveCustomersAnswers {}", surveyAnswers);

        return Mono.justOrEmpty(surveyAnswers)
                .filter(this::validateData)
                .map(surveyAnswersDTO -> Customers.builder()
                        .id(unique())
                        .name(surveyAnswers.getName())
                        .email(surveyAnswers.getEmail())
                        .build()
                )
                .flatMap(customersRepository::save)
                .flatMap(customers -> just(CustomerAnswers.builder()
                        .id(unique())
                        .customerId(customers.getId())
                        .creationDate(getActualTimeLong())
                        .surveyId(surveyAnswers.getSurveyId())
                        .build())
                        .flatMap(customersAnswerRepository::save)
                )
                .flatMap(customerAnswers -> fromIterable(surveyAnswers.getQuestionList())
                        .map(answersDetail -> CustomerAnswersDetail.builder()
                                .id(unique())
                                .customersAnswersId(customerAnswers.getId())
                                .questionId(answersDetail.getQuestionId())
                                .answer(answersDetail.getAnswer())
                                .build()
                        )
                        .flatMap(customersAnswerDetailRepository::save)
                        .collectList()
                )
                .map(customerAnswersDetails -> CommandResponseDTO.builder().message("Survey has send successful").build())
                .switchIfEmpty(Mono.defer(() -> Mono.error(new RuntimeException("PAYLOAD EXCEPTION"))))
                .doOnError(error -> log.error("ERROR IN CustomerAnswersCommandUseCase :: saveCustomersAnswers {}", error.getMessage()));
    }

    private boolean validateData(UserSurveyAnswersDTO userSurveyAnswers) {
        return nonNull(userSurveyAnswers.getName()) &&
                nonNull(userSurveyAnswers.getEmail()) &&
                nonNull(userSurveyAnswers.getSurveyId()) &&
                nonNull(userSurveyAnswers.getQuestionList());
    }
}
