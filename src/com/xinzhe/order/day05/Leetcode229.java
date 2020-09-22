package com.xinzhe.order.day05;

import java.util.ArrayList;
import java.util.List;
/**
 * @author Xin
 * @date 2020/9/22
 * Title : 229. 求众数 II
 * Description : 给定一个大小为 n 的数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1)。
 * link : https://leetcode-cn.com/problems/majority-element-ii/
 * Level : Medium
 */
public class Leetcode229 {
    public static void main(String[] args) {
        int[] a = {1,1,1,3,3,2,2,2};
        System.out.println(majorityElement(a));
    }
    public static List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        List<Integer> list= new ArrayList<>();
        if(n == 0) return list;
        if(n == 1) {
            list.add(nums[0]);
            return list;
        }
        int ca=0, cb =0;
        int a = 0, b = 0;
        for (int value : nums) {
            if (value == a) {
                ca++;
            } else if (value == b) {
                cb++;
            } else {
                if (ca == 0) {
                    ca = 1;
                    a = value;
                } else if (cb == 0) {
                    cb = 1;
                    b = value;
                } else {
                    ca--;
                    cb--;
                }
            }
        }
        if(a == b){
            list.add(a);
            return list;

        } else {
            int counta =0, countb=0;
            for (int num : nums) {
                if (num == a) counta++;
                if (num == b) countb++;
            }
            int val = n/3;
            if(counta > val) list.add(a);
            if(countb > val) list.add(b);
            return list;
        }

    }
}
