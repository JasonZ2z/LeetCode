package com.xinzhe.contest.weekly.season04.weekly177;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author Xin
 * @create 2020/5/18
 * Title : 1360. 日期之间隔几天
 * Description : 请你编写一个程序来计算两个日期之间隔了多少天。日期以字符串形式给出，格式为 YYYY-MM-DD，如示例所示。
 * link : https://leetcode-cn.com/problems/number-of-days-between-two-dates/
 * Level : Easy
 * Comment 177周赛01
 */

public class Leetcode_weekly_17701 {
    public int daysBetweenDates(String date1, String date2) {
        SimpleDateFormat pattern = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date d1 = pattern.parse(date1);
            Date d2 = pattern.parse(date2);
            return (int) (Math.abs(d1.getTime() - d2.getTime()) / (24 * 60 * 60 * 1000));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
