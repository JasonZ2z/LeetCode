package com.xinzhe.contest.biweeekly.s1.biweekly47;

/**
 * @author Xin
 * @date 2021/03/06
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_biweekly_4702 {
    public static void main(String[] args) {
        Leetcode_biweekly_4702 lc = new Leetcode_biweekly_4702();
        int[] arr = {2, 4, 9, 3};
        int x = (int)1e7;
        System.out.println((int)Math.pow(3, 14));
        System.out.println((int)Math.pow(3, 15));
        System.out.println(lc.checkPowersOfThree(12));
        System.out.println(lc.checkPowersOfThree(91));
        System.out.println(lc.checkPowersOfThree(21));
    }
    int[] value = new int[15];
    boolean[] used = new boolean[15];
    public boolean checkPowersOfThree(int n) {
        value[0] = 1;
        for (int i = 1; i < 15; ++i) {
            value[i] = value[i-1] * 3;
        }
        return dfs(n, 14);
    }

    private boolean dfs(int n, int i) {
        if(n == 0) return true;
        if(n < 0) return false;
        for(int j = i; j >= 0; --j) {
            if(n >= value[j] && !used[j]) {
                used[j] = true;
                if(dfs(n - value[j], j - 1)) return true;
                used[j] = false;
            }
        }
        return false;
    }


}