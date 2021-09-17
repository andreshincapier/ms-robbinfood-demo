package com.survey.demo.enums;

import java.util.Arrays;

public enum StatusEnum {

    ACTIVE("38c1a58d-d435-4bf1-a1ba-0c82d5dc7f16"),
    DISABLE("969e0631-2121-4965-aa4e-9779d5d6fab2");

    private final String id;

    StatusEnum(String id) {
        this.id = id;
    }

    public static String nameFromId(String id) {
        return Arrays.stream(values())
                .filter(dse -> dse.getId().contentEquals(id))
                .map(Enum::name)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("OBJECT_STATUS_NOT_VALID"));
    }

    public static String idFromName(String name) {
        return Arrays.stream(values())
                .filter(dse -> dse.name().contentEquals(name))
                .map(StatusEnum::getId)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("OBJECT_STATUS_NOT_VALID"));
    }

    public String getId() {
        return this.id;
    }
}
