package com.robinfood.demo.model.command;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@ToString
public class Traceability implements Serializable {
    private static final long serialVersionUID = -4135498969297663530L;
    private String appId;
    private String appName;
    private String transactionId;
    private String sessionId;
    private String source;
    private Long requestTime;
}
