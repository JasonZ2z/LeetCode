package com.xinzhe.categories.solutions.dfs;


import com.xinzhe.categories.structure.tree.TreeNode;

/**
 * @Author Xin
 * @create 2020/3/30 13:23
 * Title : 111. 二叉树的最小深度
 * Description : 给定一个二叉树，找出其最小深度。最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 说明: 叶子节点是指没有子节点的节点。
 * link : https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 * Level : Easy
 */

public class Leetcode111 {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if(left == 0 || right == 0) return left + right +1;
        return Math.min(left, right) +1;
    }
}
