package com.survey.demo.web;

import com.survey.demo.dto.SurveyQuestionDTO;
import com.survey.demo.entity.Survey;
import com.survey.demo.handler.SurveyHandlerUseCase;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(path = "/api/robin-food/survey")
@AllArgsConstructor
public class SurveyQueryHandler {

    private final SurveyHandlerUseCase useCase;

    @GetMapping("/list-all-active")
    public Flux<Survey> listAllActiveSurvey() {
        return useCase.listAllActiveSurvey();
    }

    @GetMapping("/list-questions-by-survey/{surveyId}")
    public Mono<SurveyQuestionDTO> listAllQuestionsBySurveyId(@PathVariable("surveyId") final String surveyId) {
        return useCase.findAllQuestionsBySurveyId(surveyId);
    }

}
