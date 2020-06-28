package com.xinzhe.contest.weekly.season04.weekly195;

/**
 * @Author Xin
 * @create 2020/6/28
 * Title :
 * Description :
 * link :
 * Level : Medium
 * Comment 195周赛03
 */
public class Leetcode_weekly_19503 {
    public static void main(String[] args) {
        int[] arr = {3,5,6,7};
        //int[] arr = {3,3,6,8};
        System.out.println(numSubseq(arr, 9));
    }
    static final int MOD = (int)(1e9 + 7);
    public static int numSubseq(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = 0;
        int sum  = 0;
        int res = 0;
        while (left< n) {
            while (right < n && sum <= target) {
                sum += nums[right];
                right++;
            }

            if(sum > target) {
                sum -= nums[left];
                res += right - left -1;
            }
            left++;
        }
        return res;
    }
}
