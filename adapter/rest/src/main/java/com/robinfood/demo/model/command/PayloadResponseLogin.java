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
public class PayloadResponseLogin implements Serializable {
    private static final long serialVersionUID = -4135498964297663560L;
    public String token;
    public String status;
    public String firstLogin;
    public String engineUserId;

}
