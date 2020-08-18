package com.xinzhe.contest.weekly.season03.weekly144;

/**
 * @author Xin
 * @date 2020/8/18
 * Title :
 * Description :
 * link :
 * Level : Easy
 */

public class Leetcode_weekly_14404 {
    public static void main(String[] args) {
        Leetcode_weekly_14404 lc = new Leetcode_weekly_14404();
    }
    public int[] maxDepthAfterSplit(String seq) {
        int n = seq.length();
        int[] res = new int[n];
        char[] arr = seq.toCharArray();
        int count = 0, i = 0;
        while(i < n) {
            if(arr[i] == '(') {
                count++;
                if((count&1) == 1) {
                    res[i] = 0;
                } else {
                    res[i] = 1;
                }
            } else {
                count--;
                if((count&1) == 1) {
                    res[i] = 1;
                } else {
                    res[i] = 0;
                }
            }
            i++;
        }
        return res;
    }
}
