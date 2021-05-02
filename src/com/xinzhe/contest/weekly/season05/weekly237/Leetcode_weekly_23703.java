package com.xinzhe.contest.weekly.season05.weekly237;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Xin
 * @date 2021/04/18
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_weekly_23703 {
    public static void main(String[] args) {
        Leetcode_weekly_23703 lc = new Leetcode_weekly_23703();
        int[][] arr ={{19,13},{16,9},{21,10},{32,25},{37,4},{49,24},{2,15},{38,41},{37,34},{33,6},{45,4},{18,18},{46,39},{12,24}};
        System.out.println(Arrays.toString(lc.getOrder(arr)));
    }

    public int[] getOrder(int[][] tasks) {
        // queueTime, time, index
        //PriorityQueue<int[]> orig = new PriorityQueue<>((a, b) -> a[0] == b[0] ? (a[1] == b[1] ? a[2] - b[2] : a[1] - b[1]) : a[0] - b[0]);
        int n = tasks.length;
        if(n == 1) return new int[]{0};

        PriorityQueue<int[]> orig = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        PriorityQueue<int[]> wait = new PriorityQueue<>((a, b) -> a[1] == b[1] ? a[2] - b[2] : a[1] - b[1]);

        for (int i = 0; i < tasks.length; i++) {
            int[] cur = tasks[i];
            orig.offer(new int[]{cur[0], cur[1], i});
        }
        int index = 0;
        long tmp = 0;
        int[] res = new int[tasks.length];
        int x = orig.peek()[0];
        while (!orig.isEmpty() && orig.peek()[0] == x) {
            wait.offer(orig.poll());
        }
        while (!orig.isEmpty() || !wait.isEmpty()) {
            if(wait.isEmpty()) {
                wait.offer(orig.poll());
            }
            int[] cur = wait.poll();
            res[index++] = cur[2];
            long start = Math.max(cur[0], tmp);
            tmp = start + cur[1];
            while (!orig.isEmpty() && orig.peek()[0] <= tmp) {
                wait.offer(orig.poll());
            }
        }
        return res;
    }
}
