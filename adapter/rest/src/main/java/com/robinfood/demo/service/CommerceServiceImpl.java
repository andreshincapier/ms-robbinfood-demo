//package com.robinfood.demo.service;

//import lombok.extern.slf4j.Slf4j;
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.MediaType;
//import org.springframework.stereotype.Service;
//import org.springframework.web.reactive.function.client.WebClient;
//import reactor.core.publisher.Flux;
//import reactor.core.publisher.Mono;
//
//
//@Slf4j
//@Service
//class CommerceServiceImpl extends AbstractRestImpl<WellnessHoursDTO, WellnessHoursResponse> implements CommerceService {
//
//    @Value("${client.commerce.host}")
//    String baseHost;
//    @Value("${client.commerce.handler.wellness}")
//    String baseUriWellnessHours;
//    @Value("${client.commerce.handler.order-history}")
//    String baseUriOrderHistory;
//    WebClient clientMsCommerce;
//    @Value("${client.retry}")
//    private Integer retry;
//
//    public CommerceServiceImpl(ModelMapper mapper) {
//        super(mapper, WellnessHoursDTO.class, WellnessHoursResponse.class);
//        clientMsCommerce = WebClient.create(baseHost);
//    }
//
//    public Mono<WellnessHoursDTO> findByUserId(String userId, String cid) {
//        clientMsCommerce = WebClient.builder()
//                .baseUrl(baseHost)
//                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
//                .defaultHeader(HttpHeaders.AUTHORIZATION, cid)
//                .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
//                .build();
//        return clientMsCommerce.get()
//                .uri(baseUriWellnessHours + userId)
//                .accept(MediaType.APPLICATION_JSON)
//                .retrieve()
//                .bodyToMono(WellnessHoursResponse.class)
//                .retry(retry)
//                .map(this::mapToDto)
//                .doOnError(error -> log.error("Error Adapter WellnessHoursServiceImpl.wellnessHour ({},{}) - {}", userId, cid, error.getMessage()));
//    }
//
//    @Override
//    public Flux<OrderHistoryDTO> orderHistoryByCustomerId(String userId, String cid) {
//        clientMsCommerce = WebClient.builder()
//                .baseUrl(baseHost)
//                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
//                .defaultHeader(HttpHeaders.AUTHORIZATION, cid)
//                .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
//                .build();
//        return clientMsCommerce.get()
//                .uri(baseUriOrderHistory + userId)
//                .accept(MediaType.APPLICATION_JSON)
//                .retrieve()
//                .bodyToFlux(OrderHistoryResponse.class)
//                .retry(retry)
//                .map(response -> getMapper().map(response, OrderHistoryDTO.class))
//                .doOnError(error -> log.error("Error Adapter CommerceServiceImpl.orderHistoryByCustomerId ({},{}) - {}", userId, cid, error.getMessage()));
//    }
//
//}
