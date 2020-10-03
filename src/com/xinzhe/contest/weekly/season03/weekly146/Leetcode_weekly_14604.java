package com.xinzhe.contest.weekly.season03.weekly146;

/**
 * @author Xin
 * @date 2020/9/28
 * Title :  1131. 绝对值表达式的最大值
 * Description : 给你两个长度相等的整数数组，返回下面表达式的最大值：
 *              |arr1[i] - arr1[j]| + |arr2[i] - arr2[j]| + |i - j| 其中下标 i，j 满足 0 <= i, j < arr1.length。
 * link : https://leetcode-cn.com/problems/maximum-of-absolute-value-expression
 * Level : Medium
 */

//todo need to review
public class Leetcode_weekly_14604 {
    public int maxAbsValExpr(int[] arr1, int[] arr2) {
        int res = Integer.MIN_VALUE;
        for (int j = 0; j < 1 << 3; ++j) {
            int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
            for (int i = 0; i < arr1.length; i++) {
                int cur =  (j & 1) != 0 ? -arr1[i] : arr1[i]
                        + (j & 2) != 0 ? arr2[i] : -arr2[i]
                        + (j & 4) != 0 ? i : -i;
                max = Math.max(max, cur);
                min = Math.min(min, cur);
            }
            res = Math.max(res, max - min);
        }
        return res;
    }
}
