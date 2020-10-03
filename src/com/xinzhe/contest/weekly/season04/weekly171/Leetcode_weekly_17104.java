package com.xinzhe.contest.weekly.season04.weekly171;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Xin
 * @date 2020/5/25
 * Title : 1320. 二指输入的的最小距离
 * Description : 二指输入法定制键盘在 XY 平面上的布局如上图所示，其中每个大写英文字母都位于某个坐标处，例如字母 A 位于坐标 (0,0)，字母 B 位于坐标 (0,1)，字母 P 位于坐标 (2,3) 且字母 Z 位于坐标 (4,1)。
 *          给你一个待输入字符串 word，请你计算并返回在仅使用两根手指的情况下，键入该字符串需要的最小移动总距离。坐标 (x1,y1) 和 (x2,y2) 之间的距离是 |x1 - x2| + |y1 - y2|。
 *          注意，两根手指的起始位置是零代价的，不计入移动总距离。你的两根手指的起始位置也不必从首字母或者前两个字母开始。
 * link : https://leetcode-cn.com/problems/minimum-distance-to-type-a-word-using-two-fingers
 * Level : Hard
 * Comment 171周赛01
 */

public class Leetcode_weekly_17104 {
    Map<Character, int[]> map;

    public int minimumDistance(String word) {
        int n = word.length();
        this.map = new HashMap<>();

        for (int i = 0; i < 26; ++i) {
            map.put((char) ('A' + i), new int[]{i / 6, i % 6});
        }
        char[] arr = word.toCharArray();
        int[][][] dp = new int[n][26][26];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < 26; ++j) {
                for (int k = 0; k < 26; ++k) {
                    dp[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < 26; ++i) {
            dp[0][i][arr[i] - 'A'] = 0;
            dp[0][arr[i] - 'A'][i] = 0;
        }

        for (int i = 1; i < n; i++) {
            int cur = arr[i] - 'A';
            int pre = arr[i - 1] - 'A';
            int d0 = getLen(arr[i], arr[i - 1]);
            for (int j = 0; j < 26; ++j) {
                dp[i][cur][j] = Math.min(dp[i][cur][j], dp[i - 1][pre][j] + d0);
                dp[i][j][cur] = Math.min(dp[i][j][cur], dp[i - 1][j][pre] + d0);
                if (pre == j) {
                    for (int k = 0; k < 26; ++k) {
                        int d1 = getLen(arr[i], (char) (k + 'A'));
                        dp[i][cur][j] = Math.min(dp[i][cur][j], dp[i - 1][k][j] + d1);
                        dp[i][j][cur] = Math.min(dp[i][j][cur], dp[i - 1][j][k] + d1);
                    }
                }
                if (i == n - 1) {
                    res = Math.min(res, dp[i][cur][j]);
                    res = Math.min(res, dp[i][j][cur]);
                }
            }
        }
        return res;
    }

    private int getLen(char c1, char c2) {
        int[] a = map.get(c1);
        int[] b = map.get(c2);
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
}
