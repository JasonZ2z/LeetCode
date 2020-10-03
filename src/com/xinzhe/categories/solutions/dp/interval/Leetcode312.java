package com.xinzhe.categories.solutions.dp.interval;

/**
 * @author Xin
 * @date 2020/9/24
 * Title : 312. 戳气球
 * Description : 有 n 个气球，编号为0 到 n-1，每个气球上都标有一个数字，这些数字存在数组 nums 中。
 *              现在要求你戳破所有的气球。如果你戳破气球 i ，就可以获得 nums[left] * nums[i] * nums[right] 个硬币。
 *              这里的 left 和 right 代表和 i 相邻的两个气球的序号。注意当你戳破了气球 i 后，气球 left 和气球 right 就变成了相邻的气球。求所能获得硬币的最大数量。
 * link : https://leetcode-cn.com/problems/burst-balloons
 * Level : Hard
 * comment : related problems : 312, 488
 */
//todo need to review
public class Leetcode312 {
    public static void main(String[] args) {
        int[] arr = {3,1,5,8};
        Leetcode312 lc = new Leetcode312();
        System.out.println(lc.maxCoins(arr));
        System.out.println(lc.maxCoins2(arr));
    }
    Integer[][] dp;
    int[] s;
    public int maxCoins(int[] nums) {
        int n = nums.length;
        dp = new Integer[n+2][n+2];
        s = new int[n+2];
        System.arraycopy(nums, 0, s, 1, n);
        s[0] = s[n + 1] = 1;
        return solve(0, n+1);
    }

    private int solve(int l, int r) {
        if(l > r) return 0;
        if(dp[l][r] != null) return dp[l][r];
        int ans = 0;
        for (int i = l + 1; i < r; ++i) {
            ans = Math.max(ans, s[l] * s[i] * s[r] + solve(l, i) + solve(i, r));
        }
        dp[l][r] = ans;
        return ans;
    }

    public int maxCoins2(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        int[][] dp = new int[n + 2][n + 2];
        // dp数组初始化为0
        int[] s = new int [n + 2];
        s[0] = s[n + 1] = 1;
        System.arraycopy(nums, 0, s, 1, n);
        for(int len = 1; len <= n; len++){
            for(int i = 1; i + len - 1 <= n; i++){
                int j = i + len - 1;
                for(int k = i; k <= j; k++){
                    dp[i][j] = Math.max(dp[i][j],
                            dp[i][k - 1] + dp[k + 1][j] + s[i - 1] * s[k] * s[j + 1]);
                }
            }
        }
        return dp[1][n];
    }
}
