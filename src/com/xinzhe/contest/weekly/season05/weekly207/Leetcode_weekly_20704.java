package com.xinzhe.contest.weekly.season05.weekly207;

import java.util.Arrays;
import java.util.List;

/**
 * @author Xin
 * @date 2020/9/20
 * Title : 1595. 连通两组点的最小成本
 * Description : 给你两组点，其中第一组中有 size1 个点，第二组中有 size2 个点，且 size1 >= size2 。
 *              任意两点间的连接成本 cost 由大小为 size1 x size2 矩阵给出，其中 cost[i][j] 是第一组中的点 i 和第二组中的点 j 的连接成本。如果两个组中的每个点都与另一组中的一个或多个点连接，则称这两组点是连通的。
 *              换言之，第一组中的每个点必须至少与第二组中的一个点连接，且第二组中的每个点必须至少与第一组中的一个点连接。 返回连通两组点所需的最小成本。
 * link : https://leetcode-cn.com/problems/minimum-cost-to-connect-two-groups-of-points
 * Level : Hard
 */

//todo too hard to solve
public class Leetcode_weekly_20704 {
    public static void main(String[] args) {
        Leetcode_weekly_20704 lc = new Leetcode_weekly_20704();
        //int[][] arr = {{0,0,0,0,0},{1,0,0,0,0},{0,1,0,0,0},{0,0,1,0,0},{0,0,0,1,1}};
        int[][] arr = {{0,0},{0,0},{1,0}};
    }

    public int connectTwoGroups(List<List<Integer>> cost) {
        int m = cost.size();
        int n = cost.get(0).size();
        int msk = 1 << m;
        int[] dp = new int[msk];
        for (int i = 0; i < msk; i++) dp[i] = Integer.MAX_VALUE;
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            int[] tmp = new int[msk];
            Arrays.fill(tmp, Integer.MAX_VALUE);
            // tmp[0] = 0; // you can not leave the previous lines without connections.
            for (int k = 0; k < msk; k++) {
                for (int j = 0; j < m; j++) {
                    int mask = k | (1 << j);
                    if (dp[k] != Integer.MAX_VALUE) tmp[mask] = Math.min(tmp[mask], dp[k] + cost.get(j).get(i));
                    if ((k & (1 << j)) == 0) {
                        if (tmp[k] != Integer.MAX_VALUE)  tmp[mask] = Math.min(tmp[mask], tmp[k] + cost.get(j).get(i));
                    }
                }
            }
            dp = tmp;
        }
        return dp[msk - 1];
    }


    public int connectTwoGroups2(List<List<Integer>> cost) {
        int m = cost.size();
        int n = cost.get(0).size();
        // to make sure each element in group1 is connected
        // the size of this array needs to 2 ^ m
        // reason to choose the 1 << m is because m is greater than n
        // and you have to aim for connecting all the elements of group1 (i.e., size1)
        // finally we want to see 2 ^ m (i.e., to 2 ^ m -1) represented in that dp array
        // and each entry of dp will hold the best cost to achieve that.
        int[] dp = new int[1 << m];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;
        // look from the column stand point - since the mask takes care of the row side
        for(int col = 0; col < n; col++){
            // temp to hold results and switch back
            int[] tmp = new int[(1 << m)];
            Arrays.fill(tmp, Integer.MAX_VALUE);

            // for each element in the size 1 (group1)
            for(int row = 0; row < m; row++){

                for(int msk = 0; msk < (1 << m); msk++){

                    // consider the effect of connecting row with col
                    // with existing situation that msk represents the other connections
                    int newmsk = msk | (1 << row);

                    // populate newmsk considering previously known info from dp
                    if (dp[msk] != Integer.MAX_VALUE)
                        tmp[newmsk] = Math.min(tmp[newmsk], dp[msk] + cost.get(row).get(col));

                    // use current information on msk if known - if mask does not have row used already
                    // set the current newmsk to better of existing OR msk + connecting(row, col)
                    if ((msk & (1 << row)) == 0)
                        if (tmp[msk] != Integer.MAX_VALUE)
                            tmp[newmsk] = Math.min(tmp[newmsk], tmp[msk] + cost.get(row).get(col));

                }

            }
            // set dp to hold the results of previous iteration
            dp = tmp;
            //System.out.println("col = " + col );
            //printA(dp);
        }
        return dp[(1 << m) - 1];
    }
    private void printA(int[] a){
        for(int i = 0; i < a.length; i++){
            System.out.print(", " + a[i]);
            if (i != 0 && i % 10 == 0)
                System.out.println();
        }
        System.out.println();
    }
}
