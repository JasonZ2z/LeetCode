package com.xinzhe.contest.biweeekly.s1.biweekly30;

/**
 * @author Xin
 * @date 2020/7/11
 * Title : 1507. 转变日期格式
 * Description : 给你一个字符串 date ，它的格式为 Day Month Year ，其中：
 *          Day 是集合 {"1st", "2nd", "3rd", "4th", ..., "30th", "31st"} 中的一个元素。
 *          Month 是集合 {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"} 中的一个元素。
 *          Year 的范围在 ​[1900, 2100] 之间。
 *          请你将字符串转变为 YYYY-MM-DD 的格式，其中：YYYY 表示 4 位的年份。MM 表示 2 位的月份。DD 表示 2 位的天数。
 * link : https://leetcode-cn.com/problems/reformat-date
 * Level : Easy
 */
public class Leetcode_biweekly_3001 {
    public static void main(String[] args) {
        Leetcode_biweekly_3001 lc = new Leetcode_biweekly_3001();
    }
    public String reformatDate(String date) {
        String[] s = date.split(" ");
        String year = s[2];
        StringBuilder sb = new StringBuilder();
        for (char c : s[0].toCharArray()) {
            if(Character.isDigit(c)){
                sb.append(c);
            }
        }
        if(sb.length() == 1){
            sb.insert(0, "0");
        }
        if("Jan".equals(s[1])) {
            return year + "-" + "01" + "-" + sb;
        }
        if("Feb".equals(s[1])) {
            return year + "-" + "02" + "-" + sb;
        }
        if("Mar".equals(s[1])) {
            return year + "-" + "03" + "-" + sb;
        }
        if("Apr".equals(s[1])) {
            return year + "-" + "04" + "-" + sb;
        }
        if("May".equals(s[1])) {
            return year + "-" + "05" + "-" + sb;
        }
        if("Jun".equals(s[1])) {
            return year + "-" + "06" + "-" + sb;
        }
        if("Jul".equals(s[1])) {
            return year + "-" + "07" + "-" + sb;
        }
        if("Aug".equals(s[1])) {
            return year + "-" + "08" + "-" + sb;
        }
        if("Sep".equals(s[1])) {
            return year + "-" + "09" + "-" + sb;
        }
        if("Oct".equals(s[1])) {
            return year + "-" + "10" + "-" + sb;
        }
        if("Nov".equals(s[1])) {
            return year + "-" + "11" + "-" + sb;
        }
        else {
            return year + "-" + "12" + "-" + sb;
        }
    }

}
