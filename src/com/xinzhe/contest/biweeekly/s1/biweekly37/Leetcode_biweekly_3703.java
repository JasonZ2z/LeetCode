package com.xinzhe.contest.biweeekly.s1.biweekly37;

import java.math.BigInteger;

/**
 * @author Xin
 * @date 2020/10/17
 * Title : 1621. 大小为 K 的不重叠线段的数目
 * Description : 给你一维空间的 n 个点，其中第 i 个点（编号从 0 到 n-1）位于 x = i 处，请你找到 恰好 k 个不重叠 线段且每个线段至少覆盖两个点的方案数。
 *              线段的两个端点必须都是 整数坐标 。这 k 个线段不需要全部覆盖全部 n 个点，且它们的端点 可以 重合。
 *              请你返回 k 个不重叠线段的方案数。由于答案可能很大，请将结果对 109 + 7 取余 后返回。
 * link : https://leetcode-cn.com/problems/number-of-sets-of-k-non-overlapping-line-segments
 * Level : Medium
 */
//todo need to review
public class Leetcode_biweekly_3703 {
    public static void main(String[] args) {
        Leetcode_biweekly_3703 lc = new Leetcode_biweekly_3703();
        System.out.println(lc.numberOfSets(4, 2));
    }
    static final int MOD = (int)1e9 + 7;
    BigInteger mod = BigInteger.valueOf(MOD);
    public int numberOfSets(int N, int K) {
        long[][] dp = new long[K + 1][N];
        dp[0][0] = 1;
        for (int k = 1; k <= K; k++) {
            long sum = 1;
            for (int j = k; j != N; j++) {
                dp[k][j] = (dp[k][j - 1] + sum) % MOD;
                sum = (sum + dp[k - 1][j]) % MOD;
            }
        }
        long res = 0; // we will add up segments of K, that ending at any position.
        for (int i = 0; i != N; i++)
            res = (res + dp[K][i]) % MOD;
        return (int) res;
    }

    // C(n + k -1, k * 2);
    public int numberOfSets2(int n, int k) {
        long[] f = new long[2 * n];
        f[0] = 1;
        for (int i = 1; i < 2 * n; i++) {
            f[i] = i * f[i - 1] %  MOD;
        }
        return (int) (f[k + n - 1]
                * BigInteger.valueOf(f[n - k - 1]).modInverse(mod).longValue() %  MOD
                * BigInteger.valueOf(f[2 * k]).modInverse(mod).longValue() %  MOD);
    }
}
