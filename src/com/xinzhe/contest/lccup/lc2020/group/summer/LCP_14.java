package com.xinzhe.contest.lccup.lc2020.group.summer;

import java.util.Arrays;

/**
 * @author Xin
 * @date 2020/4/25 14:56
 * Title : LCP 14. 切分数组
 * Description : 给定一个整数数组 nums ，小李想将 nums 切割成若干个非空子数组，使得每个子数组最左边的数和最右边的数的最大公约数大于 1 。为
 *              了减少他的工作量，请求出最少可以切成多少个子数组。
 * link : https://leetcode-cn.com/problems/qie-fen-shu-zu
 * Level : Hard
 * Comment 2020-spring-group-04
 */

//todo undo
public class LCP_14 {
    public static void main(String[] args) {
        LCP_14 lt = new LCP_14();
        lt.init();
        System.out.println();
    }
    public int splitArray(int[] nums) {
        int n = nums.length;
        if (n == 1) return 1;
        if (n == 2) return gcd(nums[0], nums[1]) > 1 ? 1 : 2;
        int[] dp = new int[n+1];
        for (int i = 0; i <= n; ++i) {
            dp[i] = i;
        }
        for (int i = 2; i <= n; ++i) {
            for(int j = i-1; j > 0; --j) {
                if(gcd(nums[i-1], nums[j-1]) > 1) {
                    dp[i] = Math.min(dp[i], dp[j-1] + 1);
                }
            }
            dp[i] = Math.min(dp[i], dp[i-1] + 1);
        }
        return dp[n];

    }
    private int[] minPrime = new int[100 + 1];
    private void init() {
        for (int i = 2; i < minPrime.length; i++) {
            if (minPrime[i] < 2) {
                for (int j = i; j < minPrime.length; j += i) {
                    minPrime[j] = i;
                }
                System.out.println(Arrays.toString(minPrime));
            }
        }
    }
    public int gcd(int m, int n) {
        int result;
        while (n != 0) {
            result = m % n;
            m = n;
            n = result;
        }
        return m;
    }
}
