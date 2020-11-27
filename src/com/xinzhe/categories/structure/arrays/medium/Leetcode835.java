package com.xinzhe.categories.structure.arrays.medium;

/**
 * @author Xin
 * @date 2020/4/22
 * Title : 835. 图像重叠
 * Description : 给出两个图像 A 和 B，A 和 B为大小相同的二维正方形矩阵。（并且为二进制矩阵，只包含0和1）。
 *              我们转换其中一个图像，向左，右，上，或下滑动任何数量的单位，并把它放在另一个图像的上面。之后，该转换的重叠是指两个图像都具有 1 的位置的数目。
 * （            请注意，转换不包括向任何方向旋转。）最大可能的重叠是什么？
 * link : https://leetcode-cn.com/problems/image-overlap
 * Level : Medium
 */

public class Leetcode835 {
    public int largestOverlap(int[][] A, int[][] B) {
        int n = A.length;
        int ans = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                ans = Math.max(ans, Math.max(check(A, B, i, j), check(B,A,i,j)));
            }
        }

        for(int i=n-1; i>=0; i--) {
            for(int j=0; j<n; j++) {
                ans = Math.max(ans, Math.max(check2(A, B, i, j), check2(B, A, i, j)));
            }
        }
        return ans;
    }

    private int check(int[][] A, int[][] B, int x, int y) {
        int cnt = 0;
        int n = A.length;
        for(int i=x; i<n; i++){
            for(int j=y; j<n; j++) {
                if(A[i][j]==1 && A[i][j] == B[i-x][j-y]) cnt++;
            }
        }
        return cnt;
    }
    private int check2(int[][] A, int[][] B, int x, int y) {
        int cnt = 0;
        int n = A.length;
        for(int i=x; i>=0; i--){
            for(int j=y; j<n; j++) {
                if(A[i][j]==1 && A[i][j] == B[i + n - x - 1][j-y]) cnt++;
            }
        }
        return cnt;
    }
}
