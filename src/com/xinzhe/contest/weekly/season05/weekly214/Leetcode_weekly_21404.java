package com.xinzhe.contest.weekly.season05.weekly214;

import com.xinzhe.categories.solutions.segmtree.Treap;

/**
 * @author Xin
 * @date 2020/11/08
 * Title : 1649. 通过指令创建有序数组
 * Description : 给你一个整数数组instructions，你需要根据instructions中的元素创建一个有序数组。一开始你有一个空的数组nums，你需要从左到右遍历instructions中的元素，将它们依次插入nums数组中。每一次插入操作的代价是以下两者的 较小值：
 *              nums中 严格小于instructions[i]的数字数目。
 *              nums中 严格大于instructions[i]的数字数目。
 *              比方说，如果要将3 插入到nums = [1,2,3,5]，那么插入操作的代价为min(2, 1) (元素1和2小于3，元素5大于3），插入后nums 变成[1,2,3,3,5]。请你返回将instructions中所有元素依次插入nums后的 总最小代价。由于答案会很大，请将它对109 + 7取余后返回。
 * link : https://leetcode-cn.com/problems/create-sorted-array-through-instructions
 * Level : Hard
 */
//todo too hard to solve
public class Leetcode_weekly_21404 {
    public static void main(String[] args) {
        Leetcode_weekly_21404 lc = new Leetcode_weekly_21404();
        int[] arr = {3,5};
    }

    public int createSortedArray(int[] instructions) {
        Treap treap = new Treap();
        long price = 0;
        for(int i : instructions) {
            treap.insert(i);
            int[] rank = treap.rank(i);
            price = (price + Math.min(rank[0] - 1, treap.getSize() - rank[1])) % 10000_00007;
        }
        return (int)price;
    }
}


