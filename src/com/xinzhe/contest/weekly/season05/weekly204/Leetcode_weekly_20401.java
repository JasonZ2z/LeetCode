package com.xinzhe.contest.weekly.season05.weekly204;

import java.util.Arrays;

/**
 * @author Xin
 * @date 2020/8/30
 * Title : 1566. 重复至少 K 次且长度为 M 的模式
 * Description : 给你一个正整数数组 arr，请你找出一个长度为 m 且在数组中至少重复 k 次的模式。
 *              模式 是由一个或多个值组成的子数组（连续的子序列），连续 重复多次但 不重叠 。 模式由其长度和重复次数定义。
 *              如果数组中存在至少重复 k 次且长度为 m 的模式，则返回 true ，否则返回  false 。
 * link :  https://leetcode-cn.com/problems/detect-pattern-of-length-m-repeated-k-or-more-times
 * Level : Easy
 */
public class Leetcode_weekly_20401 {
    public static void main(String[] args) {
        Leetcode_weekly_20401 lc = new Leetcode_weekly_20401();
        int[] arr = {1,2,3,1,2};
        System.out.println(lc.containsPattern(arr, 2, 2));
    }
    public boolean containsPattern(int[] arr, int m, int k) {
        int n = arr.length;
        for (int i = 0; i < n; ++i) {
            int count = 1;
            int j = i+m;
            while(j+m <= n) {
                if(Arrays.equals(arr, i, i+m, arr, j, j+m)) {
                   count++;
                   if(count >= k) return true;
                   j = j+m;
                }else {
                    break;
                }
            }
        }
        return false;
    }
}
