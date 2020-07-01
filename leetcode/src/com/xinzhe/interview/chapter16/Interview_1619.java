package com.xinzhe.interview.chapter16;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author Xin
 * @create 2020/7/1
 * Title : 16.19. 水域大小
 * Description : 你有一个用于表示一片土地的整数矩阵land，该矩阵中每个点的值代表对应地点的海拔高度。
 *              若值为0则表示水域。由垂直、水平或对角连接的水域为池塘。池塘的大小是指相连接的水域的个数。编写一个方法来计算矩阵中所有池塘的大小，返回值需要从小到大排序。
 * link : https://leetcode-cn.com/problems/pond-sizes-lcci
 * Level : Medium
 */

public class Interview_1619 {
    public static void main(String[] args) {

    }
    int[][] path = {{1,0},{1,1},{0,1},{-1,1},{-1,0},{-1,-1},{0,-1},{1,-1}};
    public int[] pondSizes(int[][] land) {
        int m = land.length;
        int n = land[0].length;
        List<Integer> list = new ArrayList<>();
        LinkedList<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if(land[i][j] == 0) {
                    list.add(dfs(land, i, j));
                }
            }
        }
        return list.stream().mapToInt(Integer::valueOf).sorted().toArray();
    }

    private int dfs(int[][] land, int i, int j) {
        land[i][j] = 1;
        int count = 1;
        for (int k = 0; k < 8; ++k) {
            int x = i + path[k][0];
            int y = j + path[k][1];
            if(x < 0 || x >= land.length || y<0 || y>=land[0].length || land[x][y] != 0) continue;
            count += dfs(land, x, y);
        }
        return count;
    }
}
