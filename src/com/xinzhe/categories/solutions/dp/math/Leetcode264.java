package com.xinzhe.categories.solutions.dp.math;

/**
 * @author Xin
 * @date 2020/3/17 18:51
 * Title :264. 丑数 II
 * Description : 编写一个程序，找出第 n 个丑数。丑数就是只包含质因数 2, 3, 5 的正整数。
 * link : https://leetcode-cn.com/problems/ugly-number-ii/
 * Level : Medium
 */
public class Leetcode264 {
    //1, 2, 3, 4, 5, 6, 8, 9, 10, 12
    public int nthUglyNumber(int n) {
        int[] nums = new int[n];
        int i2=0, i3=0, i5=0;
        nums[0] = 1;
        for (int i = 1; i < n; i++) {
            int tmp = Math.min(Math.min(nums[i2] * 2, nums[i3] *3), nums[i5] * 5);
            nums[i] = tmp;
            if(tmp == nums[i2] * 2) i2++;
            if(tmp == nums[i3] * 3) i3++;
            if(tmp == nums[i5] * 5) i5++;

        }
        return nums[n-1];
    }
}
