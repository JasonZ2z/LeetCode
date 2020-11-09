package com.xinzhe.contest.weekly.season05.weekly214;

/**
 * @author Xin
 * @date 2020/11/08
 * Title : 1646. 获取生成数组中的最大值
 * Description : 给你一个整数 n 。按下述规则生成一个长度为 n + 1 的数组 nums ：nums[0] = 0, nums[1] = 1
 *              当 2 <= 2 * i <= n 时，nums[2 * i] = nums[i]
 *              当 2 <= 2 * i + 1 <= n 时，nums[2 * i + 1] = nums[i] + nums[i + 1]
 *              返回生成数组 nums 中的 最大 值。
 * link : https://leetcode-cn.com/problems/get-maximum-in-generated-array
 * Level : Easy
 */
public class Leetcode_weekly_21401 {
    public static void main(String[] args) {
        Leetcode_weekly_21401 lc = new Leetcode_weekly_21401();
        int[] arr = {3,5};
    }
    public int getMaximumGenerated(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        int[] res = new int[n+1];
        res[0] = 0;
        res[1] = 1;
        int max = 0;
        for (int i = 2; i <= n; ++i) {
            if(i % 2 == 0) res[i] = res[i / 2];
            else {
                res[i] = res[i/2] + res[i/2 + 1];
            }
            max = Math.max(max, res[i]);
        }
        return max;
    }
}
