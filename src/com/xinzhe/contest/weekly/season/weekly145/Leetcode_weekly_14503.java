package com.xinzhe.contest.weekly.season.weekly145;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Xin
 * @date 2020/8/23
 * Title : 1124. 表现良好的最长时间段
 * Description : 给你一份工作时间表 hours，上面记录着某一位员工每天的工作小时数。我们认为当员工一天中的工作小时数大于 8 小时的时候，那么这一天就是「劳累的一天」。
 *              所谓「表现良好的时间段」，意味在这段时间内，「劳累的天数」是严格 大于「不劳累的天数」。请你返回「表现良好时间段」的最大长度。
 * link : https://leetcode-cn.com/problems/longest-well-performing-interval
 * Level : Medium
 * tag : 前缀和 + hash， 单调栈
 * comment : same as 560, 1248, 1371
 */

public class Leetcode_weekly_14503 {

    public static void main(String[] args) {
        Leetcode_weekly_14503 lc = new Leetcode_weekly_14503();
        int[] h = {9,9,6,0,6,6,9,9,3,4,5,15,12,12,2,3,12,3,2,14,12,14,4,4,5};
        System.out.println(lc.longestWPI(h));
    }
    //todo undo
    public int longestWPI(int[] hours) {
        int n = hours.length;
        for (int i = 0; i < n; i++) {
            hours[i] = hours[i] > 8 ? 1 : -1;
        }
        int sum = Arrays.stream(hours).sum();
        if(sum > 0) return n;
        Map<Integer, Integer> map = new HashMap<>();
        int cur = 0;
        int res = 0;
        for (int i = 0; i < n; ++i) {
            cur += hours[i];
            if(cur > 0) {
                res = i+1;
            }else {
                if(!map.containsKey(cur)) {
                    map.put(cur, i);
                }
                if(map.containsKey(cur -1)) {
                    res = Math.max(res, i - map.get(cur - 1));
                }
            }
        }
        return res;
    }
}
