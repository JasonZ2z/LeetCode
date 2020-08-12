package com.xinzhe.contest.weekly.season04.weekly154;

/**
 * @author Xin
 * @date 2020/7/28
 * Title : 1191. K 次串联后最大子数组之和
 * Description : 给你一个整数数组 arr 和一个整数 k。首先，我们要对该数组进行修改，即把原数组 arr 重复 k 次。
 *              举个例子，如果 arr = [1, 2] 且 k = 3，那么修改后的数组就是 [1, 2, 1, 2, 1, 2]。然后，请你返回修改后的数组中的最大的子数组之和。
 *              注意，子数组长度可以是 0，在这种情况下它的总和也是 0。 由于 结果可能会很大，所以需要 模（mod） 10^9 + 7 后再返回。 
 * link : https://leetcode-cn.com/problems/k-concatenation-maximum-sum
 * Level : Medium
 */
//todo need to review
public class Leetcode_weekly_15403 {
    // 1 -3 1
    // 1 -3 1 1 -3 1
    public static void main(String[] args) {
        Leetcode_weekly_15403 lc = new Leetcode_weekly_15403();
        int[] arr = {-5,-1,5,1,2,3,4};
        System.out.println(lc.kConcatenationMaxSum(arr, 3));
    }
    static final int MOD = (int)1e9 + 7;
    public int kConcatenationMaxSum(int[] arr, int k) {
        int n = arr.length;
        long max = 0, cur = 0, pre = 0, suf = 0, sum = 0;
        for (int item : arr) {
            max = Math.max(max + item, item);
            cur = Math.max(cur, max);
        }
        if(k == 1) return (int) (cur % MOD);
        for (int value : arr) {
            sum += value;
            pre = Math.max(pre, sum);
        }
        sum = 0;
        for(int i = n-1; i >= 0; --i) {
            sum += arr[i];
            suf = Math.max(sum, suf);
        }
        long res = Math.max(cur, Math.max(sum * (k - 2) + pre + suf, pre + suf));
        return (int) (res % MOD);
    }
}
