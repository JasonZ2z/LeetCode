package com.xinzhe.contest.weekly.season04.weekly194;

import java.util.*;

/**
 * @Author Xin
 * @create 2020/6/21
 * Title :
 * Description :
 * link :
 * Level : Medium
 * Comment 194周赛03
 */
public class Leetcode_weekly_19403 {
    public static void main(String[] args) {
        int[] arr = {69,0,0,0,69};
        System.out.println(Arrays.toString(avoidFlood2(arr)));
    }
    //todo need to review
    public static int[] avoidFlood2(int[] rains) {
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

}
