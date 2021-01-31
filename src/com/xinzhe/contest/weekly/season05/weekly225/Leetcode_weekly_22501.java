package com.xinzhe.contest.weekly.season05.weekly225;

/**
 * @author Xin
 * @date 2021/01/24
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_weekly_22501 {
    public static void main(String[] args) {
        Leetcode_weekly_22501 lc = new Leetcode_weekly_22501();
    }
    public String maximumTime(String time) {
        StringBuilder  sb = new StringBuilder();
        if(time.charAt(0) == '?') {
            if(time.charAt(1) == '?') {
                sb.append("23:");
            } else if(time.charAt(1) <= '3') {
                sb.append(2).append(time.charAt(1)).append(":");
            } else {
                sb.append(1).append(time.charAt(1)).append(":");
            }
        } else if(time.charAt(0) == '2') {
            if(time.charAt(1) == '?') {
                sb.append("23:");
            } else {
                sb.append(2).append(time.charAt(1)).append(":");
            }
        } else {
            if(time.charAt(1) == '?') {
                sb.append(time.charAt(0)).append(9).append(":");
            } else {
                sb.append(time.charAt(0)).append(time.charAt(1)).append(":");
            }
        }

        if(time.charAt(3) == '?') {
            sb.append(5);
            if(time.charAt(4) == '?') {
                sb.append(9);
            } else {
                sb.append(time.charAt(4));
            }
        } else {
            sb.append(time.charAt(3));
            if(time.charAt(4) == '?') {
                sb.append(9);
            } else {
                sb.append(time.charAt(4));
            }
        }
        return sb.toString();


    }
}
