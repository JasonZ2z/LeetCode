package com.xinzhe.contest.weekly.season03.weekly129;

/**
 * @author Xin
 * @date 2020/9/18
 * Title : 1015. 可被 K 整除的最小整数
 * Description :  给定正整数 K，你需要找出可以被 K 整除的、仅包含数字 1 的最小正整数 N。 返回 N 的长度。如果不存在这样的 N，就返回 -1。
 * link : https://leetcode-cn.com/problems/smallest-integer-divisible-by-k/
 * Level : Medium
 */
//todo need to review
public class Leetcode_weekly_12902 {
    public static void main(String[] args) {
        Leetcode_weekly_12902 lc = new Leetcode_weekly_12902();
    }

    //(n*10+1)%K = ((n%K)*10+1)%K
    public int smallestRepunitDivByK(int k) {
        if(k % 2 == 0  || k % 5 == 0) return -1;
        int n = 1, len = 1;
        while( n % k != 0) {
            n %= k;
            n = n * 10 + 1;
            len++;
        }
        return len;
    }
}
