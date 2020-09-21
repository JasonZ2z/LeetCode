package com.xinzhe.contest.biweeekly.biweekly35;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Xin
 * @date 2020/9/19
 * Title : 1590. 使数组和能被 P 整除
 * Description : 给你一个正整数数组 nums，请你移除 最短 子数组（可以为 空），使得剩余元素的 和 能被 p 整除。 不允许 将整个数组都移除。
 *              请你返回你需要移除的最短子数组的长度，如果无法满足题目要求，返回 -1 。子数组 定义为原数组中连续的一组元素。
 * link : https://leetcode-cn.com/problems/make-sum-divisible-by-p
 * Level : Medium
 */

//todo need to review
//same as 560 and 974
public class Leetcode_biweekly_3503 {
    public static void main(String[] args) {
        Leetcode_biweekly_3503 lc = new Leetcode_biweekly_3503();
        int[] arr = {6,3,5,2};
        System.out.println(lc.minSubarray(arr, 9));
    }
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        long[] pre = new long[n+1];
        for(int i=1; i<=n; i++) {
            pre[i] = pre[i-1] + nums[i-1];
        }
        long mod = pre[n] % p;
        if(mod == 0) return 0;
        int ans = n;
        Map<Long, Integer> map = new HashMap<>();
        for(int i=0; i<=n; i++) {
            long tmp = (pre[i] - mod + p) % p; //important
            if(map.containsKey(tmp)) {
                ans = Math.min(ans, i - map.get(tmp));
            }
            map.put(pre[i] % p, i);
        }
        return ans == n ? -1 : ans;
    }
}
