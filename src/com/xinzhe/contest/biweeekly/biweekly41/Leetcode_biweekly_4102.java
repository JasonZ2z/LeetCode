package com.xinzhe.contest.biweeekly.biweekly41;

/**
 * @author Xin
 * @date 2020/12/12
 * Title : 1685. 有序数组中差绝对值之和
 * Description : 给你一个 非递减有序整数数组nums。请你建立并返回一个整数数组result，它跟nums长度相同，且result[i]等于nums[i]与数组中所有其他元素差的绝对值之和。
 *              换句话说，result[i]等于sum(|nums[i]-nums[j]|) ，其中0 <= j < nums.length 且j != i（下标从 0 开始）。
 * link : https://leetcode-cn.com/problems/sum-of-absolute-differences-in-a-sorted-array
 * Level : Medium
 */
public class Leetcode_biweekly_4102 {
    public static void main(String[] args) {
        Leetcode_biweekly_4102 lc = new Leetcode_biweekly_4102();
        int[] arr = {2, 4, 9, 3};
        System.out.println("abc".repeat(0));
    }
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n+1];
        int[] res = new int[n];
        for(int i=1; i<=n; i++) pre[i] = pre[i-1] + nums[i-1];
        for(int i=0; i<n; i++) {
            res[i] = nums[i] * i - pre[i] + pre[n] - pre[i]  - nums[i] * (n- i);
        }
        return res;
    }
}