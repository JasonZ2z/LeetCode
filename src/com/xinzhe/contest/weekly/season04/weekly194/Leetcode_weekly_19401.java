package com.xinzhe.contest.weekly.season04.weekly194;

/**
 * @author Xin
 * @date 2020/6/21
 * Title : 1486. 数组异或操作
 * Description : 给你两个整数，n 和 start 。数组 nums 定义为：nums[i] = start + 2*i（下标从 0 开始）且 n == nums.length 请返回 nums 中所有元素按位异或（XOR）后得到的结果。
 * link : https://leetcode-cn.com/problems/xor-operation-in-an-array
 * Level : Easy
 * Comment 194周赛01
 */
public class Leetcode_weekly_19401 {
    public int xorOperation(int n, int start) {
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = start + 2 * i;
        }
        int res = arr[0];
        for (int i = 1; i < arr.length; i++) {
            res ^= arr[i];
        }
        return res;
    }
}
