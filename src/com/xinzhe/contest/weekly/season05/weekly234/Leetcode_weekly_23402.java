package com.xinzhe.contest.weekly.season05.weekly234;

/**
 * @author Xin
 * @date 2021/03/28
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_weekly_23402 {
    public static void main(String[] args) {
        Leetcode_weekly_23402 lc = new Leetcode_weekly_23402();
        System.out.println(lc.reinitializePermutation(6));
    }

    int n;
    int[] perm;
    public int reinitializePermutation(int n) {
        this.n = n;
        this.perm = new int[n];
        for (int i = 0; i < n; i++) {
            perm[i] = i;
        }
        int count = 1;
        while(!check(helper(perm))) {
            count++;
        }
        return count;
    }

    private int[] helper(int[] perm) {
        int[] arr = new int[n];
//        System.arraycopy(perm, 0, tmp, 0, n);
        for (int i = 0; i < n; ++i) {
            if(i % 2 == 0) {
                arr[i] = perm[i/2];
            } else {
                arr[i] = perm[n / 2 + (i - 1) / 2];
            }
        }
        this.perm = arr;
        return arr;
    }

    private boolean check(int[] arr) {
        for (int i = 0; i < n; i++) {
            if(i != arr[i]) return false;
        }
        return true;
    }

}
