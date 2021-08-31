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
public class ResponseCommand implements Serializable {
    private static final long serialVersionUID = -4135498964297663560L;
    public String id;
    public String commandId;
    public String name;
    public String status;
    public String scope;
    public PayloadResponse payload;
    public Traceability traceability;
    public String user;
}
