package com.xinzhe.contest.biweeekly.biweekly37;

/**
 * @author Xin
 * @date 2020/10/17
 * Title : 620. 网络信号最好的坐标
 * Description : 给你一个数组 towers 和一个整数 radius ，数组中包含一些网络信号塔，其中 towers[i] = [xi, yi, qi] 表示第 i 个网络信号塔的坐标是 (xi, yi) 且信号强度参数为 qi 。所有坐标都是在  X-Y 坐标系内的 整数 坐标。两个坐标之间的距离用 欧几里得距离 计算。
 *              整数 radius 表示一个塔 能到达 的 最远距离 。如果一个坐标跟塔的距离在 radius 以内，那么该塔的信号可以到达该坐标。在这个范围以外信号会很微弱，所以 radius 以外的距离该塔是 不能到达的 。
 *              如果第 i 个塔能到达 (x, y) ，那么该塔在此处的信号为 ⌊qi / (1 + d)⌋ ，其中 d 是塔跟此坐标的距离。一个坐标的 网络信号 是所有 能到达 该坐标的塔的信号强度之和。
 *              请你返回 网络信号 最大的整数坐标点。如果有多个坐标网络信号一样大，请你返回字典序最小的一个坐标。
 * link : https://leetcode-cn.com/problems/coordinate-with-maximum-network-quality
 * Level : Medium
 */
public class Leetcode_biweekly_3702 {

    public int[] bestCoordinate(int[][] towers, int radius) {
        int n = towers.length;
        int max = 0, p = 0, q = 0;
        for (int i = 0; i <= 50; ++i) {
            for (int j = 0; j <= 50 ; ++j) {
                int x = 0;
                for (int k = 0; k < n; ++k) {
                    x += getLen(towers, i,j, k, radius);
                }
                if(x > max) {
                    p = i;
                    q = j;
                    max = x;

                }
            }
        }
        return new int[]{p, q};
    }

    private int getLen(int[][] towers, int i, int j, int k, int radius) {
        double len = Math.sqrt(Math.pow(i - towers[k][0],2) + Math.pow(j - towers[k][1], 2));
        if(len <= radius) {
            return (int) Math.floor(towers[k][2] / (1 + len));
        }
        return 0;
    }
}
