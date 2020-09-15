package com.xinzhe.contest.lccup.spring2020;

import java.util.Arrays;

/**
 * @author Xin
 * @date 2020/9/15
 * Title : LCP 02. 分式化简
 * Description : ...
 * link : https://leetcode-cn.com/problems/deep-dark-fraction/
 * Level : Easy
 */
public class LCP_02 {
    public static void main(String[] args) {
        int[] arr = {3,2,0,2};
        LCP_02 lc = new LCP_02();
        System.out.println(Arrays.toString(lc.fraction(arr)));
    }
    public int[] fraction(int[] cont) {
        return dfs(cont, 0);
    }

    private int[] dfs(int[] cont, int index) {
        if(index == cont.length-1) return new int[]{cont[index], 1};
        int[] res = dfs(cont, index + 1);
        int x = res[0];
        int y = cont[index] * x + res[1];
        return new int[]{y, x};

    }
}
