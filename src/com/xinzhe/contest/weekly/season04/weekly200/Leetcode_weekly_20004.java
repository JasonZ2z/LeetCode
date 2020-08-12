package com.xinzhe.contest.weekly.season04.weekly200;

/**
 * @author Xin
 * @date 2020/8/2
 * Title : 1537. 最大得分
 * Description : 你有两个 有序 且数组内元素互不相同的数组 nums1 和 nums2 。一条 合法路径 定义如下：
 *              选择数组 nums1 或者 nums2 开始遍历（从下标 0 处开始）。从左到右遍历当前数组。
 *              如果你遇到了 nums1 和 nums2 中都存在的值，那么你可以切换路径到另一个数组对应数字处继续遍历（但在合法路径中重复数字只会被统计一次）。得分定义为合法路径中不同数字的和。
 *              请你返回所有可能合法路径中的最大得分。 由于答案可能很大，请你将它对 10^9 + 7 取余后返回。
 * link : https://leetcode-cn.com/problems/get-the-maximum-score
 * Level : Hard
 */
public class Leetcode_weekly_20004 {
    public static void main(String[] args) {
        Leetcode_weekly_20004 lc = new Leetcode_weekly_20004();
    }

    public int maxSum(int[] nums1, int[] nums2) {
        int i = 0, j = 0, n = nums1.length, m = nums2.length;
        long a = 0, b = 0, mod = (int)1e9 + 7;
        while (i < n || j < m) {
            if (i < n && (j == m || nums1[i] < nums2[j])) {
                a += nums1[i++];
            } else if (j < m && (i == n || nums1[i] > nums2[j])) {
                b += nums2[j++];
            } else {
                a = b = Math.max(a, b) + nums1[i];
                i++; j++;
            }
        }
        return (int)(Math.max(a, b) % mod);
    }
}
