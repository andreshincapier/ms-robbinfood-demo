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
public class PayloadRequestLogin implements Serializable {
    private static final long serialVersionUID = -4135498969297663530L;
    public String username;
    public String password;
    public String deviceId;
}
