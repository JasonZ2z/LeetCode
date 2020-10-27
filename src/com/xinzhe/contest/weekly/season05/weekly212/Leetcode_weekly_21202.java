package com.xinzhe.contest.weekly.season05.weekly212;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Xin
 * @date 2020/10/25
 * Title : 1630. 等差子数组
 * Description : 如果一个数列由至少两个元素组成，且每两个连续元素之间的差值都相同，那么这个序列就是 等差数列 。
 *              更正式地，数列 s 是等差数列，只需要满足：对于每个有效的 i ， s[i+1] - s[i] == s[1] - s[0] 都成立。
 * link : https://leetcode-cn.com/problems/arithmetic-subarrays
 * Level : Medium
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
