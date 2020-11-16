package com.xinzhe.contest.weekly.season05.weekly215;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Xin
 * @date 2020/11/15
 * Title : 1658. 将 x 减到 0 的最小操作数
 * Description :  给你一个整数数组 nums 和一个整数 x 。每一次操作时，你应当移除数组 nums 最左边或最右边的元素，然后从 x 中减去该元素的值。请注意，需要 修改 数组以供接下来的操作使用。
 *              如果可以将 x恰好 减到0 ，返回 最小操作数 ；否则，返回 -1 。
 * link : https://leetcode-cn.com/problems/minimum-operations-to-reduce-x-to-zero
 * Level : Medium
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
            post += nums[n - 1 - i];
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
