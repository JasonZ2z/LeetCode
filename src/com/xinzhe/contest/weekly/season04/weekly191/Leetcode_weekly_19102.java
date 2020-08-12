package com.xinzhe.contest.weekly.season04.weekly191;

import java.util.Arrays;

/**
 * @author Xin
 * @date 2020/5/31
 * Title :
 * Description :
 * link :
 * Level : Medium
 * Comment 191周赛02
 */
public class Leetcode_weekly_19102 {
    static final int MOD = (int) 1e9 + 7;

    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int nh = horizontalCuts.length;
        int ph = horizontalCuts[0], qh = h - horizontalCuts[nh - 1];
        long hmax = Math.max(ph, qh);
        for (int i = 1; i < nh; i++) {
            hmax = Math.max(horizontalCuts[i] - horizontalCuts[i - 1], hmax);
        }

        int nv = verticalCuts.length;
        int pv = verticalCuts[0], qv = w - verticalCuts[nv - 1];
        long vmax = Math.max(pv, qv);
        for (int i = 1; i < nv; i++) {
            vmax = Math.max(verticalCuts[i] - verticalCuts[i - 1], vmax);
        }
        return (int) ((hmax * vmax) % MOD);
    }

}
