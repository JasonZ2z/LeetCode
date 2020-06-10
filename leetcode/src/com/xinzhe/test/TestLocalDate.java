package com.xinzhe.test;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class TestLocalDate {

    public static void main(String[] args) {
        TestLocalDate test = new TestLocalDate();
        System.out.println(test.getMonthsBetween("201911", "2020-06-09 00:00:00.0"));
        //System.out.println(test.getMonthsBetween("202001", "202001"));
        //System.out.println(test.endorsementDateValidation("20200101", "20200331"));
    }

    public int getMonthsBetween(Date firstDate, String secondYearMonth) {

        return (int) ChronoUnit.MONTHS.between(date2LocalDate(firstDate), string2LocalDate(secondYearMonth));
    }


    public int getMonthsBetween(String firstYearMonth, String secondYearMonth) {

        return (int) ChronoUnit.MONTHS.between(string2LocalDate(firstYearMonth), string2LocalDate(secondYearMonth));
    }

    public boolean daysBetween(String effectiveDate, String endorsementDate) {
        LocalDate effectiveLocalDate = string2LocalDateWithDay(effectiveDate);
        System.out.println(effectiveLocalDate);
        LocalDate endorsementLocalDate = string2LocalDateWithDay(endorsementDate);
        System.out.println(endorsementLocalDate);
        if(endorsementLocalDate.isBefore(effectiveLocalDate)) {
            return ChronoUnit.DAYS.between(endorsementLocalDate, effectiveLocalDate) <= 30L;
        } else {
            return ChronoUnit.DAYS.between(effectiveLocalDate, endorsementLocalDate) <= 60L;
        }
    }

    private YearMonth date2LocalDate(Date date) {
        if(null == date) {
            return null;
        }
        return YearMonth.from(date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
    }

    private YearMonth string2LocalDate(String date) {
        DateTimeFormatter fmt;
        if(date.length() > 6 ) {
            date = date.substring(0, 7);
            fmt = DateTimeFormatter.ofPattern("yyyy-MM");
        } else {
            fmt = DateTimeFormatter.ofPattern("yyyyMM");
        }
        return YearMonth.parse(date, fmt);
    }

    private LocalDate string2LocalDateWithDay(String date) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyyMMdd");
        return LocalDate.parse(date, fmt);
    }




}
