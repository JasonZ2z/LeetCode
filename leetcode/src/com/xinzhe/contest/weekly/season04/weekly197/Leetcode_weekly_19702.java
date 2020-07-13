package com.xinzhe.contest.weekly.season04.weekly197;

/**
 * @Author Xin
 * @create 2020/7/12
 * Title :
 * Description :
 * link :
 * Level : Medium
 */
public class Leetcode_weekly_19702 {
    public static void main(String[] args) {
        Leetcode_weekly_19702 lc = new Leetcode_weekly_19702();
    }

    static final int mod = (int) (1e9 +7);
    public int numSub(String s) {
        int count = 0;
        long sum = 0;
        for (char c : s.toCharArray()) {
            if(c == '1') {
                count++;
            } else {
                if(count > 0) {
                    sum += (long)count * (count + 1) / 2;
                    count = 0;
                }
            }
        }
        sum += (long)count * (count + 1) / 2;
        return (int) (sum % mod);
    }

}
