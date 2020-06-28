package com.xinzhe.contest.biweeekly.biweekly29;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @Author Xin
 * @create 2020/6/27
 * Title :
 * Description :
 * link :
 * Level : Hard
 */
public class Leetcode_biweekly_2904 {
    public static void main(String[] args) {
        int[][] a = {{1,6},{2,7},{8,7},{2,5},{3,4}};
        System.out.println(minNumberOfSemesters2(8,a, 3));
    }

    public static int minNumberOfSemesters2(int n, int[][] dependencies, int k) {
        Set<Integer>[] graph = new HashSet[n+1];
        int[] inDegree = new int[n+1];
        int[] outDegree = new int[n+1];
        for (int i = 0; i <= n; ++i) {
            graph[i] = new HashSet<>();
        }
        for (int[] d : dependencies) {
            inDegree[d[1]]++;
            outDegree[d[0]]++;
            graph[d[0]].add(d[1]);
        }

        PriorityQueue<Node> queue = new PriorityQueue<>(n+1, (o1, o2) -> {
         if(o1.term == o2.term) {
             if(o1.ind == o2.ind) {
                 return o1.outd - o2.outd;
             }
             return o1.ind - o2.ind;
         } else {
             return o1.term - o2.term;
         }

        });
        for (int i = 1; i <= n; ++i) {
            if(inDegree[i] == 0) {
                queue.add(new Node(i, 0, outDegree[i], 1));
            }
        }

        int res = 0;
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int tmp = size + count;
            if(tmp <= k) {
                res++;
                count = 0;
            }
            else {
                if(tmp % k == 0) {
                    res += tmp/k;
                    count = 0;
                } else {
                    res += tmp/k + 1;
                    count = tmp%k;
                }

            }
            for (int i = 0; i < size; ++i) {
                Node cur = queue.poll();
                for (Integer j : graph[cur.index]) {
                    if(--inDegree[j] == 0) {
                        queue.add(new Node(j, inDegree[j], outDegree[j],cur.term+1));
                    }
                }
            }
        }
        return res;
    }
    static class Node{
        int index;
        int ind;
        int outd;
        int term;

        public Node(int index, int ind, int outd, int term) {
            this.index = index;
            this.ind = ind;
            this.outd = outd;
            this.term = term;
        }
    }


    public int minNumberOfSemesters(int n, int[][] dependencies, int k) {
        ArrayList<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        int[] degree = new int[n];
        for (int[] dependency : dependencies) {
            graph[dependency[0] - 1].add(dependency[1] - 1);
            degree[dependency[1] - 1]++;
        }
        PriorityQueue<Integer> deque = new PriorityQueue<>((a, b) -> degree[b] - degree[a]);
        for (int i = 0; i < n; i++) {
            if (degree[i] == 0) {
                deque.add(i);
            }
        }
        int ans = 0;
        while (!deque.isEmpty()) {
            ArrayList<Integer> next = new ArrayList<>();
            for (int i = 0; !deque.isEmpty() && i < k; i++) {
                int j = deque.remove();
                for (int l : graph[j]) {
                    degree[l]--;
                    if (degree[l] == 0) {
                        next.add(l);
                    }
                }
            }
            deque.addAll(next);
            ans++;
        }
        return ans;
    }

}
