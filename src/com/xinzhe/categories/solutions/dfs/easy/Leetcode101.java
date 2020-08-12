package com.xinzhe.categories.solutions.dfs.easy;

import com.xinzhe.categories.structure.tree.TreeNode;

/**
 * @author Xin
 * @date 2020/3/30 11:33
 * Title : 101. 对称二叉树
 * Description : 给定一个二叉树，检查它是否是镜像对称的。
 * link : https://leetcode-cn.com/problems/symmetric-tree/
 * Level : Easy
 */

public class Leetcode101 {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return helper(root.left, root.right);
    }
    private boolean helper(TreeNode left, TreeNode right) {

        if(left == null && right == null) return true;
        if(left == null || right == null ) return false;
        if(left.val != right.val) return false;
        return helper(left.left, right.right) && helper(left.right, right.left);
    }
}
