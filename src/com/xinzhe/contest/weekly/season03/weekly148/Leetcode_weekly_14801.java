package com.xinzhe.contest.weekly.season03.weekly148;

/**
 * @author Xin
 * @date 2020/10/3
 * Title : 1144. 递减元素使数组呈锯齿状
 * Description : 给你一个整数数组 nums，每次 操作 会从中选择一个元素并 将该元素的值减少 1。如果符合下列情况之一，则数组 A 就是 锯齿数组：
 *              每个偶数索引对应的元素都大于相邻的元素，即 A[0] > A[1] < A[2] > A[3] < A[4] > ...
 *              或者，每个奇数索引对应的元素都大于相邻的元素，即 A[0] < A[1] > A[2] < A[3] > A[4] < ...
 *              返回将数组 nums 转换为锯齿数组所需的最小操作次数。
 * link : https://leetcode-cn.com/problems/decrease-elements-to-make-array-zigzag
 * Level : Medium
 */

//todo need review
public class Leetcode_weekly_14801 {
    public static void main(String[] args) {
        Leetcode_weekly_14801 lc = new Leetcode_weekly_14801();
    }
    public int movesToMakeZigzag(int[] nums) {
        int n = nums.length;
        if(n == 1) return 0;
        int odd = 0, even = 0;
        for (int i = 0; i < n; i++) {
            int left = i-1, right = i+1;
            int x = left >= 0 ? Math.max(nums[i] - nums[left] + 1, 0) : 0;
            int y = right < n ? Math.max(nums[i] - nums[right] + 1, 0) : 0;
            if(i % 2 == 0) {
                even += Math.max(x, y);
            } else {
                odd += Math.max(x, y);
            }
        }
        return Math.min(even, odd);
    }
}
