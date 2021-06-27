package com.xinzhe.contest.weekly.season05.weekly246;

/**
 * @author Xin
 * @date 2021/06/20
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_weekly_24602 {
    public static void main(String[] args) {
        Leetcode_weekly_24602 lc = new Leetcode_weekly_24602();
        String s = "12:01";
        String e = "12:44";
        System.out.println(lc.numberOfRounds(s,e));

    }
    public int numberOfRounds(String startTime, String finishTime) {
        int sh = Integer.parseInt(startTime.substring(0,2));
        int sm = Integer.parseInt(startTime.substring(3,5));
        int eh = Integer.parseInt(finishTime.substring(0,2));
        int em = Integer.parseInt(finishTime.substring(3,5));

        int res = 0;
        if(sh == eh) {
            if(em > sm) {
                return checkSame(sm, em);
            } else {
                return 23 * 4 + (60 - sm) / 15  +  em / 15;
            }
        }
        if(eh > sh) {
            return (eh - sh - 1) * 4 + (60 - sm) / 15  +  em / 15;
        }

        return eh * 4 + em / 15 + (24 - sh - 1) * 4 + (60 - sm) / 15;

    }

    public int checkSame(int s, int e) {
        if(e - s < 15) return 0;
        if(s == 0) {
            return e / 15;
        }
        if(s > 0 && s <= 15) {
            return (e - 15) / 15;
        }
        if(s > 15 && s <= 30) {
            return (e - 30) / 15;
        }
        if(s > 30 && s <= 45) {
            return (e - 45) / 15;
        }
        return 0;
    }
}
