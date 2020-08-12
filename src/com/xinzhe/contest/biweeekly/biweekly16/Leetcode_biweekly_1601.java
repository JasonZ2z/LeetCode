package com.xinzhe.contest.biweeekly.biweekly16;

/**
 * @author Xin
 * @date 2020/5/29
 * Title : 1299. 将每个元素替换为右侧最大元素
 * Description : 给你一个数组 arr ，请你将每个元素用它右边最大的元素替换，如果是最后一个元素，用 -1 替换。完成所有替换操作后，请你返回这个数组。
 * link : https://leetcode-cn.com/problems/replace-elements-with-greatest-element-on-right-side/
 * Level : Easy
 * Comment 16双周赛01
 */

public class Leetcode_biweekly_1601 {
    public int[] replaceElements(int[] arr) {
        int n = arr.length;
        int max = -1;
        for (int i = n - 1; i >= 0; i--) {
            int tmp = arr[i];
            arr[i] = max;
            max = Math.max(max, tmp);
        }
        return arr;
    }
}
