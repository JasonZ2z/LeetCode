package com.xinzhe.contest.biweeekly.biweekly30;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author Xin
 * @create 2020/7/11
 * Title :
 * Description :
 * link :
 * Level : Medium
 */
public class Leetcode_biweekly_3002 {
    public static void main(String[] args) {
        Leetcode_biweekly_3002 lc = new Leetcode_biweekly_3002();
        int[] arr = {1,2,3,4};
        System.out.println(lc.rangeSum(arr, 4, 1, 10));
    }

    static final int mod = (int) (1e9 +7);
    public int rangeSum(int[] nums, int n, int left, int right) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            int j = i;
            int tmp = 0;
            while (j < n) {
                tmp += nums[j++];
                list.add(tmp);
            }
        }
        Collections.sort(list);
        System.out.println(list);
        long sum = 0;
        for (int i = left-1; i < right; ++i) {
            sum += list.get(i);
        }
        return (int)sum % mod;
    }
}
