package com.xinzhe.contest.weekly.season05.weekly212;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Xin
 * @date 2020/10/25
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_weekly_21202 {
    public static void main(String[] args) {
        Leetcode_weekly_21202 lc = new Leetcode_weekly_21202();
        int[] arr = {3,5};
    }
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        int m = l.length, n = r.length;
        List<Boolean> res = new ArrayList<>();
        int len = Math.min(m , n);

        for (int i = 0; i < len; ++i) {
            int left = l[i], right = r[i];
            int[] tmp = new int[right - left + 1];
            System.arraycopy(nums, left, tmp, 0, right - left + 1);
            Arrays.sort(tmp);
            res.add(check(tmp));
        }
        return res;

    }

    private Boolean check(int[] arr) {
        if(arr.length < 2) return false;

        int tmp = arr[1] - arr[0];
        for (int i = 2; i < arr.length; ++i) {
            if(arr[i] - arr[i-1] != tmp) return false;
        }
        return true;

    }
}
