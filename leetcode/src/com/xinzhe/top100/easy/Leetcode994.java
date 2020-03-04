package com.xinzhe.top100.easy;

import java.util.LinkedList;

/**
 * @Author Xin
 * @create 2020/3/4 17:53
 * Title : 994. 腐烂的橘子
 * Description : 在给定的网格中，每个单元格可以有以下三个值之一：
 *
 * 值 0 代表空单元格；
 * 值 1 代表新鲜橘子；
 * 值 2 代表腐烂的橘子。
 *
 *      每分钟，任何与腐烂的橘子（在 4 个正方向上）相邻的新鲜橘子都会腐烂。
 *      返回直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1。
 * link : https://leetcode-cn.com/problems/rotting-oranges
 * Level : Easy
 */

//todo need to review
public class Leetcode994 {
    public static void main(String[] args) {
        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(orangesRotting(grid));
    }
    static int[][] dir = { {-1,0},{1,0},{0,-1},{0,1} };
    public static int orangesRotting(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        int minute = 0;
        LinkedList<Pos> list = new LinkedList<>();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if(grid[i][j] == 2){
                    list.add(new Pos(i,j,minute));
                }
            }
        }
        while (!list.isEmpty()){
            Pos pos = list.poll();
            minute = pos.minute;
            for (int i = 0; i < 4; i++) {
                int newX = pos.x + dir[i][0];
                int newY = pos.y + dir[i][1];
                if(newX>=0 && newX<row && newY>=0 && newY<column && grid[newX][newY] == 1){
                    grid[newX][newY] = 2;
                    list.add(new Pos(newX, newY, pos.minute+1));
                }
            }
        }

        for (int[] r : grid){
            for (int i : r){
                if(i == 1) return -1;
            }
        }
        return minute;
    }
}
class Pos {
    public int x, y, minute;
    public Pos(int x, int y, int minute) {
        this.x = x;
        this.y = y;
        this.minute = minute;
    }
}