package com.xinzhe.contest.weekly.season05.weekly243;

/**
 * @author Xin
 * @date 2021/05/30
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_weekly_24302 {
    public static void main(String[] args) {
        Leetcode_weekly_24302 lc = new Leetcode_weekly_24302();
        String s = "28824579515";

        //System.out.println(lc.maxValue(s, 8));
        System.out.println(lc.maxValue("-132", 3));

    }
    public String maxValue(String n, int x) {
        if(n.startsWith("-")){
            int i = 1;
            while (i < n.length() && ((n.charAt(i) - '0') <= x)) {
                i++;
            }
            if(i == n.length() ) {
                return n + x;
            }
            return n.substring(0,i) + x + n.substring(i);

        } else {
            for (int i = 0; i < n.length(); i++) {
                if(x >= (n.charAt(i) - '0')) {
                    return n.substring(0, i) + x + n.substring(i);
                }
            }
            return n +x;
        }
    }
}
