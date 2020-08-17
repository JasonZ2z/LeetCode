package com.xinzhe.contest.weekly.season05.weekly202;

/**
 * @author Xin
 * @date 2020/8/16
 * Title : 5185. 存在连续三个奇数的数组
 * Description : 给你一个整数数组 arr，请你判断数组中是否存在连续三个元素都是奇数的情况：如果存在，请返回 true ；否则，返回 false 。
 * link : https://leetcode-cn.com/problems/three-consecutive-odds/
 * Level : Easy
 */
public class Leetcode_weekly_20201 {
    public static void main(String[] args) {
        Leetcode_weekly_20201 lc = new Leetcode_weekly_20201();
    }

    public boolean threeConsecutiveOdds(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 2; ++i) {
            if(arr[i] % 2 == 1 && arr[i+1] % 2 == 1  && arr[i+2] % 2 == 1) {
                return true;
            }
        }
        return false;
    }
}
