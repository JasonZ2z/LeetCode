package com.xinzhe.contest.biweeekly.s1.biweekly19;

/**
 * @author Xin
 * @date 2020/5/20
 * Title : 1344. 时钟指针的夹角
 * Description : 给你两个数 hour 和 minutes 。请你返回在时钟上，由给定时间的时针和分针组成的较小角的角度（60 单位制）。
 * link : https://leetcode-cn.com/problems/angle-between-hands-of-a-clock/
 * Level : Medium
 * Comment 19双周赛03
 */

public class Leetcode_biweekly_1903 {
    public double angleClock(int hour, int minutes) {
        double per = 180 / 30.0;
        double hd = 360 / 12.0; // 一个 小时度数。
        double percent = minutes / 60.0;
        double d1 = percent * hd;  // 时针 相对便宜
        double d2 = hour * hd;
        double hourDe = d1 + d2;
        double minDe = per * minutes;

        double res = Math.abs(hourDe - minDe);
        if (res > 180.0) {
            return 360.0 - res;
        }
        return res;
    }
}
