package com.xinzhe.test;

import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class TestLocalDate {

    public static void main(String[] args) {
        LocalDate startDate = LocalDate.of(2017, Month.JUNE, 19);
        System.out.println("开始时间  : " + startDate);

        LocalDate endDate = LocalDate.of(2017, Month.JUNE, 16);
        System.out.println("结束时间 : " + endDate);

        long daysDiff = ChronoUnit.DAYS.between(startDate, endDate);
        System.out.println("两天之间的差在天数   : " + daysDiff);

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
