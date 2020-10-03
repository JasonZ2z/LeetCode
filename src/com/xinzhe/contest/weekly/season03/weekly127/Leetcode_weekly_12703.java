package com.xinzhe.contest.weekly.season03.weekly127;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Xin
 * @date 2020/9/22
 * Title : 1007. 行相等的最少多米诺旋转
 * Description : 在一排多米诺骨牌中，A[i] 和 B[i] 分别代表第 i 个多米诺骨牌的上半部分和下半部分。（一个多米诺是两个从 1 到 6 的数字同列平铺形成的 —— 该平铺的每一半上都有一个数字。）
 *              我们可以旋转第 i 张多米诺，使得 A[i] 和 B[i] 的值交换。返回能使 A 中所有值或者 B 中所有值都相同的最小旋转次数。如果无法做到，返回 -1.
 * link : https://leetcode-cn.com/problems/minimum-domino-rotations-for-equal-row
 * Level : Medium
 */

public class Leetcode_weekly_12703 {
    public static void main(String[] args) {
        Leetcode_weekly_12703 lc = new Leetcode_weekly_12703();
    }
    public int minDominoRotations(int[] A, int[] B) {
        int n = A.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if(A[i] == B[i]) {
                map.put(A[i], map.getOrDefault(A[i], 0) + 1);
            } else {
                map.put(A[i], map.getOrDefault(A[i], 0) + 1);
                map.put(B[i], map.getOrDefault(B[i], 0) + 1);
            }
        }
        int max = 0, same = -1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() > max) {
                max = entry.getValue();
                same = entry.getKey();
            }
        }
        if(max < n) return -1;
        int ca =0, cb = 0;
        for (int i = 0; i < n; i++) {
            if(A[i] != same) ca++;
            if(B[i] != same) cb++;
        }
        return Math.min(ca, cb);
    }
}
