package com.xinzhe.categories.structure.stack;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author Xin
 * @date 2020/11/18
 * Title : 496. 下一个更大元素 I
 * Description : 给定两个 没有重复元素 的数组nums1 和nums2，其中nums1是nums2的子集。找到nums1中每个元素在nums2中的下一个比其大的值。
 *              nums1中数字x的下一个更大元素是指x在nums2中对应位置的右边的第一个比x大的元素。如果不存在，对应位置输出 -1 。
 * link : https://leetcode-cn.com/problems/next-greater-element-i
 * Level : Easy
 */
//todo need to review
public class Leetcode496 {
    public static void main(String[] args) {
        Leetcode496 lc = new Leetcode496();
        String num = "112";
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums2.length;
        Map<Integer, Integer> map = new HashMap<>();
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            while(!list.isEmpty() && nums2[list.peekLast()] < nums2[i]) {
                int x = list.pollLast();
                map.put(nums2[x], nums2[i]);
            }
            list.addLast(i);
        }
        for (int i=0; i<nums1.length; i++) {
            nums1[i] = map.getOrDefault(nums1[i], -1);
        }
        return nums1;
    }

}
