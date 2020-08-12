package com.xinzhe.categories.solutions.bitmanipulation.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Xin
 * @date 2020/8/12
 * Title : 401. 二进制手表
 * Description : 二进制手表顶部有 4 个 LED 代表 小时（0-11），底部的 6 个 LED 代表 分钟（0-59）。每个 LED 代表一个 0 或 1，最低位在右侧。
 * link : https://leetcode-cn.com/problems/binary-watch
 * Level : Easy
 */

public class Leetcode401 {

    public List<String> readBinaryWatch2(int num) {
        List<String> res = new ArrayList<>();
        for(int i=0; i<12; i++) {
            for(int j=0; j<60; j++) {
                if(Integer.bitCount(i* (1<<6) + j) == num) {
                    res.add(i + ":" + ((j < 10) ? ("0" + j) : j));
                }
            }
        }
        return res;
    }

    int[] hours = {0,1,2,4,8};
    int[] minus = {0,1,2,4,8,16,32};
    public List<String> readBinaryWatch(int num) {
        List<String> res = new ArrayList<>();
        for(int i=0; i<=3; i++) {
            List<Integer> hs = helper(hours, i);
            List<Integer> ms = helper(minus, num-i);
            for (int h : hs) {
                if(h > 11) continue;
                for (int m : ms) {
                    if(m > 59) continue;
                    res.add(h + ":" + (m > 10 ? m : ("0"+m)));
                }
            }
        }
        return res;
    }

    private List<Integer> helper(int[] nums, int total) {
        List<Integer> list = new ArrayList<>();
        dfs(nums, total, 0, 0, list);
        return list;
    }

    private void dfs(int[] nums, int total, int start, int sum, List<Integer> list) {
        if(start == total) {
            list.add(sum);
            return;
        }
        for(int i=start; i<=nums.length; i++) {
            dfs(nums, total, i+1, sum + nums[i], list);
        }
    }
}
