package com.xinzhe.sword.chapter08;

import java.util.Arrays;

/**
 * @author Xin
 * @date 2020/7/14
 * Title : 08.13. 堆箱子
 * Description : 堆箱子。给你一堆n个箱子，箱子宽 wi、深 di、高 hi。箱子不能翻转，将箱子堆起来时，下面箱子的宽度、高度和深度必须大于上面的箱子。
 *              实现一种方法，搭出最高的一堆箱子。箱堆的高度为每个箱子高度的总和。输入使用数组[wi, di, hi]表示每个箱子。
 * link : https://leetcode-cn.com/problems/pile-box-lcci
 * Level : Hard
 */
public class Interview_0813 {
    public static void main(String[] args) {
        Interview_0813 lc = new Interview_0813();
    }
    public int pileBox(int[][] box) {
        int max = 0;
        int n = box.length;
        Arrays.sort(box, (a, b) -> a[0] == b[0] ? (a[1] == b[1] ? (a[2] - b[2]) : a[1] - b[1])  : a[0] - b[0]);
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = box[i][2];
            for(int j = i-1; j >= 0; --j) {
                if(box[i][0] > box[j][0] && box[i][1] > box[j][1] && box[i][2] > box[j][2]) {
                    dp[i] = Math.max(dp[i], dp[j] + box[i][2]);
                }
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
