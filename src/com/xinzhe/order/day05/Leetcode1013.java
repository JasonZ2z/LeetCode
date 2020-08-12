package com.xinzhe.order.day05;

import java.util.Arrays;

/**
 * @author Xin
 * @date 2020/3/11 18:15
 * Title : 1013. 将数组分成和相等的三个部分
 * Description : 给你一个整数数组 A，只有可以将其划分为三个和相等的非空部分时才返回 true，否则返回 false。
 * link : https://leetcode-cn.com/problems/partition-array-into-three-parts-with-equal-sum/
 * Level : Easy
 */
public class Leetcode1013 {
    public static void main(String[] args) {
        int[] a = {12,-4,16,-5,9,-3,3,8,0};
        System.out.println(canThreePartsEqualSum(a));
    }
    public static boolean canThreePartsEqualSum(int[] A) {
        int sum = Arrays.stream(A).sum();
        if(sum % 3 != 0) return false;
        int subSum = sum/3;
        int tmp = 0;
        int count = 0;
        for (int value : A) {
            tmp += value;
            if (tmp == subSum) {
                tmp = 0;
                count++;
            }

        }
        return count >=3;
    }
}
