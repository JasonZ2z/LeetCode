package com.xinzhe.contest.weekly.season03.weekly131;

import java.util.Arrays;

/**
 * @author Xin
 * @date 2020/9/17
 * Title : 1024. 视频拼接
 * Description : 你将会获得一系列视频片段，这些片段来自于一项持续时长为 T 秒的体育赛事。这些片段可能有所重叠，也可能长度不一
 *              视频片段 clips[i] 都用区间进行表示：开始于 clips[i][0] 并于 clips[i][1] 结束。我们甚至可以对这些片段自由地再剪辑，例如片段 [0, 7] 可以剪切成 [0, 1] + [1, 3] + [3, 7] 三部分。
 *              我们需要将这些片段进行再剪辑，并将剪辑后的内容拼接成覆盖整个运动过程的片段（[0, T]）。返回所需片段的最小数目，如果无法完成该任务，则返回 -1 。
 * link : https://leetcode-cn.com/problems/video-stitching
 * Level : Medium
 * tag ： 贪心
 */
//todo need to review
public class Leetcode_weekly_13104 {
    public static void main(String[] args) {
        Leetcode_weekly_13104 lc = new Leetcode_weekly_13104();
        int[][] arr ={{16,18},{16,20},{3,13},{1,18},{0,8},{5,6},{13,17},{3,17},{5,6}};
        System.out.println(lc.videoStitching2(arr, 15));
    }
    public int videoStitching(int[][] clips, int T) {
        int[] dp = new int[T+1];
        int inf = (int)1e9;
        Arrays.fill(dp, inf);
        dp[0] = 0;
        for (int i = 1; i <= T; ++i) {
            for (int[] clip : clips) {
                if(clip[0] <= i && clip[1] >= i) {
                    dp[i] = Math.min(dp[i], dp[clip[0]] + 1);
                }
            }
        }
        return dp[T] == inf ? -1 : dp[T];
    }


    public int videoStitching2(int[][] clips, int T) {
        int[] dp = new int[101];
        for (int[] clip : clips) {
            dp[clip[0]] = Math.max(dp[clip[0]], clip[1]);
        }
        int cur = 0, count = 0, pre = 0;
        for(int i=0; i<T; i++) {
            cur = Math.max(cur, dp[i]);
            if(i == pre) {
                count++;
                pre = cur;
            }
            if(i == cur) return -1;
        }
        return count;
    }
}
