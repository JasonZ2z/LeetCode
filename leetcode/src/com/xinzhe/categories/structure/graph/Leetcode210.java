package com.xinzhe.categories.structure.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author Xin
 * @create 2020/5/17
 * Title : 210. 课程表 II
 * Description : 现在你总共有 n 门课需要选，记为 0 到 n-1。
 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
 * 给定课程总量以及它们的先决条件，返回你为了学完所有课程所安排的学习顺序。
 * 可能会有多个正确的顺序，你只要返回一种就可以了。如果不可能完成所有课程，返回一个空数组。
 * link : https://leetcode-cn.com/problems/course-schedule-ii
 * Level : Medium
 */
//TODO need to review
public class Leetcode210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] list = new ArrayList[numCourses];
        int[] points = new int[numCourses];
        for (int[] p : prerequisites) {
            points[p[0]]++;
            if (list[p[1]] == null) list[p[1]] = new ArrayList<>();
            list[p[1]].add(p[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; ++i) {
            if (points[i] == 0) queue.add(i);
        }

        int[] res = new int[numCourses];
        int idx = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                res[idx++] = cur;
                ArrayList<Integer> arrayList = list[cur];
                if (arrayList == null) continue;
                for (int val : arrayList) {
                    points[val]--;
                    if (points[val] == 0) queue.add(val);
                }
            }
        }
        return idx == numCourses ? res : new int[0];
    }
}
