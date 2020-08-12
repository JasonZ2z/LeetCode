package com.xinzhe.contest.biweeekly.biweekly29;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Xin
 * @create 2020/6/27
 * Title : 1492. n 的第 k 个因子
 * Description : 给你两个正整数 n 和 k 。如果正整数 i 满足 n % i == 0 ，那么我们就说正整数 i 是整数 n 的因子。考虑整数 n 的所有因子，将它们 升序排列 。请你返回第 k 个因子。如果 n 的因子数少于 k ，请你返回 -1 。
 * link : https://leetcode-cn.com/problems/the-kth-factor-of-n
 * Level : Medium
 */
public class Leetcode_biweekly_2902 {
    public static void main(String[] args) {
        System.out.println(kthFactor(7, 2));
    }

    public static int kthFactor(int n, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; ++i) {
            if( n % i == 0) {
                list.add(i);
            }
        }
        if(k > list.size()) return -1;
        return list.get(k-1);
    }
}
