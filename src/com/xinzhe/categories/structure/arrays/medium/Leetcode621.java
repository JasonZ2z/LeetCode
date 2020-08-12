package com.xinzhe.categories.structure.arrays.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author Xin
 * @date 2020/7/29
 * Title : 621. Task Scheduler
 * Description : 实
 * link : https://leetcode-cn.com/problems/next-permutation
 * Level : Medium
 */

public class Leetcode621 {
    public static void main(String[] args) {
        Leetcode621 lc = new Leetcode621();
        char[] arr = {'A','A','A','A','A','A','B','C','D','E','F','G'};
        System.out.println(lc.leastInterval(arr, 2));
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
}
