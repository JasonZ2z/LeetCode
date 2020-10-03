package com.xinzhe.contest.weekly.season05.weekly203;

import java.util.TreeSet;

/**
 * @author Xin
 * @date 2020/8/23
 * Title : 1562. 查找大小为 M 的最新分组
 * Description : 给你一个数组 arr ，该数组表示一个从 1 到 n 的数字排列。有一个长度为 n 的二进制字符串，该字符串上的所有位最初都设置为 0 。
 *              在从 1 到 n 的每个步骤 i 中（假设二进制字符串和 arr 都是从 1 开始索引的情况下），二进制字符串上位于位置 arr[i] 的位将会设为 1 。
 *              给你一个整数 m ，请你找出二进制字符串上存在长度为 m 的一组 1 的最后步骤。一组 1 是一个连续的、由 1 组成的子串，且左右两边不再有可以延伸的 1 。
 *              返回存在长度 恰好 为 m 的 一组 1  的最后步骤。如果不存在这样的步骤，请返回 -1 。
 * link :  https://leetcode-cn.com/problems/find-latest-group-of-size-m
 * Level : Medium
 */
//todo need to review
public class Leetcode_weekly_20303 {
    public static void main(String[] args) {
        Leetcode_weekly_20303 lc = new Leetcode_weekly_20303();
    }
    public int findLatestStep(int[] arr, int m) {
        int n = arr.length;
        if(n == m) return n;
        TreeSet<Integer> set = new TreeSet<>();
        set.add(0); set.add(n + 1);
        for(int i = n-1; i >= 0; --i) {
            int index = arr[i];
            int a = set.lower(index);
            int b = set.higher(index);
            if(index - a - 1 == m || b - index - 1 == m) return i;
            set.add(index);
        }
        return -1;

    }
}
