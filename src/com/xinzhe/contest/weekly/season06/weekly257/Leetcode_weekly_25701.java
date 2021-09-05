package com.xinzhe.contest.weekly.season06.weekly257;

/**
 * @author Xin
 * @date 2021/09/05
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_weekly_25701 {
    public static void main(String[] args) {
        Leetcode_weekly_25701 lc = new Leetcode_weekly_25701();

    }
    public int countQuadruplets(int[] nums) {
        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; ++j) {
                for (int k = j+1; k < n; ++k) {
                    int x = nums[i] + nums[j] + nums[k];
                    for (int l = k+1; l < n; ++l) {
                        if(nums[l] == x) count++;
                    }
                }
            }
        }
        return count;
    }

}
