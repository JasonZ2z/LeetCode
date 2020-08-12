package com.xinzhe.contest.weekly.season04.weekly183;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Xin
 * @date 2020/4/5 10:28
 * Title : 1403. 非递增顺序的最小子序列
 * Description : 给你一个数组 nums，请你从中抽取一个子序列，满足该子序列的元素之和 严格 大于未包含在该子序列中的各元素之和。
 *              如果存在多个解决方案，只需返回 长度最小 的子序列。如果仍然有多个解决方案，则返回 元素之和最大 的子序列。
 *              与子数组不同的地方在于，「数组的子序列」不强调元素在原数组中的连续性，也就是说，它可以通过从数组中分离一些（也可能不分离）元素得到。
 * link : https://leetcode-cn.com/problems/minimum-subsequence-in-non-increasing-order/
 * Level : Easy
 * Comment : 183周赛01
 */
public class Leetcode_weekly_18304 {
    public static void main(String[] args) {
        int[] a = {4,4,7,6,7};
        System.out.println(minSubsequence(a));
    }
    public static List<Integer> minSubsequence(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int n = nums.length;
        if(n == 0) return list;
        if(n == 1) {
            list.add(nums[0]);
            return list;
        }
        Arrays.sort(nums);
        int sum = Arrays.stream(nums).sum();
        int target = sum /2 +1;
        int res = 0;
        for(int i = n-1; i >= 0; --i) {
            if(res >= target){
                break;
          } else {
                res += nums[i];
                list.add(nums[i]);
          }
        }
        return list;
    }
}
