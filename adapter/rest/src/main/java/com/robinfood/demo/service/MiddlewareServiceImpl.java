package com.robinfood.demo.service;//package co.com.sofka.ms.test.rest.service;
//
//import com.compensar.customer.adapter.rest.MiddlewareService;
//import com.compensar.customer.dto.command.UserDTO;
//import co.com.sofka.ms.test.rest.AbstractRestImpl;
//import lombok.extern.slf4j.Slf4j;
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.MediaType;
//import org.springframework.stereotype.Service;
//import org.springframework.web.reactive.function.client.WebClient;
//import reactor.core.publisher.Mono;
//
//@Slf4j
//@Service
//class MiddlewareServiceImpl extends AbstractRestImpl<UserDTO, UserDTO> implements MiddlewareService {
//
//    @Value("${client.middleware.host}")
//    String baseHost;
//    @Value("${client.middleware.handler.email}")
//    String baseUriUser;
//    @Value("${client.middleware.handler.userExists}")
//    String baseUriUserExists;
//    @Value("${client.middleware.handler.users}")
//    String baseUriUsers;
//    @Value("${client.retry}")
//    private Integer retry;
//    WebClient clientMiddleware;
//    @Value("${client.middleware.handler.user}")
//    String baseUriMiddlewareUser;
//
//    public MiddlewareServiceImpl(ModelMapper mapper) {
//        super(mapper, Boolean.class, UserDTO.class);
//        clientMiddleware = WebClient.create(baseHost);
//    }
//
//    public Mono<Boolean> sendEmail(final String customerId) {
//        clientMiddleware = WebClient.builder()
//                .baseUrl(baseHost)
//                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
//                .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
//                .build();
//
//        return clientMiddleware.get()
//                .uri(baseUriUser.concat(customerId))
//                .accept(MediaType.APPLICATION_JSON)
//                .retrieve()
//                .bodyToMono(Boolean.class)
//                .retry(retry)
//                .doOnError(error -> log.error(" Error Middleware - sendEmail: {} ", error.getMessage()));
//    }
//
//    @Override
//    public Mono<UserDTO> getUser(String cid) {
//        clientMiddleware = WebClient.builder()
//                .baseUrl(baseHost)
//                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
//                .defaultHeader(HttpHeaders.AUTHORIZATION, cid)
//                .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
//                .build();
//        log.debug("ENTRO A MIDDLEWARE");
//        log.debug(" retry : {} ", retry);
//        return clientMiddleware.get()
//                .uri(baseUriMiddlewareUser)
//                .accept(MediaType.APPLICATION_JSON)
//                .retrieve()
//                .bodyToMono(UserDTO.class)
//                .retry(retry)
//                .map(response -> getMapper().map(response, UserDTO.class))
//                .doOnError(error -> log.error(" Error adapter Middleware - getUser: {} ", error.getMessage()))
//                .onErrorResume(error -> Mono.error(new RuntimeException(error.getMessage())));
//    }
//
//    @Override
//    public Mono<UserDTO> findByUserId(String customerId) {
//        clientMiddleware = WebClient.builder()
//                .baseUrl(baseHost)
//                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
//                .defaultHeader(HttpHeaders.AUTHORIZATION)
//                .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
//                .build();
//        return clientMiddleware.get()
//                .uri(baseUriUserExists + customerId)
//                .accept(MediaType.APPLICATION_JSON)
//                .retrieve()
//                .bodyToMono(UserDTO.class)
//                .retry(retry)
//                .map(response -> getMapper().map(response, UserDTO.class))
//                .doOnError(error -> log.error(" Error Middleware findByUserId : {} ", error.getMessage()))
//                .onErrorResume(error -> Mono.error(new RuntimeException(error.getMessage())));
//    }
//
//    @Override
//    public Mono<Long> countByNitAndEstado(String nit, String status, String cid) {
//        clientMiddleware = WebClient.builder()
//                .baseUrl(baseHost)
//                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
//                .defaultHeader(HttpHeaders.AUTHORIZATION, cid)
//                .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
//                .build();
//        return clientMiddleware.get()
//                .uri(uriBuilder -> uriBuilder
//                        .path(baseUriUsers)
//                        .queryParam("nit", nit)
//                        .queryParam("status", status)
//                        .build()
//                )
//                .accept(MediaType.APPLICATION_JSON)
//                .retrieve()
//                .bodyToMono(Long.class)
//                .retry(retry)
//                .doOnError(error -> log.error(" Error Middleware countByNitAndEstado : {} ", error.getMessage()))
//                .onErrorResume(error -> Mono.error(new RuntimeException(error.getMessage())));
//    }
//
//}
