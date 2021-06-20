package com.xinzhe.contest.biweeekly.s1.biweekly38;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Xin
 * @date 2020/10/31
 * Title : 1637. 两点之间不包含任何点的最宽垂直面积
 * Description : 给你n个二维平面上的点 points ，其中points[i] = [xi, yi]，请你返回两点之间内部不包含任何点的最宽垂直面积的宽度。
 *              垂直面积 的定义是固定宽度，而 y 轴上无限延伸的一块区域（也就是高度为无穷大）。 最宽垂直面积为宽度最大的一个垂直面积。请注意，垂直区域边上的点不在区域内。
 * link : https://leetcode-cn.com/problems/widest-vertical-area-between-two-points-containing-no-points
 * Level : Easy
 */
public class Leetcode_biweekly_3802 {
    public int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));
        int max = 0;
        int n = points.length;
        for (int i = 1; i < n; ++i) {
            max = Math.max(max, points[i][0] - points[i-1][0]);
        }
        return max;
    }
}
