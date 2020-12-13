package com.xinzhe.contest.weekly.season05.weekly219;

/**
 * @author Xin
 * @date 2020/12/13
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_weekly_21901 {
    public static void main(String[] args) {
        Leetcode_weekly_21901 lc = new Leetcode_weekly_21901();
        int[] arr = {3,5};
        System.out.println(lc.numberOfMatches(7));
    }
    public int numberOfMatches(int n) {
        int cnt = 0;
        while (n > 1) {
            cnt += n/2;
            if(n % 2 == 0) {
                n/=2;
            } else {
                n = (n-1)/2 + 1;
            }
        }
        return cnt;
    }
}
