package com.xinzhe.categories.solutions.bitmanipulation.medium;

import java.util.Arrays;

/**
 * @Author Xin
 * @create 2020/8/12
 * Title : 1131. 绝对值表达式的最大值
 * Description : 给你两个长度相等的整数数组，返回下面表达式的最大值：|arr1[i] - arr1[j]| + |arr2[i] - arr2[j]| + |i - j|其中下标 i，j 满足 0 <= i, j < arr1.length。
 * link : https://leetcode-cn.com/problems/maximum-of-absolute-value-expression
 * Level : Medium
 */
public class Leetcode1131 {
    public static void main(String[] args) {
       int[] x = {1,-2,-5,0,10};
       int[] y = {0,-2,-1,-7,-4};
        Leetcode1131 lc = new Leetcode1131();
    }

    public int maxAbsValExpr(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int[] max = new int[8];
        Arrays.fill(max, Integer.MIN_VALUE);
        int[] min = new int[8];
        Arrays.fill(min, Integer.MAX_VALUE);
        int res = Integer.MIN_VALUE;
        for(int i=0; i< (1<<3); i++) {
            for(int j=0; j<n; j++){
                max[i] = Math.max(max[i],((1&(i>>2)) == 1 ? 1 : -1) * arr1[j]
                        + ((1&(i>>1)) == 1 ? 1 : -1) * arr2[j]
                        + ((1& i) == 1 ? 1 : -1) * j);

                min[i] = Math.min(min[i],((1&(i>>2)) == 1 ? 1 : -1) * arr1[j]
                        + ((1&(i>>1)) == 1 ? 1 : -1) * arr2[j]
                        + ((1& i) == 1 ? 1 : -1) * j);
            }
            res = Math.max(res, max[i] - min[i]);
        }
        return res;
    }
}
