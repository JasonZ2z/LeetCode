package com.xinzhe.contest.weekly.season05.weekly217;

/**
 * @author Xin
 * @date 2020/11/29
 * Title : 1674. 使数组互补的最少操作次数
 * Description : 给你一个长度为 偶数 n 的整数数组 nums 和一个整数 limit 。每一次操作，你可以将 nums 中的任何整数替换为1到limit 之间的另一个整数。
 *              如果对于所有下标 i（下标从 0 开始），nums[i] + nums[n - 1 - i]都等于同一个数，则数组 nums 是 互补的 。
 *              例如，数组 [1,2,3,4] 是互补的，因为对于所有下标i ，nums[i] + nums[n - 1 - i] = 5 。返回使数组 互补 的 最少操作次数。
 * link : https://leetcode-cn.com/problems/minimum-moves-to-make-array-complementary
 * Level : Medium
 */

//todo need to review
    //差分数组
    // [1,min+1) +2 [min+1,min+max)+1 [min+max]+0 (min+max,max+limit]+1 (max+limit,2*limit]+2
public class Leetcode_weekly_21703 {
    public static void main(String[] args) {
        Leetcode_weekly_21703 lc = new Leetcode_weekly_21703();
        int[] arr = {28,50,76,80,64,30,32,84,53,8};  //4
        System.out.println(lc.minMoves(arr, 84));
    }
    public int minMoves(int[] nums, int limit) {
        int[] cnt = new int[limit * 2 + 2];
        int n = nums.length;
        for (int i = 0; i < nums.length / 2; i++) {
            int max = Math.max(nums[i], nums[n-1-i]);
            int min = Math.min(nums[i], nums[n-1-i]);
            cnt[1] += 2;
            cnt[min + 1] -= 2;

            cnt[min + 1] += 1;
            cnt[min + max] -= 1;

            cnt[min + max + 1] += 1;
            cnt[max + limit + 1] -= 1;

            cnt[max + limit + 1] += 2;
            cnt[limit * 2 + 1] -= 2;
        }
        int res = n * 2;
        int cur = 0;
        for (int i = 1; i < cnt.length - 1; i++) {
            cur += cnt[i];
            res = Math.min(res, cur);
        }
        return res;
    }



}
