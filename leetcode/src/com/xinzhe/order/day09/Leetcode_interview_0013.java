package com.xinzhe.order.day09;

/**
 * @author Xin
 * @date 2020/4/8 14:56
 * Title : 59. 螺旋矩阵 II
 * Description : 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
 *              一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
 *              例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 * link : https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/
 * Level : Medium
 */

public class Leetcode_interview_0013 {

    private int[][] direction = {{1, 0, -1, 0},{0, 1, 0, -1}};
    private int count = 0;
    public int movingCount(int m, int n, int k) {
        boolean[][] arr = new boolean[m][n];
        if(k == 0) return 1;
        dfs(0,0, k, arr);
        return count;
    }

    private void dfs(int x, int y, int k, boolean[][] arr) {
        if(getSum(x, y) <= k){
            count++;
            arr[x][y] = true;
            for (int i = 0; i < 4; ++i) {
                int newX = x + direction[0][i];
                int newY = y + direction[1][i];
                if(newX < 0 || newX >= arr.length || newY < 0 || newY >= arr[0].length || arr[newX][newY]){
                    continue;
                }
                dfs(newX, newY, k, arr);
            }
        }
    }

    private int getSum(int p, int q) {
        int sum1=0, sum2 = 0;
        while (p >0){
            sum1 += p % 10;
            p /= 10;
        }
        while (q >0){
            sum2 += q % 10;
            q /= 10;
        }
        return sum1 + sum2;
    }
}
