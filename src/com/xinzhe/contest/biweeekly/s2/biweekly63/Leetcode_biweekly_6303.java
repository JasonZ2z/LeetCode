package com.xinzhe.contest.biweeekly.s2.biweekly63;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author Xin
 * @date 2021/10/16
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_biweekly_6303 {
    public static void main(String[] args) {
        Leetcode_biweekly_6303 lc = new Leetcode_biweekly_6303();
//        int[][] arr = {{0,1}, {1,2}}; int[] a = {0,2, 1};
//        int[][] arr ={{0,1},{0,2},{1,2}}; int[] a = {0,10,10};
       //20
//         int[][] arr ={{3,8},{4,13},{0,7},{0,4},{1,8},{14,1},{7,2},{13,10},{9,11},{12,14},{0,6},{2,12},{11,5},{6,9},{10,3}}; int[] a = {0,3,2,1,5,1,5,5,3,1,2,2,2,2,1};
      //67
        int[][] arr ={{5,7},{15,18},{12,6},{5,1},{11,17},{3,9},{6,11},{14,7},{19,13},{13,3},{4,12},{9,15},{2,10},{18,4},{5,14},{17,5},{16,2},{7,1},{0,16},{10,19},{1,8}}; int[] a = {0,2,1,1,1,2,2,2,2,1,1,1,2,1,1,1,1,2,1,1};
        System.out.println(lc.networkBecomesIdle(arr, a));

    }
    public int networkBecomesIdle(int[][] edges, int[] patience) {
        int n = patience.length;
        Integer[] arr = new Integer[n];
        arr[0] = 0;
        Set<Integer>[] dict = new Set[n];
        for (int i = 0; i < n; ++i) {
            dict[i] = new HashSet<>();
        }
        for (int[] edge : edges) {
            int x = edge[0], y = edge[1];
            dict[x].add(y);
            dict[y].add(x);
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        int dist = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                Integer j = queue.poll();
                for (Integer k : dict[j]) {
                    if(arr[k] == null) {
                        arr[k] = dist;
                        queue.offer(k);
                    }
                }
            }
            dist++;
        }

        int max = 0;
        for (int i = 1; i < n; i++) {
            if(arr[i] * 2 < patience[i]) {
                max = Math.max(max, arr[i] * 2);
            } else {
//max = Math.max(max, (2 * dist[i] - 1) / patience[i] * patience[i] + 2 * dist[i]);
                max = Math.max(max, (((arr[i] * 2 - 1 )/ patience[i])  * patience[i]) + arr[i] * 2);
            }
        }
        return max + 1;

    }
}