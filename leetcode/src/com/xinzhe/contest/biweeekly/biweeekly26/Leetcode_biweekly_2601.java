package com.xinzhe.contest.biweeekly.biweeekly26;

/**
 * @Author Xin
 * @create 2020/5/16
 * Title :
 * Description :
 * link :
 * Level :
 */
public class Leetcode_biweekly_2601 {
    public int maxPower(String s) {
        int max = 0;
        char[] arr = s.toCharArray();
        int n = arr.length;
        if (n == 1) return 1;
        int cur = arr[0];
        int count = 1;
        for (int i = 1; i < arr.length; i++) {
            if (cur == arr[i]) {
                count++;
                max = Math.max(count, max);
            } else {
                cur = arr[i];
                count = 1;
            }
        }
        return max;
    }

}
