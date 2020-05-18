package com.xinzhe.contest.biweeekly.biweekly20;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Xin
 * @create 2020/5/18
 * Title : 1356. 根据数字二进制下 1 的数目排序
 * Description : 给你一个整数数组 arr 。请你将数组中的元素按照其二进制表示中数字 1 的数目升序排序。
 * 如果存在多个数字二进制中 1 的数目相同，则必须将它们按照数值大小升序排列。
 * 请你返回排序后的数组.
 * link : https://leetcode-cn.com/problems/sort-integers-by-the-number-of-1-bits
 * Level : Easy
 * Comment 20双周赛01
 */

public class Leetcode_biweekly_2001 {
    public int[] sortByBits(int[] arr) {
        List<Data> list = new ArrayList<>();
        for (int i : arr) {
            int count = Integer.bitCount(i);
            list.add(new Data(count, i));
        }
        list.sort((a, b) -> {
            if (a.count == b.count) return Integer.compare(a.val, b.val);
            return Integer.compare(a.count, b.count);
        });
        int[] res = new int[arr.length];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i).val;
        }
        return res;
    }

    class Data {
        int count;
        int val;

        public Data(int count, int val) {
            this.count = count;
            this.val = val;
        }
    }
}
