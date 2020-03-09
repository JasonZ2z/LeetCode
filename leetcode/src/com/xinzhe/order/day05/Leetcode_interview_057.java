package com.xinzhe.order.day05;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Xin
 * @create 2020/2/29 18:01
 * Title : 面试题57 - II. 和为s的连续正数序列
 * Description : 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 *              序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 * link : https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof
 * Level : Easy
 */

public class Leetcode_interview_057 {
    public static void main(String[] args) {
        int[][] a = findContinuousSequence(15);
        for (int[] ints : a) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    public static int[][] findContinuousSequence(int target) {
        if(target < 3) return new int[0][0];
        int left = 1, right = 2;
        int sum = 1;
        List<int[]> result = new ArrayList<>();
        while(right < target){
            while(sum < target){
                sum += right++;
            }
            while(sum >= target){
                if(sum == target){
                    int[] arr = new int[right - left];
                    for (int i = 0; i < arr.length ; i++) {
                        arr[i] = left +i;
                    }
                    result.add(arr);
                }
                sum -= left++;
            }
        }
        int[][] res = new int[result.size()][];
        for (int i = 0; i < res.length; i++) {
            res[i] = result.get(i);
        }
        return res;
    }


}
