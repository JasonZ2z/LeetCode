package com.xinzhe.contest.weekly.season05.weekly220;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Xin
 * @date 2020/12/20
 * Title :
 * Description :
 * link :
 * Level :
 */
public class Leetcode_weekly_22002 {
    public static void main(String[] args) {
        Leetcode_weekly_22002 lc = new Leetcode_weekly_22002();
        int[] arr = {5,2,1,2,5,2,1,2,5};
        System.out.println(lc.maximumUniqueSubarray(arr));
    }
    public int maximumUniqueSubarray(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        int[] pre = new int[n + 1];
        for(int i=1; i<=n; i++) pre[i] = pre[i-1] + nums[i-1];

        int i=0, j=0, max = nums[0];
        while ( j < n) {
            if(map.containsKey(nums[j])) {
                max = Math.max(max, pre[j] - pre[i]);
                i = Math.max(i, map.get(nums[j]) + 1);
            }
            map.put(nums[j], j);
            j++;
        }
        max = Math.max(max, pre[n] - pre[i]);
        return max;
    }
}
