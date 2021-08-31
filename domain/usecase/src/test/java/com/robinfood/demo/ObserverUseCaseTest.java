//package co.com.proteccion.bizagi.microservice.usecase;
//
//import co.com.proteccion.bizagi.microservice.domain.configuration.Configuration;
//import co.com.proteccion.bizagi.microservice.domain.configuration.gateway.ConfigurationRepository;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.MockitoJUnitRunner;
//import reactor.test.StepVerifier;
//
//import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
//
//@RunWith(MockitoJUnitRunner.class)
//public class ObserverUseCaseTest {
//
//    private static final String TARGET = "SAP";
//    private static final String XML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><user><name>Tove</name></user>";
//
//    @InjectMocks
//    ObserverUseCase observerUseCase;
//
//    @Mock
//    ConfigurationRepository repository;
//
//    Configuration configuration = Configuration
//            .builder()
//            .target("IBM")
//            .host("127.0.0.1")
//            .port(1212)
//            .queueMng("TEST")
//            .channel("CHANEL_TEST")
//            .username("JOHN")
//            .password("DOE")
//            .queue("PRU")
//            .sendertype("IBM_T")
//            .build();
//
//    @Test
//    public void fixedRateServiceTask() {
//        StepVerifier.create(observerUseCase.fixedRateServiceTask())
//                .assertNext(res -> {
//                    assertThat(res).isEqualTo("OK");
//                }).verifyComplete();
//    }
//
//    @Test
//    public void convertXMLToJsonTest() {
//        StepVerifier.create(observerUseCase.convertXMLToJson(XML))
//                .assertNext(res -> {
//                    System.out.println(res);
//                    assertThat(res).isEqualTo("{\"user\":{\"name\":\"Tove\"}}");
//                }).verifyComplete();
//    }
//}