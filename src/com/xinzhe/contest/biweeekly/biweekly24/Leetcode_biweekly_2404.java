package com.xinzhe.contest.biweeekly.biweekly24;

/**
 * @Author Xin
 * @create 2020/4/18 22:16
 * Title : 5375. 恢复数组
 * Description : 某个程序本来应该输出一个整数数组。但是这个程序忘记输出空格了以致输出了一个数字字符串，我们所知道的信息只有：数组中所有整数都在 [1, k] 之间，且数组中的数字都没有前导 0 。
 *              给你字符串 s 和整数 k 。可能会有多种不同的数组恢复结果。
 *              按照上述程序，请你返回所有可能输出字符串 s 的数组方案数。
 *              由于数组方案数可能会很大，请你返回它对 10^9 + 7 取余 后的结果。
 * link : https://leetcode-cn.com/problems/restore-the-array
 * Level : Hard
 * Comment : 24双周赛04
 */
public class Leetcode_biweekly_2404 {
    public static void main(String[] args) {

    }
    public int numberOfArrays(String s, int k) {
        int n = s.length();
        int[][] dp = new int[n][n];

        int size = (k+"").length();
        for (int i = 1; i < n; ++i) {
            for(int j = 0; j <= size; ++j) {
                int tmp = Integer.parseInt(s.substring(i-j, i+1));
                if(tmp <= k && tmp > 0) {
                    //todo
                }
            }
        }
        return 0;
    }

}
