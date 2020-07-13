package com.xinzhe.test;

import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class TestLocalDate {

    public static void main(String[] args) {
        TestLocalDate test = new TestLocalDate();
        System.out.println(test.getMonthsBetween("201906", new Date()));
        System.out.println(test.getMonthsBetween("201905", "201910"));
        //System.out.println(test.endorsementDateValidation("20200101", "20200331"));
    }

    public int getMonthsBetween(String firstYearMonth, Date secondYearMonth) {
        return (int)ChronoUnit.MONTHS.between(convertStringToLocalDate(firstYearMonth), convertDateToLocalDate(secondYearMonth));
    }

    public int getMonthsBetween(String firstYearMonth, String secondYearMonth) {
        return (int)ChronoUnit.MONTHS.between(convertStringToLocalDate(firstYearMonth), convertStringToLocalDate(secondYearMonth));
    }

    private YearMonth convertDateToLocalDate(Date date) {
        return YearMonth.from(date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
    }

    /**
     * Convert date from String to YearMonth.
     * @param date
     * @return
     */
    private YearMonth convertStringToLocalDate(String date) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyyMM");
        return YearMonth.parse(date, fmt);
    }



}
