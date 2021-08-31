//package com.robinfood.demo.domain.configuration.gateway;
//
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.junit.MockitoJUnitRunner;
//import reactor.core.publisher.Mono;
//import reactor.test.StepVerifier;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//@RunWith(MockitoJUnitRunner.class)
//public class ConfigurationRepositoryTest {
//
//    Configuration config = Configuration
//            .builder()
//            .target("AWS")
//            .accesskey("ASDFFG")
//            .serviceendpoint("ASDFFG")
//            .signingregion("ASDFFG")
//            .queueurl("ASDFFG")
//            .serviceurl("ASDFFG")
//            .build();
//
//    @InjectMocks
//    ConfigurationRepository configurationRepository = target -> Mono.just(config);
//
//
//    @Test
//    public void createConfig() {
//        Assert.assertEquals(config, Configuration
//                .builder()
//                .target("AWS")
//                .accesskey("ASDFFG")
//                .serviceendpoint("ASDFFG")
//                .signingregion("ASDFFG")
//                .queueurl("ASDFFG")
//                .serviceurl("ASDFFG")
//                .build());
//    }
//
//    @Test
//    public void findByTarget() {
//        final Mono<Configuration> configurationMono = configurationRepository.findByTarget("target");
//        StepVerifier.create(configurationMono).assertNext(res ->
//                assertThat(config).extracting(Configuration::getAccesskey)
//                        .isEqualTo("ASDFFG"))
//                .verifyComplete();
//    }
//}