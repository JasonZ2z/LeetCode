package com.xinzhe.contest.weekly.season04.weekly189;

/**
 * @Author Xin
 * @create 2020/5/17
 * Title : 1453. 圆形靶内的最大飞镖数量
 * Description : 墙壁上挂着一个圆形的飞镖靶。现在请你蒙着眼睛向靶上投掷飞镖。
 * 投掷到墙上的飞镖用二维平面上的点坐标数组表示。飞镖靶的半径为 r 。
 * 请返回能够落在 任意 半径为 r 的圆形靶内或靶上的最大飞镖数。
 * link : https://leetcode-cn.com/problems/maximum-number-of-darts-inside-of-a-circular-dartboard
 * Level : Hard
 */
public class Leetcode_weekly_18904 {
    public static void main(String[] args) {
        int[][] arr = {{1, 2}, {3, 5}, {1, -1}, {2, 3}, {4, 1}, {1, 3}};
        System.out.println(numPoints(arr, 2));
    }

    /**
     * 先判断两点知否能构成圆， 在判断其余点是否在圆内，三重递归判断
     */
    public static int numPoints(int[][] points, int r) {
        int res = 0;
        for (int[] out : points) {
            for (int[] in : points) {
                int count = 2;
                if (out == in) continue;
                if (getLen(out[0], out[1], in[0], in[1]) > r * 2) continue;
                double[] point = getPoint(out[0], out[1], in[0], in[1], r);
                for (int[] tmp : points) {
                    if (tmp == in || tmp == out) continue;
                    if (getLen(point[0], point[1], tmp[0], tmp[1]) <= r) {
                        count++;
                    }
                }
                res = Math.max(count, res);
            }
        }
        return res == 0 ? 1 : res;
    }

    /**
     * 求圆心
     */
    private static double[] getPoint(double x1, double y1, double x2, double y2, double r) {
        double c1 = (x2 * x2 - x1 * x1 + y2 * y2 - y1 * y1) / (2 * (x2 - x1));
        double c2 = (y2 - y1) / (x2 - x1);
        double a = (c2 * c2 + 1);
        double b = (2 * x1 * c2 - 2 * c1 * c2 - 2 * y1);
        double c = x1 * x1 - 2 * x1 * c1 + c1 * c1 + y1 * y1 - r * r;
        double y = (-b + Math.sqrt(b * b - 4 * a * c)) / (2 * a);
        double x = c1 - c2 * y;
        return new double[]{x, y};
    }

    private static double getLen(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }


}
