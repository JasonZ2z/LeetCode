package com.xinzhe.contest.weekly.season04.weekly176;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Xin
 * @date 2020/5/19
 * Title : 1353. 最多可以参加的会议数目
 * Description :  给你一个数组 events，其中 events[i] = [startDayi, endDayi] ，表示会议 i 开始于 startDayi ，结束于 endDayi 。
 * 你可以在满足 startDayi <= d <= endDayi 中的任意一天 d 参加会议 i 。注意，一天只能参加一个会议。
 * 请你返回你可以参加的 最大 会议数目。
 * link : https://leetcode-cn.com/problems/maximum-number-of-events-that-can-be-attended
 * Level : Medium
 * Comment 176周赛03
 * tag : 贪心
 */
//todo need to review
public class Leetcode_weekly_17603 {
    public int maxEvents(int[][] events) {
        int n = events.length;
        Arrays.sort(events, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int count = 0;
        int last = 1, i = 0;
        while (i < n || !queue.isEmpty()) {
            while (i < n && events[i][0] == last) {
                queue.offer(events[i][1]);
                i++;
            }
            while (!queue.isEmpty() && queue.peek() < last) {
                queue.poll();
            }
            if (!queue.isEmpty()) {
                queue.poll();
                count++;
            }
            last++;
        }
        return count;
    }
}
