//package com.robinfood.demo.domain.configuration;
//
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.junit.MockitoJUnitRunner;
//import reactor.core.publisher.Mono;
//
//@RunWith(MockitoJUnitRunner.class)
//public class ConfigurationFactoryTest {
//
//    ConfigurationFactory factory = new ConfigurationFactory();
//
////    Configuration config = Configuration
////            .builder()
////            .target("AWS")
////            .accesskey("ASDFFG")
////            .secretkey("ASDFFG")
////            .serviceendpoint("ASDFFG")
////            .signingregion("ASDFFG")
////            .queueurl("ASDFFG")
////            .serviceurl("ASDFFG")
////            .build();
////
////    @Test
////    public void createConfiguration() {
////        Mono<Configuration> newFactory = factory
////                .createConfiguration(
////                        "AWS",
////                        "ASDFFG",
////                        "ASDFFG",
////                        "ASDFFG",
////                        "ASDFFG",
////                        "ASDFFG",
////                        "ASDFFG");
////        Assert.assertEquals(config, Configuration
////                .builder()
////                .target("AWS")
////                .accesskey("ASDFFG")
////                .secretkey("ASDFFG")
////                .serviceendpoint("ASDFFG")
////                .signingregion("ASDFFG")
////                .queueurl("ASDFFG")
////                .serviceurl("ASDFFG")
////                .build());
////    }
//}