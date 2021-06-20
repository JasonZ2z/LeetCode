package com.xinzhe.contest.biweeekly.s1.biweekly29;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Xin
 * @date 2020/6/27
 * Title : 1493. 删掉一个元素以后全为 1 的最长子数组
 * Description : 给你一个二进制数组 nums ，你需要从中删掉一个元素。请你在删掉元素的结果数组中，返回最长的且只包含 1 的非空子数组的长度。如果不存在这样的子数组，请返回 0 。
 * link : https://leetcode-cn.com/problems/longest-subarray-of-1s-after-deleting-one-element
 * Level : Medium
 */
public class Leetcode_biweekly_2903 {
    public static void main(String[] args) {
        int[] nums = {1,0,0,1,1,1,1,1,0,0,0,0,0,0,1,1,1,0,1,1,1,1,1,0,1,1,1,1,1,1,1,1,0,1,1,0,0,0,1,1,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,1,1,1,1,0,1,1};
        System.out.println(longestSubarray(nums));
    }
    public static int longestSubarray(int[] nums) {
        int n = nums.length;
        if(n == 1) return 0;
        int count1 = 0;
        for (int num : nums) {
            if (num == 1) count1++;
        }
        if(count1 == 0) return 0;
        if(count1 == n) return n-1;

        List<Integer> list = new ArrayList<>();
        int count = 0;
        for (int num : nums) {
            if (num == 1) {
                count++;
            } else {
                if (count > 0) {
                    list.add(count);
                    count = 0;
                }
                list.add(0);
            }
        }
        if(count > 0) list.add(count);

        int max = list.stream().max(Integer::compareTo).get();
        int count0 = 0;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == 0) {
                count0++;
            } else {
                if (count0 == 1) {
                    res.add(i-1);
                }
                count0 = 0;
            }
        }
        if(res.size() == 0) return max;
        int ans = 0;
        for (Integer re : res) {
            int a = re - 1 >= 0 ? list.get(re- 1) : 0;
            int b = re + 1 < list.size() ? list.get(re + 1) : 0;
            ans = Math.max(ans,  a +b);
        }
        return Math.max(ans, max);
    }
}
