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
public class RequestCommand<T> implements Serializable {
    private static final long serialVersionUID = -4135498964297663560L;
    private String id;
    private String commandId;
    private String name;
    private String status;
    private String scope;
    public Traceability traceability;
    private T payload;
    private String user;
}
