package com.xinzhe.contest.weekly.season03.weekly128;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Xin
 * @date 2020/9/22
 * Title : 1010. 总持续时间可被 60 整除的歌曲
 * Description : 在歌曲列表中，第 i 首歌曲的持续时间为 time[i] 秒。返回其总持续时间（以秒为单位）可被 60 整除的歌曲对的数量。
 *              形式上，我们希望索引的数字 i 和 j 满足  i < j 且有 (time[i] + time[j]) % 60 == 0。
 * link : https://leetcode-cn.com/problems/pairs-of-songs-with-total-durations-divisible-by-60
 * Level : Easy
 */

public class Leetcode_weekly_12802 {
    public static void main(String[] args) {
        Leetcode_weekly_12802 lc = new Leetcode_weekly_12802();
        int[] arr = {60,60,60};
        System.out.println(lc.numPairsDivisibleBy60(arr));
    }
    public int numPairsDivisibleBy60(int[] time) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int i : time) {
            int mod = i % 60;
            if(mod == 0) {
                ans += map.getOrDefault(0, 0);
            }else {
                ans += map.getOrDefault(60 - mod, 0);
            }
            map.put(mod, map.getOrDefault(mod, 0) + 1);
        }
        return ans;
    }
}
