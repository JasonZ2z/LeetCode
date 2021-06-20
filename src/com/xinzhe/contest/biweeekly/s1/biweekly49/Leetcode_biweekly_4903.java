package com.xinzhe.contest.biweeekly.s1.biweekly49;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Xin
 * @date 2021/04/03
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_biweekly_4903 {
    public static void main(String[] args) {
        Leetcode_biweekly_4903 lc = new Leetcode_biweekly_4903();
    }
    public int countNicePairs(int[] nums) {
        int n = nums.length;
        Map<Long, Integer> map = new HashMap<>();
        int mod = (int)1e9 + 7;
        for (int num : nums) {
            long x = num - rev(num);
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        long res = 0;
        for (Integer value : map.values()) {
            res += ((long) value * (value -1))/2;
        }
        return (int) (res % mod);

    }

    private long rev(int x) {
        long y = 0;
        while (x > 0) {
            y = y * 10 + x % 10;
            x /= 10;
        }
        return y;
    }
}