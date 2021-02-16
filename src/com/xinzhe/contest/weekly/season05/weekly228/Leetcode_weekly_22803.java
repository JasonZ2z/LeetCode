package com.xinzhe.contest.weekly.season05.weekly228;

/**
 * @author Xin
 * @date 2021/02/07
 * Title : 1760. 袋子里最少数目的球
 * Description : 给你一个整数数组nums，其中nums[i]表示第i个袋子里球的数目。同时给你一个整数maxOperations。
 *              你可以进行如下操作至多maxOperations次：选择任意一个袋子，并将袋子里的球分到2 个新的袋子中，每个袋子里都有 正整数个球。
 *              比方说，一个袋子里有5个球，你可以把它们分到两个新袋子里，分别有 1个和 4个球，或者分别有 2个和 3个球。你的开销是单个袋子里球数目的 最大值，你想要最小化开销。
 *              请你返回进行上述操作后的最小开销。
 * link : https://leetcode-cn.com/problems/minimum-limit-of-balls-in-a-bag
 * Level : Medium
 */
//todo need to review
public class Leetcode_weekly_22803 {
    public static void main(String[] args) {
        Leetcode_weekly_22803 lc = new Leetcode_weekly_22803();
        int[] arr = {8,10,10,10};
        System.out.println(lc.minimumSize(arr, 5));
    }
    public int minimumSize(int[] nums, int maxOperations) {
        int l = 1, r = (int)1e9 + 7;
        while (l < r) {
            int mid = l + (r - l) /2;
            if(!check(nums, mid, maxOperations)) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }

    private boolean check(int[] nums, int mid, int maxOperations) {
        int res = 0;
        for (int num : nums) {
            res += (num - 1) / mid;
            if(res > maxOperations) return false;
        }
        return true;
    }
}
