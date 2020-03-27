package com.xinzhe.categories.dp.math;

/**
 * @Author Xin
 * @create 2020/3/27 20:55
 * Title : 650. 只有两个键的键盘
 * Description : 最初在一个记事本上只有一个字符 'A'。你每次可以对这个记事本进行两种操作：
 *              Copy All (复制全部) : 你可以复制这个记事本中的所有字符(部分的复制是不允许的)。
 *              Paste (粘贴) : 你可以粘贴你上一次复制的字符。
 *              给定一个数字 n 。你需要使用最少的操作次数，在记事本中打印出恰好 n 个 'A'。输出能够打印出 n 个 'A' 的最少操作次数。
 * link : https://leetcode-cn.com/problems/2-keys-keyboard
 * Level : Medium
 * Comment :
 */

public class Leetcode650 {

    public int minSteps(int n) {
        if(n == 0) return 0;

        int[] dp = new int[n+1];

        dp[1] = 0;
        dp[2] = 2;

        for (int i = 3; i <= n; ++i) {
            dp[i] = i;
            for (int j = 2; j < i ; ++j) {
                if(i%j == 0){
                    dp[i] = Math.min(dp[i], dp[j] + i/j);
                }

            }
        }
        return dp[n];
    }
}
