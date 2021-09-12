package com.xinzhe.contest.lccup.lc2021.solo.spring;

import java.util.Arrays;

/**
 * @author xzheng
 * @create 2021/4/5
 */
public class Lccup_01 {
    public static void main(String[] args) {
        Lccup_01 lc = new Lccup_01();
    }
    public int purchasePlans(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        int mod = (int)1e9 + 7;
        long res = 0;
        for (int i = n-1; i > 0 ; --i) {
            res += helper(nums, i, target);
        }
        return (int) (res % mod);
    }

    private long helper(int[] nums, int i, int target) {
        if(i > 0 && nums[i] + nums[i-1] <= target) {
            return i;
        }
        if(nums[i] + nums[0] > target) return 0;
        int l = 0, r = i-1;
        while (l < r) {
            int mid = l + (r - l + 1) / 2;
            if(nums[i] + nums[mid] <= target) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }

        return l + 1;
    }
}
