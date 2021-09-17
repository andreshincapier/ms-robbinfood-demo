package com.survey.demo.util;


import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Date;

public class DateFunctions {

    private DateFunctions() {
    }

    public static Long getActualTimeLong() {
        var zdt = ZonedDateTime.now(ZoneId.of("America/Bogota"));
        long offsetMillis = ZoneOffset.from(zdt).getTotalSeconds() * 1000L;
        long isoMillis = zdt.toInstant().toEpochMilli();
        var date = new Date(isoMillis + offsetMillis);
        return date.getTime();
    }
}
