package com.xinzhe.contest.weekly.season04.weekly201;

/**
 * @Author Xin
 * @create 2020/8/2
 * Title : 1534. 统计好三元组
 * Description : 给你一个整数数组 arr ，以及 a、b 、c 三个整数。请你统计其中好三元组的数量。如果三元组 (arr[i], arr[j], arr[k]) 满足下列全部条件，则认为它是一个 好三元组 。
 *          0 <= i < j < k < arr.length
 *          |arr[i] - arr[j]| <= a
 *          |arr[j] - arr[k]| <= b
 *          |arr[i] - arr[k]| <= c
 *          其中 |x| 表示 x 的绝对值。返回 好三元组的数量 。
 * link : https://leetcode-cn.com/problems/count-good-triplets
 * Level : Easy
 */
public class Leetcode_weekly_20102 {
    public static void main(String[] args) {
        Leetcode_weekly_20102 lc = new Leetcode_weekly_20102();
        System.out.println(lc.findKthBit(20, 1000000));
    }
    public char findKthBit(int n, int k) {
        String[] arr = new String[n+1];
        arr[0] = "";
        arr[1] = "0";

        for (int i = 2; i <= n; ++i) {
            arr[i] = arr[i-1] + "1" + invert(arr[i-1]);
        }

        return arr[n].charAt(k-1);
    }

    private String invert(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            sb.append(s.charAt(i) == '1' ? '0' : '1');
        }
        return sb.reverse().toString();

    }
}
