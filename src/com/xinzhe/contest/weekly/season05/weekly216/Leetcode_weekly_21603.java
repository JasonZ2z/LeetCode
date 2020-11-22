package com.xinzhe.contest.weekly.season05.weekly216;

/**
 * @author Xin
 * @date 2020/11/22
 * Title :
 * Description :
 * link :
 * Level :
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
}
