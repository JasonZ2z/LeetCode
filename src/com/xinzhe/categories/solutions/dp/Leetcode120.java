package com.xinzhe.categories.solutions.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Xin
 * @date 2020/3/16 18:41
 * Title : 120. 三角形最小路径和
 * Description : 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 *
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 * link : https://leetcode-cn.com/problems/triangle
 * Level : Medium
 */
public class Leetcode120 {
    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(2));
        list.add(Arrays.asList(3,4));
        list.add(Arrays.asList(6,5,7));
        list.add(Arrays.asList(4,1,8,3));
        System.out.println(minimumTotal(list));
        System.out.println(minimumTotal2(list));

    }
    //压缩空间
    public static int minimumTotal2(List<List<Integer>> triangle) {
        if(triangle == null || triangle.get(0) == null) return 0;
        int m = triangle.size();
        int[] dp = new int[m];
        dp[0] = triangle.get(0).get(0);
        int pre = 0, cur;
        for (int i = 1; i < m; i++) {
            List<Integer> list = triangle.get(i);
            for (int j = 0; j < list.size(); j++) {
                cur = dp[j];
                if(j == 0) dp[j] = cur + list.get(0);
                else if(j == i) dp[j] = pre + list.get(i);
                else {
                    dp[j] = Math.min(cur, pre) + list.get(j);
                }
                pre = cur;
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            res = Math.min(dp[i], res);
        }
        return res;

    }
    public static int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.get(0) == null) return 0;
        int m = triangle.size();
        int n = triangle.get(m-1).size();
        int[][] dp = new int[m][n];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < m; i++) {
            for (int j = 0; j <= i; j++) {
                if(j == 0) dp[i][j] = dp[i-1][0] + triangle.get(i).get(j);
                else if(j == i) dp[i][j] = dp[i-1][j-1] + triangle.get(i).get(j);
                else {
                    dp[i][j] = Math.min(dp[i-1][j-1], dp[i-1][j]) + triangle.get(i).get(j);
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            res = Math.min(dp[m-1][i], res);
        }
        return res;
    }
}
