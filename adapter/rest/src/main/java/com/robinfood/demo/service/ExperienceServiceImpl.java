//package com.robinfood.demo.service;
//import lombok.extern.slf4j.Slf4j;
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.MediaType;
//import org.springframework.stereotype.Service;
//import org.springframework.web.reactive.function.BodyInserters;
//import org.springframework.web.reactive.function.client.WebClient;
//import reactor.core.publisher.Flux;
//import reactor.core.publisher.Mono;
//
//import java.time.Clock;
//import java.util.Objects;
//import java.util.UUID;
//
//
//@Slf4j
//@Service
//class ExperienceServiceImpl extends AbstractRestImpl<PointsValueDTO, PointsValueResponse> implements ExperienceService {
//
//    @Value("${client.experience.host}")
//    String baseHost;
//    @Value("${client.experience.handler.point}")
//    String baseUriPointValue;
//    @Value("${client.experience.handler.experiences-nit}")
//    String baseUriExperiencesNit;
//    @Value("${client.retry}")
//    private Integer retry;
//    WebClient clientMsExperience;
//    @Value("${client.experience.command.experience-deactivate}")
//    private String commandExperienceDeactivate;
//    @Value("${client.experience.command.audit-log-save}")
//    private String commandAuditLogSave;
//    @Value("${client.experience.uri}")
//    private String baseUri;
//
//    private static final Integer INDEX_ZERO = 0;
//
//    public ExperienceServiceImpl(ModelMapper mapper) {
//        super(mapper, PointsValueDTO.class, PointsValueResponse.class);
//        clientMsExperience = WebClient.create(baseHost);
//    }
//
//    public Flux<PointsValueDTO> pointsAdmon(String cid) {
//        clientMsExperience = WebClient
//                .builder()
//                .baseUrl(baseHost)
//                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
//                .defaultHeader(HttpHeaders.AUTHORIZATION, cid)
//                .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
//                .build();
//        log.info("SE REALIZA SOLICITUD DE GET POINTS :: {}", baseHost + baseUriPointValue);
//        return clientMsExperience
//                .get()
//                .uri(baseUriPointValue)
//                .accept(MediaType.APPLICATION_JSON)
//                .retrieve()
//                .bodyToFlux(PointsValueResponse.class)
//                .retry(retry)
//                .map(this::mapToDto)
//                .doOnError(error -> log.error("Error Adapter ExperienceServiceImpl.pointsAdmon ({},{}) - {}", cid, error.getMessage()))
//                .onErrorResume(error -> Mono.error(new RuntimeException(error.getMessage())));
//    }
//
//    public Mono<ExperienceDeactivateDTO> inactivateExperiences(final ExperienceDeactivateDTO payloadDTO) {
//        log.info("ExperienceService::inactivateExperiences({})", payloadDTO);
//        Traceability trazability = Traceability.builder()
//                .transactionId(UUID.randomUUID().toString())
//                .requestTime(Clock.systemDefaultZone().millis())
//                .build();
//
//        RequestCommand event = RequestCommand.builder()
//                .id(UUID.randomUUID().toString())
//                .name(commandExperienceDeactivate)
//                .traceability(trazability)
//                .payload(payloadDTO)
//                .build();
//
//        clientMsExperience = WebClient.builder()
//                .baseUrl(baseHost)
//                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
//                .defaultHeader(HttpHeaders.AUTHORIZATION, payloadDTO.getCid())
//                .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
//                .build();
//
//        return clientMsExperience.post()
//                .uri(baseUri)
//                .accept(MediaType.APPLICATION_JSON)
//                .body(BodyInserters.fromPublisher(Mono.just(event), RequestCommand.class))
//                .retrieve()
//                .bodyToMono(ResponseCommand[].class)
//                .retry(retry)
//                .map(values -> {
//                    if (Objects.isNull(values[INDEX_ZERO].getPayload().getBody())) {
//                        Header header = values[INDEX_ZERO].getPayload().getHeader();
//                        log.error(header.getMessage());
//                        throw new CustomerException(CustomerErrorEnum.ERROR_INACTIVATING_EXPERIENCES);
//                    }
//                    return values[INDEX_ZERO].getPayload().getBody();
//                })
//                .map(response -> getMapper().map(response, ExperienceDeactivateDTO.class))
//                .doOnError(error -> log.error("=***= error {} ", error.getMessage()));
//    }
//
//    @Override
//    public Mono<Long> countExperiencesByIdentificationVendor(String nit, String cid) {
//        clientMsExperience = WebClient
//                .builder()
//                .baseUrl(baseHost)
//                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
//                .defaultHeader(HttpHeaders.AUTHORIZATION, cid)
//                .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
//                .build();
//        log.info("SE REALIZA SOLICITUD DE countExperiencesByIdentificationVendor :: {}", baseHost + baseUriExperiencesNit);
//        return clientMsExperience
//                .get()
//                .uri(uriBuilder -> uriBuilder
//                        .path(baseUriExperiencesNit)
//                        .queryParam("nit", nit)
//                        .build()
//                )
//                .accept(MediaType.APPLICATION_JSON)
//                .retrieve()
//                .bodyToMono(Long.class)
//                .retry(retry)
//                .doOnError(error -> log.error(" Error Experience countExperiencesByIdentificationVendor : {} ", error.getMessage()))
//                .onErrorResume(error -> Mono.error(new RuntimeException(error.getMessage())));
//    }
//
//    @Override
//    public Mono<AuditLogDTO> saveAuditLog(final AuditLogDTO payloadDTO) {
//        log.info("ExperienceService::inactivateExperiences({})", payloadDTO);
//        Traceability trazability = Traceability.builder()
//                .transactionId(UUID.randomUUID().toString())
//                .requestTime(Clock.systemDefaultZone().millis())
//                .build();
//
//        RequestCommand event = RequestCommand.builder()
//                .id(UUID.randomUUID().toString())
//                .name(commandAuditLogSave)
//                .traceability(trazability)
//                .payload(payloadDTO)
//                .build();
//
//        clientMsExperience = WebClient.builder()
//                .baseUrl(baseHost)
//                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
//                .defaultHeader(HttpHeaders.AUTHORIZATION, payloadDTO.getCid())
//                .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
//                .build();
//
//        return clientMsExperience.post()
//                .uri(baseUri)
//                .accept(MediaType.APPLICATION_JSON)
//                .body(BodyInserters.fromPublisher(Mono.just(event), RequestCommand.class))
//                .retrieve()
//                .bodyToMono(ResponseCommand[].class)
//                .retry(retry)
//                .map(values -> {
//                    if (Objects.isNull(values[INDEX_ZERO].getPayload().getBody())) {
//                        Header header = values[INDEX_ZERO].getPayload().getHeader();
//                        log.error(header.getMessage());
//                        throw new CustomerException(CustomerErrorEnum.ERROR_SAVING_AUDIT_LOG);
//                    }
//                    return values[INDEX_ZERO].getPayload().getBody();
//                })
//                .map(response -> getMapper().map(response, AuditLogDTO.class))
//                .doOnError(error -> log.error("=***= error {} ", error.getMessage()));
//    }
//}
