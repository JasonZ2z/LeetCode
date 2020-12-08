package com.xinzhe.categories.solutions.dfs.medium;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author Xin
 * @date 2020/12/08
 * Title : 851. 喧闹和富有
 * Description : 在一组 N 个人（编号为0, 1, 2, ..., N-1）中，每个人都有不同数目的钱，以及不同程度的安静（quietness）。为了方便起见，我们将编号为x的人简称为 "person[x]"。
 *              如果能够肯定 person[x]比 person[y]更有钱的话，我们会说richer[i] = [x, y]。注意richer可能只是有效观察的一个子集。
 *              另外，如果 person[x]的安静程度为q，我们会说quiet[x] = q。
 *              现在，返回答案answer，其中answer[x] = y的前提是，在所有拥有的钱不少于person[x]的人中，person[y]是最安静的人（也就是安静值quiet[y]最小的人）。
 * link : https://leetcode-cn.com/problems/loud-and-rich
 * Level : Medium
 */

//todo need to review
public class Leetcode851 {
    public static void main(String[] args) {
        Leetcode851 lc = new Leetcode851();
        int[][] pre =  {{1,0},{2,1},{3,1},{3,7},{4,3},{5,3},{6,3}};
        int[] post = {3,2,5,4,6,1,7,0};
        System.out.println(Arrays.toString(lc.loudAndRich(pre, post)));
    }

    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        HashSet<Integer>[] sets = new HashSet[n];
        for (int i = 0; i < n; i++) {
            sets[i] = new HashSet<>();
        }
        for (int[] rich : richer) {
            sets[rich[1]].add(rich[0]);
        }
        int[] res = new int[n];
        Arrays.fill(res, -1);
        for (int i = 0; i < n; i++) {
            if(sets[i].isEmpty()) {
                res[i] = i;
            }
        }
        for (int i = 0; i < n; ++i) {
            dfs(i, sets, res, quiet);
        }
        return res;
    }

    private int dfs(int index, HashSet<Integer>[] sets, int[] res, int[] quiet) {
        if(res[index] != -1) return res[index];
        int mv = quiet[index], mi = index;
        for (int i : sets[index]) {
            int x = dfs(i, sets, res, quiet);
            if(quiet[x] < mv){
                mv = quiet[x];
                mi = x;
            }
        }
        res[index] = mi;
        return mi;
    }

}
