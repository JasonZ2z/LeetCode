package com.xinzhe.contest.weekly.weekly179;

/**
 * @Author Xin
 * @create 2020/5/13
 * Title : 1375. 灯泡开关 III
 * Description : 房间中有 n 枚灯泡，编号从 1 到 n，自左向右排成一排。最初，所有的灯都是关着的。
 *              在 k  时刻（ k 的取值范围是 0 到 n - 1），我们打开 light[k] 这个灯。
 *              灯的颜色要想 变成蓝色 就必须同时满足下面两个条件：
 *              灯处于打开状态。
 *              排在它之前（左侧）的所有灯也都处于打开状态。
 *              请返回能够让 所有开着的 灯都 变成蓝色 的时刻 数目 。
 * link : https://leetcode-cn.com/problems/bulb-switcher-iii
 * Level : Medium
 * Comment 179周赛02
 */

public class Leetcode_weekly_17902 {
    public static void main(String[] args) {
        int[] light = {2, 1, 3, 5, 4};
        System.out.println(numTimesAllBlue(light));
    }

    public static int numTimesAllBlue(int[] light) {
        int count = 0;
        int n = light.length;
        int max = 0;
        for (int i = 0; i < n; ++i) {
            max = Math.max(max, light[i]);
            if (max == i + 1) count++;
        }
        return count;
    }
}
