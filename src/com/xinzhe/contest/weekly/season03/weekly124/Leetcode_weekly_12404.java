package com.xinzhe.contest.weekly.season03.weekly124;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Xin
 * @date 2020/9/23
 * Title : 996. 正方形数组的数目
 * Description : 给定一个非负整数数组 A，如果该数组每对相邻元素之和是一个完全平方数，则称这一数组为正方形数组。
 *              返回 A 的正方形排列的数目。两个排列 A1 和 A2 不同的充要条件是存在某个索引 i，使得 A1[i] != A2[i]。
 * link : https://leetcode-cn.com/problems/number-of-squareful-arrays
 * Level : Hard
 */

//todo find better solution
public class Leetcode_weekly_12404 {
    public static void main(String[] args) {
        Leetcode_weekly_12404 lc = new Leetcode_weekly_12404();
        int[] arr = {1,17,8};
        System.out.println(lc.numSquarefulPerms(arr));
    }
    int count = 0;
    Set<Integer>[] set;
    int n;
    int[] arr;
    public int numSquarefulPerms(int[] arr) {
        this.arr = arr;
        this.n = arr.length;
        this.set = new HashSet[n];
        for (int i = 0; i < n; ++i) {
            set[i] = new HashSet<>();
        }
        Arrays.sort(arr);
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if(i == j) continue;
                if(helper(arr[i], arr[j])) set[i].add(j);
            }
        }
        for (int i = 0; i < n; ++i) {
            if(i > 0 && arr[i] == arr[i-1]) continue;
            boolean[] used = new boolean[n];
            used[i] = true;
            dfs(used, i, 0);
        }
        return count;
    }

    private void dfs(boolean[] used, int index, int pos) {
        if(pos == n-1) {
            count++;
        }
        Set<Integer> dict = new HashSet<>();
        for (int i : set[index]) {
            if(used[i] || dict.contains(arr[i])) continue;
            dict.add(arr[i]);
            used[i] = true;
            dfs(used, i, pos + 1);
            used[i] = false;
        }
    }

    private boolean helper(int i, int j) {
        int sum = i + j;
        int x = (int) Math.sqrt(sum);
        return x * x == sum;
    }
}
