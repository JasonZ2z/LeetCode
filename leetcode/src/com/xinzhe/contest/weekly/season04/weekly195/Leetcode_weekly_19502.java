package com.xinzhe.contest.weekly.season04.weekly195;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Xin
 * @create 2020/6/28
 * Title : 1497. 检查数组对是否可以被 k 整除
 * Description : 给你一个整数数组 arr 和一个整数 k ，其中数组长度是偶数，值为 n 。
 *              现在需要把数组恰好分成 n / 2 对，以使每对数字的和都能够被 k 整除。如果存在这样的分法，请返回 True ；否则，返回 False 。
 * link : https://leetcode-cn.com/problems/check-if-array-pairs-are-divisible-by-k
 * Level : Medium
 * Comment 195周赛02
 */
public class Leetcode_weekly_19502 {
    public static void main(String[] args) {
        //int[] arr = {75,5,-5,75,-2,-3,88,10,10,87};
        //int[] arr = {1,2,3,4,5,10,6,7,8,9};
        int[] arr = {-1,1,-2,2,-3,3,-4,4};
        System.out.println(canArrange(arr, 3));
    }
    public static boolean canArrange(int[] arr, int k) {
        long sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int value : arr) {
            sum += value;
            int tmp = value % k;

            map.put(tmp, map.getOrDefault(tmp, 0) + 1);
        }
        if(sum % k != 0) return false;
        for (int i = 1; i < (k+1)/2; ++i) {
            int a = 0, b = 0, c = 0, d = 0;
            if(map.containsKey(i)) {
                a = map.get(i);
            }
            if(map.containsKey(k-i)) {
                b = map.get(k-i);
            }
            if(map.containsKey(-1 * i)) {
                c = map.get(-1 * i);
            }
            if(map.containsKey(-1 * (k-i))) {
                d = map.get(-1 * (k-i));
            }
            int tmp = a +b +c +d;
            if((tmp & 1) == 1) return false;
            if(a -b != c-d) return false;
        }

        return true;
    }
}
