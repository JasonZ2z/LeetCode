package com.xinzhe.contest.weekly.season04.weekly180;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author Xin
 * @date 2020/5/13
 * Title : 1383. 最大的团队表现值
 * Description : 给公司有编号为 1 到 n 的 n 个工程师，给你两个数组 speed 和 efficiency ，
 * 其中 speed[i] 和 efficiency[i] 分别代表第 i 位工程师的速度和效率。
 * 请你返回由最多 k 个工程师组成的 ​​​​​​最大团队表现值 ，由于答案可能很大，请你返回结果对 10^9 + 7 取余后的结果。
 * 团队表现值 的定义为：一个团队中「所有工程师速度的和」乘以他们「效率值中的最小值」。
 * link : https://leetcode-cn.com/problems/maximum-performance-of-a-team
 * Level : Hard
 * Comment 180周赛04
 */
public class Leetcode_weekly_18004 {
    static final int MOD = (int) (1e9 + 7);

    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int[][] items = new int[n][2];
        for (int i = 0; i < n; ++i) {
            items[i][0] = speed[i];
            items[i][1] = efficiency[i];
        }
        Arrays.sort(items, (a, b) -> b[1] - a[1]);
        System.out.println(Arrays.deepToString(items));
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        long res = 0L, sum = 0L;
        for (int i = 0; i < n; ++i) {
            if (queue.size() > k - 1) {
                sum -= queue.poll();
            }
            sum += items[i][0];
            res = Math.max(res, sum * items[i][1]);
            queue.add(items[i][0]);
        }
        return (int) (res % MOD);
    }

    public static void main(String[] args) {
        Leetcode_weekly_18004 lc = new Leetcode_weekly_18004();
        int[] s = {2, 8, 2};
        int[] e = {2, 7, 1};
        System.out.println(lc.maxPerformance(3, s, e, 2));
    }
}
