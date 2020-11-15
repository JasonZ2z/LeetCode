package com.xinzhe.contest.weekly.season05.weekly215;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Xin
 * @date 2020/11/15
 * Title :
 * Description : 
 * link :
 * Level : Easy
 */
public class Leetcode_weekly_21503 {
    public static void main(String[] args) {
        Leetcode_weekly_21503 lc = new Leetcode_weekly_21503();
        int[] arr = {5,6,7,8,1};
        System.out.println(lc.minOperations(arr, 6));
    }
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        int sum = 0;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; ++i) {
            sum += nums[i];
            if(sum == x) res = Math.min(res, i + 1);
            map.put(sum, i);
        }
        if(sum < x) return -1;

        int post = 0;
        for (int i = 0; i < n; ++i) {
            post  += nums[n - 1 - i];
            if(post == x) res = Math.min(res, i + 1);
            if(map.containsKey(x - post)) {
                int j = map.get(x - post);
                if(i + j >= n) continue;
                res = Math.min(i + map.get(x - post) + 2, res);
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
