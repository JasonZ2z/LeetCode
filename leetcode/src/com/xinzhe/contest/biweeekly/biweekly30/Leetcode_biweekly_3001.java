package com.xinzhe.contest.biweeekly.biweekly30;

/**
 * @Author Xin
 * @create 2020/7/11
 * Title :
 * Description :
 * link :
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
            return year + "-" + "01" + "-" + sb.toString();
        }
        if("Feb".equals(s[1])) {
            return year + "-" + "02" + "-" + sb.toString();
        }
        if("Mar".equals(s[1])) {
            return year + "-" + "03" + "-" + sb.toString();
        }
        if("Apr".equals(s[1])) {
            return year + "-" + "04" + "-" + sb.toString();
        }
        if("May".equals(s[1])) {
            return year + "-" + "05" + "-" + sb.toString();
        }
        if("Jun".equals(s[1])) {
            return year + "-" + "06" + "-" + sb.toString();
        }
        if("Jul".equals(s[1])) {
            return year + "-" + "07" + "-" + sb.toString();
        }
        if("Aug".equals(s[1])) {
            return year + "-" + "08" + "-" + sb.toString();
        }
        if("Sep".equals(s[1])) {
            return year + "-" + "09" + "-" + sb.toString();
        }
        if("Oct".equals(s[1])) {
            return year + "-" + "10" + "-" + sb.toString();
        }
        if("Nov".equals(s[1])) {
            return year + "-" + "11" + "-" + sb.toString();
        }
        else {
            return year + "-" + "12" + "-" + sb.toString();
        }
    }

}
