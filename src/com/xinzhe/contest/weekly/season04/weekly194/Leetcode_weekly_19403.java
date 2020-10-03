package com.xinzhe.contest.weekly.season04.weekly194;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author Xin
 * @date 2020/6/21
 * Title : 1488. 避免洪水泛滥
 * Description : 你的国家有无数个湖泊，所有湖泊一开始都是空的。当第 n 个湖泊下雨的时候，如果第 n 个湖泊是空的，那么它就会装满水，否则这个湖泊会发生洪水。你的目标是避免任意一个湖泊发生洪水。
 * link : https://leetcode-cn.com/problems/avoid-flood-in-the-city
 * Level : Medium
 * Comment 194周赛03
 */
public class Leetcode_weekly_19403 {
    public static void main(String[] args) {
        int[] arr = {69,0,0,0,69};
        System.out.println(Arrays.toString(avoidFlood(arr)));
        System.out.println(Arrays.toString(avoidFlood3(arr)));
    }
    //todo need to review
    public static int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] res = new int[n];
        int[] next = new int[n];
        Arrays.fill(next, n+1);
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = rains.length - 1; i >= 0; i--) {
            int r = rains[i];
            if(r > 0) {
                if(map.containsKey(r)) {
                    next[i] = map.get(r);
                }
                map.put(r, i);
            }
        }
        Map<Integer, Boolean> rmap = new HashMap<>();
        PriorityQueue<Node> queue = new PriorityQueue<>(n, Comparator.comparingInt(a -> a.day));
        for (int i = 0; i < n; i++) {
            if(rains[i] > 0) {
                if(rmap.containsKey(i) && rmap.get(i)) return new int[0];
                rmap.put(i, true);
                queue.offer(new Node(i, next[i]));
                res[i] = -1;
            } else{
                if(queue.isEmpty()) {
                    res[i] = 1;
                }else {
                    Node node = queue.remove();
                    res[i] = rains[node.index];
                    rmap.put(node.index, false);
                }
            }

            if(!queue.isEmpty() && queue.peek().day <= i) {
                return new int[0];
            }

        }
        return res;
    }
    static class Node {
        int index;
        int day;

        public Node(int index, int day) {
            this.index = index;
            this.day = day;
        }
    }


    public static int[] avoidFlood3(int[] rains) {
        int n = rains.length;
        Map<Integer, Integer> registries = new HashMap<>(n);
        int[] next = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            next[i] = registries.getOrDefault(rains[i], n);
            registries.put(rains[i], i);
        }

        int[] ans = new int[n];
        PriorityQueue<Node> pq = new PriorityQueue<>(n, Comparator.comparingInt(a -> a.day));
        for (int i = 0; i < n; i++) {
            if (rains[i] == 0) {
                if (!pq.isEmpty()) {
                    ans[i] = pq.remove().index;
                }else{
                    ans[i] = 1;
                }
            } else {
                Node rain = new Node(rains[i], next[i]);
                pq.add(rain);
                ans[i] = -1;
            }
            if (!pq.isEmpty() && pq.peek().day <= i) {
                return new int[0];
            }
        }
        return ans;
    }
}
