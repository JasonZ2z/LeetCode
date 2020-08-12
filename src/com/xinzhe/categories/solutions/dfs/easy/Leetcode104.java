package com.xinzhe.categories.solutions.dfs.easy;

import com.xinzhe.categories.structure.tree.TreeNode;

/**
 * @author Xin
 * @date 2020/3/30 21:34
 * Title : 104. 二叉树的最大深度
 * Description : 给定一个二叉树，找出其最大深度。二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *              说明: 叶子节点是指没有子节点的节点。
 * link : https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 * Level : Easy
 */
public class Leetcode104 {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int left= maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right)+1;
    }
}
