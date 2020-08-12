package com.xinzhe.categories.solutions.bitmanipulation.medium;

import java.util.Arrays;

/**
 * @author Xin
 * @date 2020/4/28
 * Title : 260. 只出现一次的数字 III
 * Description : 给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。
 * link : https://leetcode-cn.com/problems/single-number-iii/
 * Level : Medium
 */

    // 首先 异或^ 具有传递性
    // 所有数异或的结果 也是所求值的异或
    // 这两个所求值 肯定不同 -> 异或值至少有一位为1
    // 根据这个1 将原数组分为两组 分别异或 即为所求值
    //todo need to review
public class Leetcode260 {
    public static void main(String[] args) {
        int[] arr = {1,2,1,0,2,3};
        System.out.println(Arrays.toString(singleNumber(arr)));
    }
    public static int[] singleNumber(int[] nums) {
        int n = nums.length;
        if(n < 3) return nums;

        int a = 0, b= 0;
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }

        //改进
        //diff &= -diff;//-diff先取补码，再加一，此句找出最右侧的1
        int flag = 1;
        while(true) {
           if((xor & 1) == 1) {
               break;
           } else {
               flag <<= 1;
               xor >>= 1;
           }
        }

        for (int num : nums) {
            if((num & flag) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }
        return new int[]{a,b};
    }
}
