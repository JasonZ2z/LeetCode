package com.xinzhe.contest.weekly.season04.weekly195;

import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @author Xin
 * @date 2020/6/28
 * Title : 1499. 满足不等式的最大值
 * Description : 给你一个数组 points 和一个整数 k 。数组中每个元素都表示二维平面上的点的坐标，并按照横坐标 x 的值从小到大排序。也就是说 points[i] = [xi, yi] ，并且在 1 <= i < j <= points.length 的前提下， xi < xj 总成立。
 *              请你找出 yi + yj + |xi - xj| 的 最大值，其中 |xi - xj| <= k 且 1 <= i < j <= points.length。 题目测试数据保证至少存在一对能够满足 |xi - xj| <= k 的点
 * link : https://leetcode-cn.com/problems/max-value-of-equation
 * Level : Hard
 * Comment 195周赛04
 * tag : 单调队列 堆
 */
//todo need to review
public class Leetcode_weekly_19504 {
    public static void main(String[] args) {
        Leetcode_weekly_19504 lc = new Leetcode_weekly_19504();
        int[][] arr = {{-19,-12},{-13,-18},{-12,18},{-11,-8},{-8,2},{-7,12},{-5,16},{-3,9},{1,-7},{5,-4},{6,-20},{10,4},{16,4},{19,-9},{20,19}};
        System.out.println(lc.findMaxValueOfEquation2(arr, 6));
        System.out.println(lc.findMaxValueOfEquation(arr, 6));
    }
    //n 单调队列
    public int findMaxValueOfEquation(int[][] points, int k) {
        int n = points.length;
        LinkedList<Integer> list = new LinkedList<>();
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; ++i) {
            int x = points[i][0], y = points[i][1];
            while (!list.isEmpty() && x-points[list.peekFirst()][0] > k) list.pollFirst();
            if(!list.isEmpty()) {
                int t = list.peekFirst();
                max = Math.max(max, x +y + points[t][1] - points[t][0]);
            }
            while (!list.isEmpty() && points[list.peekLast()][1] - points[list.peekLast()][0] <= y -x) {
                list.pollLast();
            }
            list.offerLast(i);
        }
        return max;
    }

    //nlogn 优先队列 (y-x, x)
    public int findMaxValueOfEquation2(int[][] points, int k) {
        PriorityQueue<Pair> queue = new PriorityQueue<>((a,b) -> b.first - a.first);
        int max = Integer.MIN_VALUE;
        for (int[] point : points) {
            int x = point[0], y = point[1];
            while (!queue.isEmpty()) {
                Pair cur = queue.peek();
                if(x - cur.second > k) {
                    queue.poll();
                    continue;
                }
                max = Math.max(max, cur.first + x + y);
                break;
            }
            queue.offer(new Pair(y-x, x));

        }
        return max;
    }

   class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
   }
}
