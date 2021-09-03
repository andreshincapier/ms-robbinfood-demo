package com.robinfood.demo.command;

import com.robinfood.demo.dto.UserSurveyAnswersDTO;
import com.robinfood.demo.repository.CustomersRepository;
import com.robinfood.demo.repository.QuestionRepository;
import com.robinfood.demo.repository.SurveyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import reactor.core.publisher.Mono;

@Slf4j
@RequiredArgsConstructor
public class CustomerAnswersCommandUseCase {

    private final SurveyRepository surveyRepository;
    private final QuestionRepository questionRepository;
    private final CustomersRepository customersRepository;

    public Mono<UserSurveyAnswersDTO> saveCustomersAnswers(UserSurveyAnswersDTO surveyAnswers) {
        log.info("ENTER IN CustomerAnswersCommandUseCase :: saveCustomersAnswers {}", surveyAnswers);
        return null;
    }


    private boolean validateData(UserSurveyAnswersDTO userSurveyAnswers) {
        return StringUtils.isNoneBlank(userSurveyAnswers.getName()) &&
                StringUtils.isNoneBlank(userSurveyAnswers.getEmail()) &&
                StringUtils.isNoneBlank(userSurveyAnswers.getSurveyId()) &&
                userSurveyAnswers.getQuestionList().isEmpty();
    }
}
