package com.xinzhe.contest.biweeekly.biweekly22;

/**
 * @author Xin
 * @date 2020/4/18 22:16
 * Title : 1385. 两个数组间的距离值
 * Description : 给你两个整数数组 arr1 ， arr2 和一个整数 d ，请你返回两个数组之间的 距离值 。
 *              「距离值」 定义为符合此描述的元素数目：对于元素 arr1[i] ，不存在任何元素 arr2[j] 满足 |arr1[i]-arr2[j]| <= d 。
 * link : https://leetcode-cn.com/problems/minimum-value-to-get-positive-step-by-step-sum
 * Level : Easy
 * Comment : 22双周赛01
 */
public class Leetcode_biweekly_2201 {
    public static void main(String[] args) {
        int[] a = {4,5,8};
        int[] b = {10,9,1,8};
        System.out.println(findTheDistanceValue(a,b,2));

    }
    public static int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int res = 0;
        int n = arr2.length;
        for (int value : arr1) {
            int count = 0;
            for (int i : arr2) {
                if (Math.abs(value - i) > d) {
                    count++;
                }
            }
            if (count == n) {
                res++;
            }
        }
        return res;
    }
}
