package com.xinzhe.contest.biweeekly.s1.biweekly23;

/**
 * @author Xin
 * @date 2020/4/4 23:13
 * Title : 5361. 圆和矩形是否有重叠
 * Description : 给你一个以 (radius, x_center, y_center) 表示的圆和一个与坐标轴平行的矩形 (x1, y1, x2, y2)，其中 (x1, y1) 是矩形左下角的坐标，(x2, y2) 是右上角的坐标。
 * 如果圆和矩形有重叠的部分，请你返回 True ，否则返回 False 。
 * 换句话说，请你检测是否 存在 点 (xi, yi) ，它既在圆上也在矩形上（两者都包括点落在边界上的情况）。
 * link : https://leetcode-cn.com/problems/circle-and-rectangle-overlapping
 * Level : Medium
 * Comment : 23双周赛03
 */

public class Leetcode_biweekly_2303 {
    public boolean checkOverlap(int radius, int x_center, int y_center, int x1, int y1, int x2, int y2) {
        for (int i = x1; i <=x2 ; ++i) {
            for (int j = y1; j <= y2 ; ++j) {
                int x = Math.abs(i - x_center);
                int y = Math.abs(j - y_center);
                double l = Math.sqrt(x*x + y*y);
                if(l <= radius){
                    return true;
                }
            }
        }
        return false;
    }

}
