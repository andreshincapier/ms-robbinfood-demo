package com.robinfood.demo.gateway;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder(toBuilder = true)
public class Configuration {

    private final String id;
    private final String name;
    private final String phone;

}
