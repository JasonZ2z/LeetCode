package com.xinzhe.contest.weekly.season04.weekly161;

/**
 * @author Xin
 * @date 2020/6/20
 * Title : 1250. 检查「好数组」
 * Description : 给你一个正整数数组 nums，你需要从中任选一些子集，然后将子集中每一个数乘以一个 任意整数，并求出他们的和。
 *              假如该和结果为 1，那么原数组就是一个「好数组」，则返回 True；否则请返回 False。
 * link : https://leetcode-cn.com/problems/check-if-it-is-a-good-array
 * Level : Hard
 * Comment 161周赛04
 */

public class Leetcode_weekly_16104 {
    public static void main(String[] args) {
    }
    private int gcd(int a, int b){
        return a==0? b : gcd(b%a , a);
    }
    public boolean isGoodArray(int[] nums) {
        int ans = nums[0];
        for(int i = 1; i < nums.length; i ++){
            ans = gcd(ans , nums[i]);
        }
        return ans == 1;
    }
}
