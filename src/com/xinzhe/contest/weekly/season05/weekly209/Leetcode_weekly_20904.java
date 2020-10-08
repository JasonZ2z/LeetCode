package com.xinzhe.contest.weekly.season05.weekly209;

/**
 * @author Xin
 * @date 2020/10/4
 * Title : 1611. 使整数变为 0 的最少操作次数
 * Description : 给你一个整数 n，你需要重复执行多次下述操作将其转换为 0 ：翻转 n 的二进制表示中最右侧位（第 0 位）。
 *              如果第 (i-1) 位为 1 且从第 (i-2) 位到第 0 位都为 0，则翻转 n 的二进制表示中的第 i 位。返回将 n 转换为 0 的最小操作次数。
 * link : https://leetcode-cn.com/problems/minimum-one-bit-operations-to-make-integers-zero
 * Level : Hard
 */
//todo undo
public class Leetcode_weekly_20904 {
    public static void main(String[] args) {
        Leetcode_weekly_20904 lc = new Leetcode_weekly_20904();
        System.out.println(lc.minimumOneBitOperations(333));
    }
    public int minimumOneBitOperations(int n) {
        int ans = 0;
        for (int i = 1; i <= n; i *= 2) {
            ans ^= n / i;
        }
        return ans;
    }
}
