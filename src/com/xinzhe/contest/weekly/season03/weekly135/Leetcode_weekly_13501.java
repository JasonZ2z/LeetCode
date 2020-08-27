package com.xinzhe.contest.weekly.season03.weekly135;

/**
 * @author Xin
 * @date 2020/8/27
 * Title : 1037. 有效的回旋镖
 * Description : 回旋镖定义为一组三个点，这些点各不相同且不在一条直线上。给出平面上三个点组成的列表，判断这些点是否可以构成回旋镖。
 * link : https://leetcode-cn.com/problems/valid-boomerang/
 * Level : Easy
 */

public class Leetcode_weekly_13501 {
    public static void main(String[] args) {
        Leetcode_weekly_13501 lc = new Leetcode_weekly_13501();
    }
    public boolean isBoomerang(int[][] points) {
        int[] a = points[0];
        int[] b = points[1];
        int[] c = points[2];

        return (c[1] - b[1]) * (b[0] - a[0]) != (c[0] - b[0]) * (b[1] - a[1]);
    }
}
