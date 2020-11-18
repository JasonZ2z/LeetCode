package com.xinzhe.categories.structure.stack;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author Xin
 * @date 2020/11/18
 * Title : 503. 下一个更大元素 II
 * Description : 给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。
 *              数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。
 * link : https://leetcode-cn.com/problems/next-greater-element-ii
 * Level : Medium
 */
//todo need to review
public class Leetcode503 {
    public static void main(String[] args) {
        Leetcode503 lc = new Leetcode503();
        String num = "112";
    }

    public int[] nextGreaterElement(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n*2; i++) {
            int num = nums[i % n];
            while(!list.isEmpty() && nums[list.peekLast()] < num) {
                res[list.pollLast()] = num;
            }
            if(i < n ) list.addLast(i);
        }
        return res;
    }

}
