package com.robinfood.demo.web;

import com.robinfood.demo.SurveyUseCase;
import com.robinfood.demo.entity.Survey;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping(path = "/api/robin-food/survey")
@AllArgsConstructor
public class SurveyQueryHandler {

    private final SurveyUseCase useCase;

    @GetMapping("/list-all-active")
    public Flux<Survey> listAllActiveSurvey() {
        return useCase.listAllActiveSurvey();
    }

}
