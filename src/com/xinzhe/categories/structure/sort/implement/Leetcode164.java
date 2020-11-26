package com.xinzhe.categories.structure.sort.implement;

import java.util.Arrays;

/**
 * @author Xin
 * @date 2020/11/26
 * Title : 164. 最大间距
 * Description : 给定一个无序的数组，找出数组在排序之后，相邻元素之间最大的差值。如果数组元素个数小于 2，则返回 0。
 * link : https://leetcode-cn.com/problems/maximum-gap/
 * Level : Hard
 */
//todo need to review
public class Leetcode164 {
    public int maximumGap(int[] nums) {
        int n = nums.length;
        if(n < 2) return 0;
        int max = 0, min = Integer.MAX_VALUE;
        for (int num : nums) {
            max = Math.max(num, max);
            min = Math.min(num, min);
        }
        int gap = Math.max (1, (max - min) / (n - 1));
        int size = (max - min) / gap + 1;
        int[][] buckets = new int[size][2];
        for (int i = 0; i < size; i++) {
            Arrays.fill(buckets[i], -1);
        }

        for (int num : nums) {
            int i = (num - min) / gap;
            buckets[i][0] = buckets[i][0] == -1 ? num : Math.min(num, buckets[i][0]);
            buckets[i][1] = buckets[i][1] == -1 ? num : Math.max(num, buckets[i][1]);
        }
        int ans = 0, pre = -1;
        for (int i = 0; i < size; i++) {
            if(buckets[i][0] == -1) continue;
            if(pre != -1) {
                ans = Math.max(ans, buckets[i][0] - buckets[pre][1]);
            }
            pre = i;
        }
        return ans;
    }
}
