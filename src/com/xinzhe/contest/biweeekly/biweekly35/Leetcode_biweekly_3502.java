package com.xinzhe.contest.biweeekly.biweekly35;

import java.util.Arrays;

/**
 * @author Xin
 * @date 2020/9/19
 * Title : 1589. 所有排列中的最大和
 * Description : 有一个整数数组 nums ，和一个查询数组 requests ，其中 requests[i] = [starti, endi] 。
 *              第 i 个查询求 nums[starti] + nums[starti + 1] + ... + nums[endi - 1] + nums[endi] 的结果 ，starti 和 endi 数组索引都是 从 0 开始 的。
 *              你可以任意排列 nums 中的数字，请你返回所有查询结果之和的最大值。 由于答案可能会很大，请你将它对 109 + 7 取余 后返回。
 * link : https://leetcode-cn.com/problems/maximum-sum-obtained-of-any-permutation
 * Level : Medium
 */

//todo need to review

/** 差分数组
 * 用一个 freq 数组，对于每一个 request[start, end]，都进行 freq[start] ++ 和 freq[end + 1] -- 操作。
 * 之后，freq[0...i] 的数字和，就是 i 这个索引的查询次数。
 */
public class Leetcode_biweekly_3502 {
    public static void main(String[] args) {
        Leetcode_biweekly_3502 lc = new Leetcode_biweekly_3502();
        int[] n = {1,2,3,4,5};
        int[][] r = {{1,3}, {0,1}};
        System.out.println(lc.maxSumRangeQuery(n, r));
    }
    public int maxSumRangeQuery(int[] nums, int[][] requests) {
        int n = nums.length;
        int[] freq = new int[n+1];
        for(int[] re : requests) {
            int from = re[0], to = re[1];
            freq[from]++;
            freq[to + 1]--;
        }
        for(int i=1; i<=n; i++) {
            freq[i] += freq[i-1];
        }
        Arrays.sort(freq);
        Arrays.sort(nums);
        long ans = 0;
        int mod = (int)1e9 +7;
        for(int i = n; i > 0 && freq[i] > 0; i--) {
            ans += freq[i] * nums[i-1];
        }
        return (int)(ans % mod);
    }
}
