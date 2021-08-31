//package com.robinfood.demo;

//import org.junit.runner.RunWith;
//import org.mockito.junit.MockitoJUnitRunner;

//@RunWith(MockitoJUnitRunner.class)
//public class StartUpInitTest {

//    @InjectMocks
//    StartUpInit startUpInit;
//
//    @Mock
//    ObserverUseCase observerUseCase;
//
//    @Test
//    public void initTest() {
//        when(startUpInit.init()).thenReturn(Mono.just("OK"));
//        StepVerifier.create(startUpInit.init())
//                .expectNext("OK")
//                .verifyComplete();
//    }
//}