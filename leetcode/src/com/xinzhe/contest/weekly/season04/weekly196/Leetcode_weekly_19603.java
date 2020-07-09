package com.xinzhe.contest.weekly.season04.weekly196;

/**
 * @Author Xin
 * @create 2020/7/5
 * Title :
 * Description :
 * link :
 * Level : Medium
 * Comment 196周赛03
 */
public class Leetcode_weekly_19603 {
    public static void main(String[] args) {
        Leetcode_weekly_19603 lc = new Leetcode_weekly_19603();
        int[][] mat = {{1,1,1,1,0,1,0},{1,1,1,0,0,0,1},{0,1,1,1,1,0,0},{1,1,0,1,1,0,1},{1,0,0,0,0,0,1},{1,1,0,1,1,1,1},{1,1,0,0,1,1,1}};
        System.out.println(lc.numSubmat(mat));
    }
    //todo undo
    public int numSubmat(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int[][] dpx = new int[m][n];
        int[][] dpy = new int[m][n];
        int[][] dpz = new int[m][n];
        int c = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if(mat[i][j] == 1) {
                    c++;
                    if(i == 0 || j == 0) {
                        if(j == 0) {
                            dpx[i][j] = 1;
                            dpy[i][j] = (i > 0 ? dpy[i-1][j] : 0) + 1;
                            dpz[i][j] = 0;
                        }
                        if (i == 0){
                            dpx[i][j] = (j > 0 ? dpx[i][j - 1] : 0) + 1;
                            dpy[i][j] = 1;
                            dpz[i][j] = 0;
                        }
                    } else {
                        dpx[i][j] = dpx[i][j - 1] + 1;
                        dpy[i][j] = dpy[i - 1][j] + 1;
                        if(mat[i-1][j] == 1 && mat[i][j-1] == 1 && mat[i-1][j-1] == 1) {
                            if(dpz[i-1][j] == 0 && dpz[i][j-1] == 0 ) {
                                dpz[i][j] =  1;
                            } else if(dpz[i-1][j] == 0 || dpz[i][j-1] == 0) {
                                dpz[i][j] = Math.max(dpz[i-1][j], dpz[i][j-1]) + 1;
                            } else {
                                dpz[i][j] = Math.min(dpz[i-1][j], dpz[i][j-1]) * 2;
                            }
                        }
                    }
                }
            }
        }
        int count = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                count += dpx[i][j] + dpy[i][j] + dpz[i][j];
            }
        }
        return count -c ;
    }
}
