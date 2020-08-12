package com.xinzhe.contest.weekly.season04.weekly153;

import java.time.LocalDate;

/**
 * @author Xin
 * @date 2020/7/29
 * Title : 1185. 一周中的第几天
 * Description : 给你一个日期，请你设计一个算法来判断它是对应一周中的哪一天。输入为三个整数：day、month 和 year，分别表示日、月、年。
 *              您返回的结果必须是这几个值中的一个 {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"}。
 * link : https://leetcode-cn.com/problems/day-of-the-week
 * Level :
 */

public class Leetcode_weekly_15302 {

    public static void main(String[] args) {
        Leetcode_weekly_15302 lc = new Leetcode_weekly_15302();
        System.out.println(lc.dayOfTheWeek(29, 7, 2020));
    }

    public String dayOfTheWeek(int day, int month, int year) {
        String[] res = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        LocalDate date = LocalDate.of(year, month, day);
        return res[date.getDayOfWeek().getValue()-1];
    }
}
