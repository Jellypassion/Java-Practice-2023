package org.example;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DateTimeDemo {
    public static void main(String[] args) {
        ZonedDateTime now = ZonedDateTime.now();
        System.out.println(now);

        var epochMilli = now.toInstant().toEpochMilli();
        System.out.println(epochMilli);

        var plus = now.plus(1L, ChronoUnit.DAYS);
        System.out.println(plus);

        var truncated = now.truncatedTo(ChronoUnit.DAYS);// Обнуляет дату до дней (время станет 00:00:00)
        System.out.println(truncated);

        var formatted = now.format(DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println(formatted);

        var now1 = LocalDateTime.now(ZoneOffset.UTC);
        System.out.println(now1);

    }
}
