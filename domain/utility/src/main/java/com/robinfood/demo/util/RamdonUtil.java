package com.robinfood.demo.util;

import java.util.UUID;

public final class RamdonUtil {

    private static final String GUION= "-";
    private static final String SIN_ESPACIO = "";

    private RamdonUtil() {
    }

    public static String unique() {
        return UUID.randomUUID().toString().replace(GUION, SIN_ESPACIO);
    }
}
