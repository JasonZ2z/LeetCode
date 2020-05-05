package com.xinzhe.order.day12;

/**
 * @Author Xin
 * @create 2020/5/3
 * Title :
 * Description :
 * link :
 * Level :
 */
public class Leetcode_weekly_18702 {
    public static void main(String[] args) {
        int[] num = {0,1,0,1,0,0,1,1};
        System.out.println(kLengthApart(num, 2));
    }
    public static boolean kLengthApart(int[] nums, int k) {
        int n = nums.length;
        int i = 0;
        while(i < n) {
            if(i == 0) {
                i++;
            } else {
                i++;
                break;
            }
        }
        int tmp = 0;
        while (i < n) {
            if(nums[i] == 0) {
                tmp++;
            } else {
                if(tmp < k) {
                    return false;
                }
                tmp = 0;
            }
            i++;
        }
        return true;
    }
}
