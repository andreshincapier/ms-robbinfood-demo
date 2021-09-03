package com.robinfood.demo.web;

import com.robinfood.demo.handler.ObserverHandlerUseCase;
import com.robinfood.demo.entity.Configuration;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(path = "/api/ms-test/api/test")
@AllArgsConstructor
public class TestQueryHandler {

    private final ObserverHandlerUseCase observerHandlerUseCase;

    @GetMapping("/test")
    public Mono<Configuration> getCOnfigurations() {
        return observerHandlerUseCase.configuration();
    }

}
