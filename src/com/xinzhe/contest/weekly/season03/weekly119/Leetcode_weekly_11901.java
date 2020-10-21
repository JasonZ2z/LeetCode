package com.xinzhe.contest.weekly.season03.weekly119;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Xin
 * @date 2020/10/21
 * Title : 973. 最接近原点的 K 个点
 * Description : 我们有一个由平面上的点组成的列表 points。需要从中找出 K 个距离原点 (0, 0) 最近的点。
 *              （这里，平面上两点之间的距离是欧几里德距离。）你可以按任何顺序返回答案。除了点坐标的顺序之外，答案确保是唯一的。
 * link : https://leetcode-cn.com/problems/k-closest-points-to-origin
 * Level : Medium
 */

public class Leetcode_weekly_11901 {
    public static void main(String[] args) {
        Leetcode_weekly_11901 lc = new Leetcode_weekly_11901();
        int[][] arr = {{1,3}, {-2,2}};
        System.out.println(Arrays.deepToString(lc.kClosest(arr, 1)));
    }
    public int[][] kClosest(int[][] points, int K) {
        int n = points.length;
        int[][] arr =  new int[n][2];
        for (int i = 0; i < points.length; i++) {
            arr[i][0] = i;
            arr[i][1] = cal(points[i][0], points[i][1]);
        }
        Arrays.sort(arr, Comparator.comparingLong(a -> a[1]));
        int[][] res = new int[K][2];
        for (int i = 0; i < K; ++i) {
            res[i] = points[arr[i][0]];
        }
        return res;
    }

    private int cal(int x, int y) {
        return x * x + y * y;
    }
}
