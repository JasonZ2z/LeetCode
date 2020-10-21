package com.xinzhe.contest.weekly.season03.weekly119;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Xin
 * @date 2020/10/21
 * Title : 974. 和可被 K 整除的子数组
 * Description : 给定一个整数数组 A，返回其中元素之和可被 K 整除的（连续、非空）子数组的数目。
 * link : https://leetcode-cn.com/problems/subarray-sums-divisible-by-k/
 * Level : Medium
 */
//todo need to review
public class Leetcode_weekly_11903 {
    public static void main(String[] args) {
        Leetcode_weekly_11903 lc = new Leetcode_weekly_11903();
        System.out.println(((-5 % 3) + 3) % 3);
    }
    public int subarraysDivByK(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0, ans =0;
        map.put(0, 1);
        for (int i : arr) {
            sum += i;
            //int mod = ((sum % k) + k ) % k;  //难点： 负数计算模 ((sum % K) + K) % K
            int mod = Math.floorMod(sum, k);
            if(map.containsKey(mod)) {
                ans += map.get(mod);
            }
            map.put(mod, map.getOrDefault(mod, 0) + 1);
        }
        return ans;
    }
}
