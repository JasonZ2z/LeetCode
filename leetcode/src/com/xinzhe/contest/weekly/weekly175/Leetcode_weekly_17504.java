package com.xinzhe.contest.weekly.weekly175;

/**
 * @Author Xin
 * @create 2020/5/19
 * Title : 1349. 参加考试的最大学生数
 * Description : 给你一个 m * n 的矩阵 seats 表示教室中的座位分布。如果座位是坏的（不可用），就用 '#' 表示；否则，用 '.' 表示。
 * 学生可以看到左侧、右侧、左上、右上这四个方向上紧邻他的学生的答卷，但是看不到直接坐在他前面或者后面的学生的答卷。请你计算并返回该考场可以容纳的一起参加考试且无法作弊的最大学生人数。
 * 学生必须坐在状况良好的座位上。
 * link : https://leetcode-cn.com/problems/maximum-students-taking-exam
 * Level : Hard
 * Comment 175周赛04
 */
//todo need to review
public class Leetcode_weekly_17504 {

    public int maxStudents(char[][] seats) {
        int n = seats.length, m = seats[0].length, count = 0;
        //预处理合法转移
        int[] sta = new int[(1 << m) + 10];
        int[] num = new int[(1 << m) + 10];
        for (int i = 0; i < 1 << m; i++) {
            if ((i & i << 1) == 0 && (i & i >> 1) == 0) {
                sta[++count] = i;
                num[count] = Integer.bitCount(i);
            }
        }
        //座位占用状压
        int[] ocp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int tmp = 0;
            for (int j = 0; j < m; j++) if (seats[i - 1][j] == '#') tmp |= (1 << j);
            ocp[i] = tmp;
        }
        //初始化dp，转移状态
        int[][] dp = new int[n + 1][count + 1];
        int res = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= count; j++) {
                if ((ocp[i] & sta[j]) != 0) continue;
                for (int k = 1; k <= count; k++) {
                    if ((ocp[i - 1] & sta[k]) != 0) continue;
                    if ((sta[j] & sta[k] << 1) != 0) continue;
                    if ((sta[j] & sta[k] >> 1) != 0) continue;
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][k] + num[j]);
                }
                if (i == n) res = Math.max(res, dp[i][j]);
            }
        }
        return res;
    }

}
