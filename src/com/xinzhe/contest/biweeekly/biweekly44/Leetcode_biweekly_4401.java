package com.xinzhe.contest.biweeekly.biweekly44;

/**
 * @author Xin
 * @date 2021/01/23
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_biweekly_4401 {
    public static void main(String[] args) {
        Leetcode_biweekly_4401 lc = new Leetcode_biweekly_4401();
        int[] arr = {2, 4, 9, 3};

    }

    public int largestAltitude(int[] gain) {
        int x = 0;
        int max = 0;
        for (int i : gain) {
            x += i;
            max = Math.max(max, x);
        }
        return max;
    }

}