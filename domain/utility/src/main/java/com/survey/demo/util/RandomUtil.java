package com.survey.demo.util;

import java.util.UUID;

public final class RandomUtil {

    private static final String GUION = "-";
    private static final String WITHOUT_SPACE = "";

    private RandomUtil() {
    }

    public static String unique() {
        return UUID.randomUUID().toString().replace(GUION, WITHOUT_SPACE);
    }
}
