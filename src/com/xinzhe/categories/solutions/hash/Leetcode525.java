package com.xinzhe.categories.solutions.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Xin
 * @date 2020/2/24 14:21
 * Title : 525. 连续数组
 * Description : 给定一个二进制数组, 找到含有相同数量的 0 和 1 的最长连续子数组（的长度）。
 * link : https://leetcode-cn.com/problems/contiguous-array/
 * level : Medium
 */
//todo need to review
public class Leetcode525 {

    public int findMaxLength(int[] nums) {
        int n = nums.length;
        for(int i=0; i<n; i++) {
            if(nums[i] == 0) nums[i] = -1;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int pre = 0;
        map.put(0, -1);
        int ans = 0;
        for(int i=0; i<n; i++) {
            pre += nums[i];
            if(map.containsKey(pre)) {
                ans = Math.max(ans, i - map.get(pre));
            } else {
                map.put(pre, i);
            }
        }
        return ans;
    }
}
