package com.xinzhe.contest.weekly.weekly179;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author Xin
 * @create 2020/5/17
 * Title :
 * Description :
 * link :
 * Level : Hard
 */
public class Leetcode_weekly_17904 {
    public static void main(String[] args) {
        int[][] arr = {{1, 2}, {3, 5}, {1, -1}, {2, 3}, {4, 1}, {1, 3}};
        System.out.println(numPoints(arr, 2));
        System.out.println(numPoints2(arr, 2));
    }

    public static int numPoints(int[][] points, int r) {
        int n = points.length;

        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));
        int xmin = points[0][0];
        int xmax = points[n - 1][0];
        System.out.println(xmin + " " + xmax);
        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));

        int ymin = points[0][1];
        int ymax = points[n - 1][1];
        System.out.println(ymin + " " + ymax);
        int count = 0;
        for (int i = xmin - r; i <= xmax + r; ++i) {
            for (int j = ymin - r; j <= ymax + r; ++j) {
                count = Math.max(count, getCount(points, r, i, j));
            }
        }
        return count;
    }

    private static int getCount(int[][] points, int r, int i, int j) {
        int c = 0;
        for (int[] point : points) {
            int x = i - point[0];
            int y = j - point[1];
            if (x * x + y * y <= r * r) {
                c++;
            }
        }
        return c;
    }

    public static int numPoints2(int[][] points, int r) {
        int n = points.length;
        boolean[][] dp = new boolean[n][n];

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i == j) dp[i][j] = true;
                if (getLen(points[i], points[j]) <= 2 * r) {
                    dp[i][j] = true;
                }
            }
        }
        int c = 0;
        for (int i = 0; i < n; ++i) {
            int count = 0;
            for (boolean b : dp[i]) {
                count++;
            }
            c = Math.max(count, c);
        }
        return c;
    }

    private static double getLen(int[] a, int[] b) {
        return Math.sqrt(Math.pow(a[1] - b[1], 2) + Math.pow(a[0] - b[0], 2));
    }
}
