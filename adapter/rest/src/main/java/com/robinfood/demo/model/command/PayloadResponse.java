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
public class PayloadResponse<T> implements Serializable {
    private static final long serialVersionUID = -4135498964297663560L;

    public Header header;
    public T body;
}
