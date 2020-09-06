package com.xinzhe.contest.weekly.season05.weekly205;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author Xin
 * @date 2020/9/6
 * Title :
 * Description :
 * link :
 * Level :
 */
public class Leetcode_weekly_20504 {
    public static void main(String[] args) {
        Leetcode_weekly_20504 lc = new Leetcode_weekly_20504();
        int[] arr = {1,2,3,1,2};
    }
    int res = 0;
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        HashSet<Integer>[] s1 = new HashSet[n + 1];
        HashSet<Integer>[] s2 = new HashSet[n + 1];

        for (int i = 0; i <= n; ++i) {
            s1[i] = new HashSet<>();
            s2[i] = new HashSet<>();
        }

        for (int[] edge : edges) {
            int type = edge[0], from = edge[1], to = edge[2];
            if(type == 1) {
                if(s1[from].contains(to)) res++;
                else s1[from].add(to);
                if(s1[to].contains(from)) res++;
                else s1[to].add(from);
            } else if(type == 2) {
                if(s2[from].contains(to)) res++;
                else s2[from].add(to);
                if(s2[to].contains(from)) res++;
                else s2[to].add(from);
            } else {
                if(s1[from].contains(to)) res++;
                else s1[from].add(to);
                if(s1[to].contains(from)) res++;
                else s1[to].add(from);
                if(s2[from].contains(to)) res++;
                else s2[from].add(to);
                if(s2[to].contains(from)) res++;
                else s2[to].add(from);
            }
        }
        res /= 2;
        boolean[] u1 = new boolean[n+1];
        dfs(s1, 1, u1, -1);
        System.out.println(Arrays.toString(u1));
        for (int i = 1; i < u1.length; i++) {
            if(!u1[i]) return -1;
        }

        boolean[] u2 = new boolean[n+1];
        dfs(s2, 1, u2, -1);

        for (int i = 1; i < u2.length; i++) {
            if(!u2[i]) return -1;
        }

        return res;

    }
    private void dfs(HashSet<Integer>[] s1, int i, boolean[] u1, int pa) {
        if(i == pa) return;
        if(u1[i]) {
            res++;
            return;
        }
        u1[i] = true;
        for (int j : s1[i]) {
            dfs(s1, j, u1, i);
        }
    }



}
