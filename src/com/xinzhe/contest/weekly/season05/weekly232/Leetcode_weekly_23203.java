package com.xinzhe.contest.weekly.season05.weekly232;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Xin
 * @date 2021/03/14
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_weekly_23203 {
    public static void main(String[] args) {
        Leetcode_weekly_23203 lc = new Leetcode_weekly_23203();
        int[][] arr ={{1,2},{3,5},{2,2}};
        System.out.println(lc.maxAverageRatio(arr, 2));
    }
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        int n = classes.length;
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingDouble(a -> a.z));
        for (int[] cur : classes) {
            queue.offer(new Node(cur[0], cur[1], cur[0] *1.0/cur[1]));
        }
        while (extraStudents > 0) {
            Node poll = queue.poll();
            if(poll.z == 1.0) break;
            int diff = poll.y - poll.x;
            int i = poll.x + 1, j = poll.y + 1;
            queue.offer(new Node(i, j, i *1.0/j));
        }
        double res = 0.0;
        while (!queue.isEmpty()) {
            res += queue.poll().z;
        }
        return res/n;

    }

    class Node {
        int x;
        int y;
        double z;

        public Node(int x, int y, double z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}
