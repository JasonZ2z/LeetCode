package com.xinzhe.contest.weekly.season03.weekly123;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Xin
 * @date 2020/9/24
 * Title : 992. K 个不同整数的子数组
 * Description : 给定一个正整数数组 A，如果 A 的某个子数组中不同整数的个数恰好为 K，则称 A 的这个连续、不一定独立的子数组为好子数组。
 *              （例如，[1,2,3,1,2] 中有 3 个不同的整数：1，2，以及 3。）返回 A 中好子数组的数目。
 * link : https://leetcode-cn.com/problems/subarrays-with-k-different-integers
 * Level : Hard
 */

//todo undo
public class Leetcode_weekly_12304 {
    public static void main(String[] args) {
        Leetcode_weekly_12304 lc = new Leetcode_weekly_12304();
        int[] arr = {1,2,1,2,3};
        System.out.println(lc.subarraysWithKDistinct(arr, 2));
    }
    public int subarraysWithKDistinct(int[] arr, int k) {
        int n = arr.length;
        int ans = 0;
        for (int len = k; len <= n; ++len) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < len; ++i) {
                map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            }
            if(map.size() == k) ans++;
            for (int i = len; i < n; ++i) {
                map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
                if(map.get(arr[i - len]) == 1) {
                    map.remove(arr[i - len]);
                } else {
                    map.put(arr[i - len], map.get(arr[i-len]) -1 );
                }
                if(map.size() == k) ans++;
            }
        }
        return ans;
    }
}
