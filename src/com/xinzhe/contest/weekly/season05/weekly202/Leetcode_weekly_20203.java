package com.xinzhe.contest.weekly.season05.weekly202;

import java.util.Arrays;

/**
 * @author Xin
 * @date 2020/8/16
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_weekly_20203 {
    public static void main(String[] args) {
        Leetcode_weekly_20203 lc = new Leetcode_weekly_20203();
    }

    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int n = position.length;
        int l = 1, r = position[n-1] - position[0];
        r /= m-1;

        while (l < r) {
            int mid = l + ((r - l) >> 1);
            if(helper(position, m, mid)) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        if(helper(position, m, l)) return l;
        return l-1;
    }

    private boolean helper(int[] position, int m, int l) {
        int res = -l;
        for (int i = 0; i < position.length; ++i) {
            if(position[i] - res >= l) {
                --m;
                res = position[i];
            }
        }
        return m <= 0;
    }
}
