package com.xinzhe.categories.solutions.backtrack.medium;

/**
 * @author Xin
 * @date 2020/9/18
 * Title : 526. 优美的排列
 * Description : 假设有从 1 到 N 的 N 个整数，如果从这 N 个数字中成功构造出一个数组，使得数组的第 i 位 (1 <= i <= N) 满足如下两个条件中的一个，我们就称这个数组为一个优美的排列。
 *              条件：第 i 位的数字能被 i 整除, i 能被第 i 位上的数字整除. 现在给定一个整数 N，请问可以构造多少个优美的排列？
 * link : https://leetcode-cn.com/problems/beautiful-arrangement
 * Level : Medium
 */
public class Leetcode526 {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
    }
    int res = 0;
    public int countArrangement(int n) {
        dfs(n, 1, new boolean[n + 1]);
        return res;
    }

    private void dfs(int n, int pos, boolean[] used) {
        if(pos > n) res++;
        for (int i = 1; i <= n; ++i) {
            if(!used[i] && (pos % i == 0 || i % pos == 0)) {
                used[i] = true;
                dfs(n, pos + 1, used);
                used[i] = false;
            }
        }
    }
}
