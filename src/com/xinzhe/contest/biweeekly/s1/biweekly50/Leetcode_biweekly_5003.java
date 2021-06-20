package com.xinzhe.contest.biweeekly.s1.biweekly50;

import java.util.Arrays;

/**
 * @author Xin
 * @date 2021/04/17
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_biweekly_5003 {
    public static void main(String[] args) {
        Leetcode_biweekly_5003 lc = new Leetcode_biweekly_5003();
        int[] n1 = {0,1,1,3}; int m1= 2;
        int[] n2 = {2,3,4,7}; int m2= 3;
        int[] n3 = {0,1,2,2,5,7}; int m3= 3;
        System.out.println(Arrays.toString(lc.getMaximumXor(n1, m1)));
        System.out.println(Arrays.toString(lc.getMaximumXor(n2, m2)));
        System.out.println(Arrays.toString(lc.getMaximumXor(n3, m3)));
    }
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int n = nums.length;
        int[] res =  new int[n];
        int pre = 0;
        for (int i = 0; i < n; i++) {
            int x = nums[i] ^ pre;
            int bit = 0;
            int z = 0;
            while (bit < maximumBit) {
                if(((x >> bit) & 1) != 1) {
                    z |= 1 << bit;
                }
                bit++;
            }
            res[n - i -1] = z;
            pre = x;
        }
        return res;
    }
}