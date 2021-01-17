package com.xinzhe.contest.weekly.season05.weekly223;

/**
 * @author Xin
 * @date 2021/01/10
 * Title : 1720. 解码异或后的数组
 * Description : 未知 整数数组 arr 由 n 个非负整数组成。
 *              经编码后变为长度为 n - 1 的另一个整数数组 encoded ，其中 encoded[i] = arr[i] XOR arr[i + 1] 。例如，arr = [1,0,2,1] 经编码后得到 encoded = [1,2,3] 。
 *              给你编码后的数组 encoded 和原数组 arr 的第一个元素 first（arr[0]）。
 *              请解码返回原数组 arr 。可以证明答案存在并且是唯一的。
 * link : https://leetcode-cn.com/problems/decode-xored-array
 * Level : Easy
 */
public class Leetcode_weekly_22301 {
    public static void main(String[] args) {
        Leetcode_weekly_22301 lc = new Leetcode_weekly_22301();
        int[] arr = {3,5};
    }
    public int[] decode(int[] encoded, int first) {
        int n = encoded.length;
        int len = n + 1;
        int[] arr = new int[len];

        arr[0] = first;

        for (int i = 1; i < arr.length; i++) {
            arr[i] = arr[i-1]^ encoded[i-1];
        }
        return arr;
    }
}
