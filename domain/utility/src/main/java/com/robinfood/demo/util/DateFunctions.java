package com.robinfood.demo.util;


import java.text.DateFormat;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateFunctions {

    private DateFunctions(){
    }

    public static long getFirstDayMonth(long time) {
        long firstDayOfMonthTimestamp;
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.setTimeInMillis(time);
        while (calendar.get(Calendar.DATE) > 1) {
            calendar.add(Calendar.DATE, -1);
        }
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        firstDayOfMonthTimestamp = calendar.getTimeInMillis();
        return firstDayOfMonthTimestamp;
    }

    public static long getFirstDayOfYear() {
        Calendar calendar = Calendar.getInstance();
        int mes = calendar.get(Calendar.MONTH);
        long oneMonth = 2629750000L;
        long result = getActualTimeLong() - (oneMonth * mes);
        return getFirstDayMonth(result);
    }

    public static Long getActualTimeLong() {
        ZonedDateTime zdt = ZonedDateTime.now(ZoneId.of("America/Bogota"));
        long offsetMillis = ZoneOffset.from(zdt).getTotalSeconds() * 1000L;
        long isoMillis = zdt.toInstant().toEpochMilli();
        Date date = new Date(isoMillis + offsetMillis);
        return date.getTime();
    }

    public static Long threeMonthsBefore() {
        Calendar c = Calendar.getInstance();
        DateFormat df = DateFormat.getDateInstance(DateFormat.LONG, Locale.getDefault());
        df.format(c.getTime());
        c.add(Calendar.MONTH, -3);
        return c.getTimeInMillis();
    }

    public static long getPreviousMoth() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);
        return cal.getTimeInMillis();
    }
}
