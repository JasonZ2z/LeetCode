package com.xinzhe.contest.weekly.season03.weekly148;

import com.xinzhe.categories.structure.tree.TreeNode;

/**
 * @author Xin
 * @date 2020/10/3
 * Title : 1145. 二叉树着色游戏
 * Description : 游戏中，给出二叉树的根节点 root，树上总共有 n 个节点，且 n 为奇数，其中每个节点上的值从 1 到 n 各不相同 ...
 * link : https://leetcode-cn.com/problems/binary-tree-coloring-game/
 * Level : Medium
 */

//todo need review
public class Leetcode_weekly_14802 {
    public static void main(String[] args) {
        Leetcode_weekly_14802 lc = new Leetcode_weekly_14802();
    }
    int max = 0;
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        dfs(root, n, x);
        return max > n - max;
    }

    private int dfs(TreeNode root, int n, int x) {
        if(root == null) return 0 ;
        int l =  dfs(root.left, n, x);
        int r =  dfs(root.right, n, x);
        if(root.val == x) {
            max = Math.max(max, l);
            max = Math.max(max, r);
            max = Math.max(max, n - l - r - 1);
        }
        return l + r + 1;
    }
}
