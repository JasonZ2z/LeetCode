package com.xinzhe.categories.solutions.slidingwindow.consecutive;

/**
 * @Author Xin
 * @create 2020/6/3
 * Title : 485. 最大连续1的个数
 * Description : 给定一个二进制数组， 计算其中最大连续1的个数。
 * link :  https://leetcode-cn.com/problems/max-consecutive-ones/
 * Level : Easy
 */
public class Leetcode485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int max = 0;
        for (int num : nums) {
            if (num == 1) {
                count++;
                max = Math.max(max, count);
            } else {
                count = 0;
            }
        }
        return max;
    }
}
