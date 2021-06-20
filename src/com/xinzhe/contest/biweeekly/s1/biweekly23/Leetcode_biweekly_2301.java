package com.xinzhe.contest.biweeekly.s1.biweekly23;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Xin
 * @date 2020/4/4 22:30
 * Title : 5360. 统计最大组的数目
 * Description : 给你一个整数 n 。请你先求出从 1 到 n 的每个整数 10 进制表示下的数位和（每一位上的数字相加），然后把数位和相等的数字放到同一个组中。
 * 请你统计每个组中的数字数目，并返回数字数目并列最多的组有多少个。
 * link : https://leetcode-cn.com/problems/count-largest-group
 * Level : Easy
 * Comment : 23双周赛01
 */
public class Leetcode_biweekly_2301 {
    public static void main(String[] args) {
        System.out.println(countLargestGroup(24));
    }
    public static int countLargestGroup(int n) {
        if(n<10) return n;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= n; ++i) {
            int a = i;
            int sum = 0;
            while (a > 0){
                sum += a %10;
                a /= 10;
            }
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        int max = 0;
        int count = 0;
        for (Integer value : map.values()) {
            if(value > max){
                max = value;
                count = 1;
            } else if(value == max){
                count++;
            }
        }
        return count;
    }
}
