package com.xinzhe.contest.weekly.season05.weekly209;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Xin
 * @date 2020/10/4
 * Title : 1610. 可见点的最大数目
 * Description : 给你一个点数组 points 和一个表示角度的整数 angle ，你的位置是 location ，其中 location = [posx, posy] 且 points[i] = [xi, yi] 都表示 X-Y 平面上的整数坐标。
 *              最开始，你面向东方进行观测。你 不能 进行移动改变位置，但可以通过 自转 调整观测角度。换句话说，posx 和 posy 不能改变。你的视野范围的角度用 angle 表示， 这决定了你观测任意方向时可以多宽。设 d 为逆时针旋转的度数，那么你的视野就是角度范围 [d - angle/2, d + angle/2] 所指示的那片区域。
 * link : https://leetcode-cn.com/problems/maximum-number-of-visible-points
 * Level : Hard
 */
//todo need to review
public class Leetcode_weekly_20903 {
    public static void main(String[] args) {
        Leetcode_weekly_20903 lc = new Leetcode_weekly_20903();
    }
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        List<Double> angles = new ArrayList<>();
        int extra = 0;
        int x = location.get(0),y = location.get(1);

        for (List<Integer> point : points) {
            int dx = point.get(0) - x;
            int dy = point.get(1) - y;
            if (dy == 0 && dx == 0) {
                extra++;
                continue;
            }
            double cur = Math.atan2(dy, dx);
            angles.add(cur);
            angles.add(cur + 2 * Math.PI);
        }
        Collections.sort(angles);
        int ans = 0, l = 0, r = 0;
        double max = angle * Math.PI / 180.0;
        while (true) {
            if(r ==  angles.size()) return ans + extra;
            if(angles.get(r) - angles.get(l) <= max) {
                ans = Math.max(ans, r - l + 1);
                r++;
            } else {
                l++;
            }
        }
    }
}
