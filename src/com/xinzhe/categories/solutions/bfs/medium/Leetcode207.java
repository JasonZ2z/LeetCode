package com.xinzhe.categories.solutions.bfs.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author Xin
 * @create 2020/6/27
 * Title : 207. 课程表
 * Description : 你这个学期必须选修 numCourse 门课程，记为 0 到 numCourse-1 。
 *          在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们：[0,1]
 *          给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习？
 * Level : Medium
 */
//todo need to review
public class Leetcode207 {
    public boolean canFinish(int n, int[][] prerequisites) {
        int[] indegress = new int[n];
        List<List<Integer>> list = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; ++i) {
            list.add(new ArrayList<>());
        }
        for (int[] p : prerequisites) {
            indegress[p[0]]++;
            list.get(p[1]).add(p[0]);
        }

        for (int i = 0; i < n; ++i) {
            if(indegress[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            Integer pre = queue.poll();
            n--;
            for (Integer cur : list.get(pre)) {
                if(--indegress[cur] == 0) {
                    queue.add(cur);
                }
            }
        }
        return n == 0;
    }
}
