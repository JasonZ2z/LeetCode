package com.xinzhe.contest.biweeekly.biweekly45;

/**
 * @author Xin
 * @date 2021/02/05
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_biweekly_4503 {
    public static void main(String[] args) {
        Leetcode_biweekly_4503 lc = new Leetcode_biweekly_4503();
        int[] arr = {2, 4, 9, 3};
    }
    public int minimumLength(String s) {
        int n = s.length();
        int l = 0, r = n-1;
        while (l < r) {
            char lc = s.charAt(l);
            char lr = s.charAt(r);
            if(lc == lr) {
                while (l < r && s.charAt(l) == lc) {
                    l++;
                }
                if(l == r) return 0;
                while (l < r && s.charAt(r) == lr) {
                    r--;
                }
            } else {
                break;
            }
        }
        return r - l + 1;
    }
}