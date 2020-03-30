package com.xinzhe.categories.solutions.dfs.easy;

import com.xinzhe.categories.structure.tree.TreeNode;

/**
 * @Author Xin
 * @create 2020/3/30 21:39
 * Title : 112. 路径总和
 * Description : 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 *              说明: 叶子节点是指没有子节点的节点。
 * link : https://leetcode-cn.com/problems/path-sum/
 * Level : Easy
 */

public class Leetcode112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        return helper(root) != -1;
    }

    private int helper(TreeNode root) {
        if(root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        if(left == -1 || right == -1 || Math.abs(left - right) > 1) return -1;
        return Math.max(left, right) +1;
    }
}
