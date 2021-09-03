package com.robinfood.demo.command;

import com.robinfood.demo.dto.CommandResponseDTO;
import com.robinfood.demo.dto.UserSurveyAnswersDTO;
import com.robinfood.demo.entity.CustomerAnswers;
import com.robinfood.demo.entity.CustomerAnswersDetail;
import com.robinfood.demo.entity.Customers;
import com.robinfood.demo.repository.CustomersAnswerDetailRepository;
import com.robinfood.demo.repository.CustomersAnswerRepository;
import com.robinfood.demo.repository.CustomersRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import reactor.core.publisher.Mono;

import static com.robinfood.demo.util.DateFunctions.getActualTimeLong;
import static com.robinfood.demo.util.RandomUtil.unique;
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
        return StringUtils.isNoneBlank(userSurveyAnswers.getName()) &&
                StringUtils.isNoneBlank(userSurveyAnswers.getEmail()) &&
                StringUtils.isNoneBlank(userSurveyAnswers.getSurveyId());
    }
}
