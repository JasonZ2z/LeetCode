package com.xinzhe.contest.weekly.season05.weekly216;

/**
 * @author Xin
 * @date 2020/11/22
 * Title : 1664. 生成平衡数组的方案数
 * Description : 给你一个整数数组nums。你需要选择 恰好一个下标（下标从 0开始）并删除对应的元素。请注意剩下元素的下标可能会因为删除操作而发生改变。
 *              比方说，如果nums = [6,1,7,4,1]，那么：选择删除下标 1 ，剩下的数组为nums = [6,7,4,1]。
 *              选择删除下标2，剩下的数组为nums = [6,1,4,1]。 选择删除下标4，剩下的数组为nums = [6,1,7,4]。
 *              如果一个数组满足奇数下标元素的和与偶数下标元素的和相等，该数组就是一个 平衡数组 。请你返回删除操作后，剩下的数组nums是平衡数组 的方案数。
 * link : https://leetcode-cn.com/problems/ways-to-make-a-fair-array
 * Level : Medium
 */
public class Leetcode_weekly_21603 {
    public static void main(String[] args) {
        Leetcode_weekly_21603 lc = new Leetcode_weekly_21603();
        int[] arr = {2,1,6,4};
        System.out.println(lc.waysToMakeFair(arr));
    }

    public int waysToMakeFair(int[] nums) {
        int n = nums.length;
        int[] preEven = new int[n];
        int[] preOdd = new int[n];
        preEven[0] = nums[0];
        preOdd[1] = nums[1];
        for (int i = 2; i < n; i++) {
            if(i % 2 ==  0) {
                preEven[i] = preEven[i-2] + nums[i];
            } else {
                preOdd[i] = preOdd[i-2] + nums[i];
            }
        }
        int lastEven;
        int lastOdd;
        if(n % 2 == 0) {
            lastEven = preEven[n-2];
            lastOdd = preOdd[n-1];
        } else {
            lastEven = preEven[n-1];
            lastOdd = preOdd[n-2];
        }
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            int x, y;
            if(i % 2 == 0) {
                x = (i >= 1 ? preOdd[i-1] : 0) + lastEven - preEven[i];
                y = (i >= 2 ? preEven[i-2] : 0 ) + lastOdd -  (i > 0 ? preOdd[i-1] : 0);
            } else {
                x = (i >= 2 ? preOdd[i-2] : 0 ) + lastEven - preEven[i-1];
                y = preEven[i-1] + lastOdd - preOdd[i];
            }
            if(x ==y) cnt++;
        }
        return cnt;

    }


    public int waysToMakeFair2(int[] nums) {
        int n = nums.length;
        int[] a = new int[n+1];
        int[] b = new int[n+1];

        for(int i = 0; i < n; ++i){
            a[i+1] = nums[i] - a[i];
            b[i+1] = nums[n - 1 - i] - b[i];
        }

        int res = 0;
        for(int i = 0; i < n; ++i){
            if(a[i] == b[n-i - 1]){
                ++res;
            }
        }
        return res;
    }
}
