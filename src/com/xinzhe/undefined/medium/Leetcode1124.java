package com.xinzhe.undefined.medium;

/**
 * @author Xin
 * @date 2023/02/14
 * Title : 1124. 表现良好的最长时间段
 * link : https://leetcode.cn/problems/longest-well-performing-interval/
 * Level : Medium
 */
public class Leetcode1124 {
    public int longestWPI(int[] hours) {
        int n = hours.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            int count = hours[i] > 8 ? 1 : -1;
            if(count > 0) max = Math.max(max, 1);
            for (int j = i+1; j < n; j++) {
                count += hours[j] > 8 ? 1 : -1;
                if(count > 0) max = Math.max(max, j-i+1);
            }
        }
        return max;
    }
}
