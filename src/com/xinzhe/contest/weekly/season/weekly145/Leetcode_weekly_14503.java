package com.xinzhe.contest.weekly.season.weekly145;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Xin
 * @date 2020/8/23
 * Title : 1124. 表现良好的最长时间段
 * Description : 给你一份工作时间表 hours，上面记录着某一位员工每天的工作小时数。我们认为当员工一天中的工作小时数大于 8 小时的时候，那么这一天就是「劳累的一天」。
 *              所谓「表现良好的时间段」，意味在这段时间内，「劳累的天数」是严格 大于「不劳累的天数」。请你返回「表现良好时间段」的最大长度。
 * link : https://leetcode-cn.com/problems/longest-well-performing-interval
 * Level : Medium
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
        for (int i = 0; i < hours.length; i++) {
            hours[i] = hours[i] > 8 ? 1 :0;
        }
        List<Integer> list = new ArrayList<>();
        int pre = hours[0];
        int count = 1;
        for (int i = 1; i < n; ++i) {
            if(hours[i] == pre) {
                count++;
            } else {
                list.add(count);
                count = 1;
                pre = hours[i];
            }
        }
        list.add(count);
        if(hours[0] == 1) list.add(0,0);
        list.add(0);
        int max = 0;
        for (int i = 1; i < list.size()-1; i+=2) {
            max = Math.max(max, list.get(i) + Math.min(list.get(i)-1, Math.max(list.get(i+1) , list.get(i-1))));
        }
        return max;

    }
}
