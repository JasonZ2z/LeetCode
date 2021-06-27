package com.xinzhe.contest.biweeekly.s2.biweekly55;

/**
 * @author Xin
 * @date 2021/06/26
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_biweekly_5501 {
    public static void main(String[] args) {
        Leetcode_biweekly_5501 lc = new Leetcode_biweekly_5501();
        int[] arr = {100, 21, 100};
        System.out.println(lc.canBeIncreasing(arr));
    }

    public boolean canBeIncreasing(int[] nums) {
        int n = nums.length;
        if(n < 3) return true;
        int[] tmp = new int[n+1];
        System.arraycopy(nums, 0 , tmp, 1, n);
        for (int i = 1; i < n; ++i) {
            if (tmp[i] <= tmp[i - 1] || tmp[i] >= tmp[i + 1]) {
                return check(tmp, i-1)|| check(tmp, i) || check(tmp, i+1);
            }
        }
        return true;
    }

    private boolean check(int[] nums, int i) {
        int pre = nums[0];
        for (int j = 1; j < nums.length; j++) {
            if(j == i) continue;
            if(nums[j] > pre) {
                pre = nums[j];
            } else {
                return false;
            }
        }
        return true;
    }

}