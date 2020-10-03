package com.xinzhe.contest.weekly.season04.weekly159;

/**
 * @author Xin
 * @date 2020/6/23
 * Title : 1232. 缀点成线
 * Description : 在一个 XY 坐标系中有一些点，我们用数组 coordinates 来分别记录它们的坐标，其中 coordinates[i] = [x, y] 表示横坐标为 x、纵坐标为 y 的点。
 *              请你来判断，这些点是否在该坐标系中属于同一条直线上，是则返回 true，否则请返回 false。
 * link : https://leetcode-cn.com/problems/check-if-it-is-a-straight-line
 * Level : Easy
 * Comment 159周赛01
 */

public class Leetcode_weekly_15901 {

    public static void main(String[] args) {
        Leetcode_weekly_15901 lc = new Leetcode_weekly_15901();
        int[][] arr = {{2,5},{2,4},{2,8}};
        System.out.println(lc.checkStraightLine(arr));
    }

    public boolean checkStraightLine(int[][] coordinates) {
        int n = coordinates.length;
        if(n == 2) return true;
        double x1 = coordinates[0][0];
        double y1 = coordinates[0][1];
        double x2 = coordinates[1][0];
        double y2 = coordinates[1][1];
        if(x1 == x2) {
            for (int i = 2; i < coordinates.length; i++) {
                if(coordinates[i][0] != x1) {
                    return false;
                }
            }
        } else {
            double a = (y2 -y1)/(x2 - x1);
            double b = y1 - x1 * a;
            for (int i = 2; i < coordinates.length; i++) {
                if( a * coordinates[i][0] + b != coordinates[i][1]){
                    return false;
                }
            }
        }

        return true;
    }
}
