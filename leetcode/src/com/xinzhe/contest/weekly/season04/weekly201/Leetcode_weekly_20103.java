package com.xinzhe.contest.weekly.season04.weekly201;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Xin
 * @create 2020/8/2
 * Title : 1534. 统计好三元组
 * Description : 给你一个整数数组 arr ，以及 a、b 、c 三个整数。请你统计其中好三元组的数量。如果三元组 (arr[i], arr[j], arr[k]) 满足下列全部条件，则认为它是一个 好三元组 。
 *          0 <= i < j < k < arr.length
 *          |arr[i] - arr[j]| <= a
 *          |arr[j] - arr[k]| <= b
 *          |arr[i] - arr[k]| <= c
 *          其中 |x| 表示 x 的绝对值。返回 好三元组的数量 。
 * link : https://leetcode-cn.com/problems/count-good-triplets
 * Level : Easy
 */
public class Leetcode_weekly_20103 {
    public static void main(String[] args) {
        Leetcode_weekly_20103 lc = new Leetcode_weekly_20103();
        int[] arr = {-2,6,6,3,5,4,1,2,8};
        System.out.println(lc.maxNonOverlapping(arr, 10));
    }


    public int maxNonOverlapping(int[] nums, int target) {
        int n = nums.length;
        int max = 0;
        int[] pre = new int[n + 1];
        pre[0] = 0;
        for (int i = 0; i < n; ++i) {
            pre[i + 1] = pre[i] + nums[i];
        }
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 0;
        int count = 0;
        for (int i = 1; i <= n; ++i) {

            for(int j = i-1; j >= 0; --j) {
                if(pre[i] - pre[j] == target) {
                    count++;
                }
                max = Math.max(max, count);
            }

        }
        return max;
    }


    public int maxNonOverlapping2(int[] nums, int target) {

        int n = nums.length;

        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < n; ++i) {
            int j = i;
            int sum = nums[j];
            while (sum != target && (j+1) < n) {
                j++;
                sum += nums[j];
            }
            if(sum == target) list.add(new int[]{i, j});
        }
        if(list.size() < 2) return list.size();
        list.sort((a, b) -> a[1] - a[0] == b[1] - b[0] ? a[0] - b[0] : a[1] - a[0] - (b[1] - b[0]));

        int pre = list.get(0)[1];
        int res = 1;
        for (int i = 1; i < list.size(); i++) {
            int l =  list.get(i)[0];
            int r =  list.get(i)[1];
            if(l > pre) {
                res++;
                pre = r;
            }
        }
        return res;
    }
}
