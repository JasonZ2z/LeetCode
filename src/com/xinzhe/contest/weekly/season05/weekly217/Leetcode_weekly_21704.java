package com.xinzhe.contest.weekly.season05.weekly217;

import java.util.TreeSet;

/**
 * @author Xin
 * @date 2020/11/29
 * Title : 1675. 数组的最小偏移量
 * Description : 给你一个由 n 个正整数组成的数组 nums 。你可以对数组的任意元素执行任意次数的两类操作：
 *              如果元素是 偶数 ，除以 2 例如，如果数组是 [1,2,3,4] ，那么你可以对最后一个元素执行此操作，使其变成 [1,2,3,2]
 *              如果元素是 奇数 ，乘上 2 例如，如果数组是 [1,2,3,4] ，那么你可以对第一个元素执行此操作，使其变成 [2,2,3,4]
 *              数组的 偏移量 是数组中任意两个元素之间的 最大差值 。返回数组在执行某些操作之后可以拥有的 最小偏移量 。
 * link : https://leetcode-cn.com/problems/minimize-deviation-in-array
 * Level : Hard
 */

//todo need to review
public class Leetcode_weekly_21704 {
    public static void main(String[] args) {
        Leetcode_weekly_21704 lc = new Leetcode_weekly_21704();
        int[] arr = {3,5};
    }

    public int minimumDeviation2(int[] nums) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int num : nums) {
            treeSet.add(num % 2 == 0 ? num : num * 2);
        }

        int cut = treeSet.last() - treeSet.first();
        while (cut > 0 && (treeSet.last() % 2 == 0)) {
            int value = treeSet.last();
            treeSet.remove(value);
            treeSet.add(value / 2);
            cut = Math.min(cut, treeSet.last() - treeSet.first());
        }
        return cut;
    }
}
