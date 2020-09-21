package com.xinzhe.contest.biweeekly.biweekly35;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * @author Xin
 * @date 2020/9/19
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_biweekly_3503 {
    public static void main(String[] args) {
        Leetcode_biweekly_3503 lc = new Leetcode_biweekly_3503();
    }
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if( sum  % p  == 0) return 0;
        long l = sum % p;

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nums[i] % p;
        }
        long[] preSum = new long[n];
        preSum[0] = arr[0];
        for (int i = 1; i < n; i++) {
            preSum[i] = preSum[i-1] + arr[i];
        }
        Map<Long, Integer> map = new HashMap<>();

        return 0;

    }
}
