package com.xinzhe.categories.structure.arrays.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author Xin
 * @date 2020/7/29
 * Title : 621. 任务调度器
 * Description : 给定一个用字符数组表示的 CPU 需要执行的任务列表。其中包含使用大写的 A - Z 字母表示的26 种不同种类的任务。任务可以以任意顺序执行，并且每个任务都可以在 1 个单位时间内执行完。
 *              CPU 在任何一个单位时间内都可以执行一个任务，或者在待命状态。然而，两个相同种类的任务之间必须有长度为n 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。
 *              你需要计算完成所有任务所需要的最短时间。
 * link : https://leetcode-cn.com/problems/task-scheduler
 * Level : Medium
 */

public class Leetcode621 {
    public static void main(String[] args) {
        Leetcode621 lc = new Leetcode621();
        //char[] arr = {'A','A','A','A','A','A','B','C','D','E','F','G'};
        char[] arr = {'A','A','A','B','B','B'};
        System.out.println(lc.leastInterval2(arr, 2));
    }
    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for(char c : tasks) {
            map[c - 'A']++;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b)-> b-a);
        for(int a : map) {
            if(a > 0) {
                queue.add(a);
            }
        }
        int res = 0;
        while(!queue.isEmpty()) {
            int i = 0;
            List<Integer> list = new ArrayList<>();
            while(i <= n) {
                if(!queue.isEmpty()) {
                    if(queue.peek() > 1) {
                        list.add(queue.poll() - 1);
                    } else {
                        queue.poll();
                    }
                }
                res++;
                if(queue.isEmpty() && list.size() == 0) {
                    break;
                }
                i++;
            }
            queue.addAll(list);
        }
        return res;
    }

    public int leastInterval2(char[] tasks, int n) {
        int[] array = new int[26];
        for (char task : tasks) {
            array[task - 'A']++;
        }
        int max = 0;
        for (int i : array) {
            max = Math.max(max, i);
        }
        int maxCount = 0;
        for (int i : array) {
            if (i == max) maxCount++;
        }
        return Math.max(tasks.length, (n + 1) * (max - 1) + maxCount);
    }
}
