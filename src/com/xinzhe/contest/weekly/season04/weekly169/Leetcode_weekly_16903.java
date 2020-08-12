package com.xinzhe.contest.weekly.season04.weekly169;

/**
 * @Author Xin
 * @create 2020/5/29
 * Title : 1306. 跳跃游戏 III
 * Description : 这里有一个非负整数数组 arr，你最开始位于该数组的起始下标 start 处。当你位于下标 i 处时，你可以跳到 i + arr[i] 或者 i - arr[i]。
 *              请你判断自己是否能够跳到对应元素值为 0 的 任意 下标处。注意，不管是什么情况下，你都无法跳到数组之外。
 * link : https://leetcode-cn.com/problems/jump-game-iii
 * Level : Medium
 * Comment 169周赛03
 */

public class Leetcode_weekly_16903 {
    int[] arr;
    boolean[] visited;

    public boolean canReach(int[] arr, int start) {
        this.arr = arr;
        this.visited = new boolean[arr.length];
        return dfs(start);
    }

    private boolean dfs(int start) {
        if (start >= 0 && start < arr.length) {
            if (arr[start] == 0) return true;
            if (visited[start]) return false;
            visited[start] = true;
            return dfs(start + arr[start]) || dfs(start - arr[start]);
        }
        return false;
    }
}
