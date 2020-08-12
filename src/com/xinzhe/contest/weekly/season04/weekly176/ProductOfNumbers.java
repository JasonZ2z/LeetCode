package com.xinzhe.contest.weekly.season04.weekly176;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Xin
 * @date 2020/5/19
 * Title : 1352. 最后 K 个数的乘积
 * Description :  请你实现一个「数字乘积类」ProductOfNumbers，要求支持下述两种方法：
 * 1. add(int num)  将数字 num 添加到当前数字列表的最后面。
 * 2. getProduct(int k)  返回当前数字列表中，最后 k 个数字的乘积。
 * 你可以假设当前列表中始终 至少 包含 k 个数字。
 * 题目数据保证：任何时候，任一连续数字序列的乘积都在 32-bit 整数范围内，不会溢出。
 * link : https://leetcode-cn.com/problems/product-of-the-last-k-numbers
 * Level : Medium
 * Comment 176周赛02
 */

public class ProductOfNumbers {
    List<Integer> pre;

    public ProductOfNumbers() {
        pre = new ArrayList<>();
        pre.add(1);

    }

    public void add(int num) {
        if (num == 0) {
            pre = new ArrayList<>();
            pre.add(1);
        } else {
            pre.add(num * pre.get(pre.size() - 1));
        }
    }

    public int getProduct(int k) {
        if (k >= pre.size()) return 0;
        return pre.get(pre.size() - 1) / pre.get(pre.size() - 1 - k);
    }
}
