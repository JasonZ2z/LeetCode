package com.xinzhe.contest.weekly.season04.weekly160;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Xin
 * @create 2020/6/19
 * Title : 1238. 循环码排列
 * Description : 给你两个整数 n 和 start。你的任务是返回任意 (0,1,2,,...,2^n-1) 的排列 p，并且满足：
 *          p[0] = start
 *          p[i] 和 p[i+1] 的二进制表示形式只有一位不同
 *          p[0] 和 p[2^n -1] 的二进制表示形式也只有一位不同
 * link : https://leetcode-cn.com/problems/circular-permutation-in-binary-representation
 * Level : Medium
 * Comment 160周赛02
 */

public class Leetcode_weekly_16002 {

    public static void main(String[] args) {
        Leetcode_weekly_16002 lc = new Leetcode_weekly_16002();
        System.out.println(lc.circularPermutation(3, 2));
    }

    List<Integer> res = new ArrayList<>();
    boolean[] visited;
    public List<Integer> circularPermutation(int n, int start) {
        int len = 1 << n;
        res.add(start);
        this.visited = new boolean[len];
        visited[start] = true;
        dfs(start, n,  len -1);
        return res;
    }

    private boolean dfs(int start, int n, int end) {
        if(end == 0) return true;
        for (int i = 0; i < n; ++i) {
            int num = start ^ (1 << i);
            if(!visited[num]){
                res.add(num);
                visited[num] = true;
                if(dfs(num, n, end -1)) return true;
                visited[num] = false;
            }
        }
        return false;
    }
}
