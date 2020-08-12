package com.xinzhe.categories.structure.tree.easy;

import com.xinzhe.categories.structure.tree.TreeNode;

/**
 * @author Xin
 * @date 2020/3/10 18:22
 * Title : 543. 二叉树的直径
 * Description : 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过根结点。
 * link : https://leetcode-cn.com/problems/diameter-of-binary-tree/
 * Level : Easy
 */
public class Leetcode543 {
    private int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        int result = helper(root);
        return Math.max(max, result);
    }

    private int helper(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) {
            return 0;
        }
        int right = helper(root.right);
        int left = helper(root.left);
        max = Math.max(max, right + left);
        return Math.max(right, left) + 1;
    }
}
