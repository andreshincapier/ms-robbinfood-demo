package com.robinfood.demo.gateway;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder(toBuilder = true)
public class MessageType {
    private String message;
    private String path;
}
