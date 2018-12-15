package cz.jjaros.study.oca;

import cz.jjaros.study.helper.Console;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class Ex09_DateTime {

    public static void main(String[] args) {
        conversion();
        Console.lineDelimiter();

        someMethods();
        Console.lineDelimiter();

        format();
        Console.lineDelimiter();

        parse();
        Console.lineDelimiter();

        zonedDateTime();
        Console.lineDelimiter();

        chronoUnits();
        Console.lineDelimiter();

        durationAndPeriod();
    }

    private static void conversion() {
        java.sql.Date sqlDate = new java.sql.Date(new Date().getTime());
        System.out.println("sqlDate.toLocalDate() = " + sqlDate.toLocalDate());

        java.sql.Time sqlTime = new java.sql.Time(new Date().getTime());
        System.out.println("sqlTime.toLocalTime() = " + sqlTime.toLocalTime());

        java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(new Date().getTime());
        System.out.println("sqlTimestamp.toLocalDateTime() = " + sqlTimestamp.toLocalDateTime());

        Instant utilDateInstant = new java.util.Date().toInstant();
        LocalDateTime localDateTimeFromInstant = LocalDateTime.ofInstant(utilDateInstant, ZoneId.systemDefault());
        System.out.println("localDateTimeFromInstant = " + localDateTimeFromInstant);
    }

    private static void someMethods() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println("now = " + now); // now, e.g. '2018-11-15T17:49:32.229'
        System.out.println("now.getYear() = " + now.getYear()); // current year, e.g. 2018
        System.out.println("now.plusMonths(1) = " + now.plusMonths(1)); // now plus month, e.g. '2018-12-15T17:49:32.229'
        System.out.println("now.minusMonths(1) = " + now.minusMonths(1)); // now minus month, e.g. '2018-10-15T17:49:32.229'
        System.out.println("now.withMonth(1) = " + now.withMonth(1)); // now with month updated to '1', e.g. '2018-01-15T17:49:32.229'
    }

    private static void format() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println("now = " + now); // see above

        String isoDateFormatted = now.format(DateTimeFormatter.ISO_DATE);
        System.out.println("isoDateFormatted = " + isoDateFormatted); // now formatted to ISO_DATE format

        String ofPatternFormatted = now.format(DateTimeFormatter.ofPattern("yyyy/MM/dd")); // now formatted to custom pattern
        System.out.println("ofPatternFormatted = " + ofPatternFormatted);
    }

    private static void parse() {
        LocalDate parsed = LocalDate.parse("2018-02-01");
        System.out.println("parsed = " + parsed); // 2018-02-01

        // java.time.format.DateTimeParseException
//        LocalDate parsedError = LocalDate.parse("2018/02/01");
//        System.out.println("parsedError = " + parsedError);

        LocalDate parsedOfPatternFormatted = LocalDate.parse("2018/02/01", DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        System.out.println("parsedOfPatternFormatted = " + parsedOfPatternFormatted); // 2018/02/01

        LocalDate parsedIsoDateFormatted = LocalDate.parse("2018-02-01", DateTimeFormatter.ISO_DATE);
        System.out.println("parsedIsoDateFormatted = " + parsedIsoDateFormatted); // 2018-02-01

        // java.time.format.DateTimeParseException
//        LocalDate parsedIsoDateFormattedError = LocalDate.parse("2018/02/01", DateTimeFormatter.ISO_DATE);
//        System.out.println("parsedIsoDateFormattedError = " + parsedIsoDateFormattedError);
    }

    private static void zonedDateTime() {
        System.out.println("LocalDateTime.now() = " + LocalDateTime.now()); // e.g. '2018-11-15T17:57:23.984'
        System.out.println("ZonedDateTime.now() = " + ZonedDateTime.now()); // e.g. '2018-11-15T17:57:23.984+01:00[Europe/Prague]'
    }

    private static void chronoUnits() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime lastYear = LocalDateTime.now().minusYears(1);
        System.out.println("ChronoUnit.YEARS.between(now, lastYear) = " + ChronoUnit.YEARS.between(now, lastYear)); // -1
        System.out.println("ChronoUnit.YEARS.between(lastYear, now) = " + ChronoUnit.YEARS.between(lastYear, now)); // 1
        System.out.println("ChronoUnit.MONTHS.between(lastYear, now) = " + ChronoUnit.MONTHS.between(lastYear, now)); // 12
        System.out.println("ChronoUnit.YEARS.getDuration() = " + ChronoUnit.SECONDS.getDuration()); // PT1S
        System.out.println("ChronoUnit.MONTHS.getDuration() = " + ChronoUnit.MINUTES.getDuration()); // PT1M
        System.out.println("ChronoUnit.MINUTES.getDuration().get(ChronoUnit.SECONDS) = "
                + ChronoUnit.MINUTES.getDuration().get(ChronoUnit.SECONDS)); // 60
    }

    private static void durationAndPeriod() {
//        Duration durationOfSeconds = Duration.ofSeconds(30); // PT30S
        Duration durationOfSeconds = Duration.ofSeconds(60); // PT1M
        Duration durationOfMinutes = Duration.ofMinutes(1); // PT1M
        System.out.println("durationOfSeconds = " + durationOfSeconds);
        System.out.println("durationOfMinutes = " + durationOfMinutes);

        System.out.println("durationOfMinutes.equals(durationOfSeconds) = " + durationOfMinutes.equals(durationOfSeconds)); // true
        System.out.println("durationOfSeconds.getSeconds() = " + durationOfSeconds.getSeconds()); // 60
        System.out.println("durationOfSeconds.getNano() = " + durationOfSeconds.getNano()); // 0
        System.out.println("durationOfMinutes.getSeconds() = " + durationOfMinutes.getSeconds()); // 60
        System.out.println("durationOfMinutes.getNano() = " + durationOfMinutes.getNano()); // 0

        // Duration je Time-based
        // nanoseconds .. days
        System.out.println("Duration.between(LocalDateTime.now().minusYears(1), LocalDateTime.now()) = "
                + Duration.between(LocalDateTime.now().minusYears(1), LocalDateTime.now())); // PT8760H (=default HOURS)
        // Period je Date-based
        // years .. days
        System.out.println("Period.between(LocalDate.now().minusYears(1), LocalDate.now()) = "
                + Period.between(LocalDate.now().minusYears(1), LocalDate.now())); // P1Y (=default YEARS)

        Period periodOfWeeks = Period.ofWeeks(52);
        Period periodOfYears = Period.ofYears(1);
        System.out.println("periodOfWeeks = " + periodOfWeeks); // P364D
        System.out.println("periodOfYears = " + periodOfYears); // P1Y

        System.out.println("periodOfWeeks.equals(periodOfYears) = " + periodOfWeeks.equals(periodOfYears)); // false
        System.out.println("periodOfWeeks.getYears() = " + periodOfWeeks.getYears()); // 0
        System.out.println("periodOfYears.getMonths() = " + periodOfWeeks.getMonths()); // 0
        System.out.println("periodOfWeeks.getDays() = " + periodOfWeeks.getDays()); // 364
        System.out.println("periodOfYears.getYears() = " + periodOfYears.getYears()); // 1
        System.out.println("periodOfYears.getMonths() = " + periodOfYears.getMonths()); // 0
        System.out.println("periodOfYears.getDays() = " + periodOfYears.getDays()); // 0
    }
}
