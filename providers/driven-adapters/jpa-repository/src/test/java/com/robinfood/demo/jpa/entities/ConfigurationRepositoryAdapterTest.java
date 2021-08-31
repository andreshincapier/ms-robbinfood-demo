//package com.robinfood.demo.jpa.entities;
//
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.MockitoJUnitRunner;
//import org.reactivecommons.utils.ObjectMapper;
//import reactor.core.publisher.Mono;
//import reactor.test.StepVerifier;
//
//@RunWith(MockitoJUnitRunner.class)
//public class ConfigurationRepositoryAdapterTest {
//
////    @Mock
////    ConfigurationDataRepository repository;
////    @InjectMocks
////    ConfigurationRepositoryAdapter adapter;
////    Configuration config = Configuration
////            .builder()
////            .target("AWS")
////            .accesskey("ASDFFG")
////            .serviceendpoint("ASDFFG")
////            .signingregion("ASDFFG")
////            .queueurl("ASDFFG")
////            .serviceurl("ASDFFG")
////            .build();
////    @Mock
////    private ObjectMapper mapper;
////
////    @Test
////    public void createConfigurationData() {
////        ConfigurationData configurationData = new ConfigurationData();
////        configurationData.setTarget("ASDFFG");
////        configurationData.setAccesskey("ASDFFG");
////        configurationData.setServiceendpoint("ASDFFG");
////        configurationData.setSigningregion("ASDFFG");
////        configurationData.setQueueurl("ASDFFG");
////        configurationData.setServiceurl("ASDFFG");
////
////        Assert.assertEquals(configurationData.toString(), configurationData.toString());
////
////    }
////
////    @Test
////    public void findByTarget() {
////        Mono<Configuration> configMono = Mono.just(config);
////        StepVerifier.create(adapter.findByTarget("target")).expectNextMatches(configuration -> {
////            configMono.then();
////            Assert.assertEquals(configMono.block().getAccesskey(), "ASDFFG");
////            return true;
////        });
////    }
//}