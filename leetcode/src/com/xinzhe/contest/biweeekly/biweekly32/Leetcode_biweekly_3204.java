package com.xinzhe.contest.biweeekly.biweekly32;

import java.util.Arrays;

/**
 * @Author Xin
 * @create 2020/8/8
 * Title :
 * Description :
 * link :
 * Level :
 */
public class Leetcode_biweekly_3204 {
    public static void main(String[] args) {
        Leetcode_biweekly_3204 lc = new Leetcode_biweekly_3204();
        System.out.println(lc.longestAwesome("3242415"));
    }

    public int longestAwesome(String s) {
        int n = s.length();
        int res = 0;
        char[] s1 = s.toCharArray();
        for (int i = 0; i < n-1; ++i) {
            int[] arr = new int[10];
            int l = i, r = i;
            while (l >= 0 && r < n) {
                arr[s1[l] - '0']++;
                arr[s1[r] - '0']++;
                if(helper(arr)) {
                    res = Math.max(res, r - l + 1);
                    l--;
                    r++;

                }else {
                    break;
                }
            }
            l = i;
            r = i + 1;
            Arrays.fill(arr, 0);
            while (l >= 0 && r < n) {
                arr[s1[l] - '0']++;
                arr[s1[r] - '0']++;
                if(helper(arr)) {
                    l--;
                    r++;
                    res = Math.max(res, r - l + 1);
                }else {
                    break;
                }
            }
        }
        return res;

    }

    private boolean helper(int[] arr) {
        int count = 0;
        for (int i : arr) {
            count += i&1;
            if(count > 1) {
                return false;
            }
        }
        return true;
    }


}
