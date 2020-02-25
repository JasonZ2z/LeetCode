package com.xinzhe.categories.Calendar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class printCalendar {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        System.out.print("pls input the start date:");
        String start = sc.nextLine();
        System.out.print("pls input the end date:");
        String end = sc.nextLine();
        SimpleDateFormat sd = new SimpleDateFormat("yyyy/MM");
        Date d1 = sd.parse(start);
        Date d2 = sd.parse(end);
        Calendar  calendar = Calendar.getInstance();
        calendar.setTime(d1);
        while(calendar.getTime().before(d2)){
            String output = sd.format(calendar.getTime());
            System.out.println(output);
            calendar.add(Calendar.MONTH, 1);
        }
    }
}
