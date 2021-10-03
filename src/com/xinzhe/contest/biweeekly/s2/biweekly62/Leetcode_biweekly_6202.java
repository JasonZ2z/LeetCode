package com.xinzhe.contest.biweeekly.s2.biweekly62;

/**
 * @author Xin
 * @date 2021/10/02
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_biweekly_6202 {
    public static void main(String[] args) {
        Leetcode_biweekly_6202 lc = new Leetcode_biweekly_6202();

    }
    public int numOfPairs(String[] nums, String target) {
        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; ++j) {
                if(i != j && (nums[i] + nums[j]).equals(target)) {
                    count++;
                }
            }
        }
        return count;
    }
}