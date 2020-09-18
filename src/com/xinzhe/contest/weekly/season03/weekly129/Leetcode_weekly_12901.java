package com.xinzhe.contest.weekly.season03.weekly129;

import java.util.Arrays;

/**
 * @author Xin
 * @date 2020/9/18
 * Title : 1013. 将数组分成和相等的三个部分
 * Description : 给你一个整数数组 A，只有可以将其划分为三个和相等的非空部分时才返回 true，否则返回 false。
 *              形式上，如果可以找出索引 i+1 < j 且满足 A[0] + A[1] + ... + A[i] == A[i+1] + A[i+2] + ... + A[j-1] == A[j] + A[j-1] + ... + A[A.length - 1] 就可以将数组三等分。
 * link : https://leetcode-cn.com/problems/partition-array-into-three-parts-with-equal-sum
 * Level : Easy
 */

public class Leetcode_weekly_12901 {
    public static void main(String[] args) {
        Leetcode_weekly_12901 lc = new Leetcode_weekly_12901();
    }
    public boolean canThreePartsEqualSum(int[] A) {
        int sum = Arrays.stream(A).sum();
        if(sum % 3 != 0) return false;
        int aver = sum / 3;
        int i = 1, j = A.length - 2, left = A[0], right = A[A.length-1];
        while (i < A.length && left != aver) {
            left += A[i++];
        }
        while (j >= 0 && right != aver) {
            right += A[j--];
        }
        return i <= j;
    }
}
