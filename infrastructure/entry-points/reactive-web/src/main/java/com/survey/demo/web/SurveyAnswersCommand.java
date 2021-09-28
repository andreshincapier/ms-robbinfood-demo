package com.survey.demo.web;

import com.survey.demo.command.CustomerAnswersCommandUseCase;
import com.survey.demo.dto.CommandResponseDTO;
import com.survey.demo.dto.UserSurveyAnswersDTO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(path = "/api/robin-food/survey")
@AllArgsConstructor
public class SurveyAnswersCommand {

    private final CustomerAnswersCommandUseCase useCase;

    @PostMapping(path = "/save-answers")
    public Mono<CommandResponseDTO> saveCustomersAnswers(@RequestBody UserSurveyAnswersDTO surveyAnswers) {
        return useCase.saveCustomersAnswers(surveyAnswers);
    }
}
