package com.xinzhe.sword.chapter04;

import com.xinzhe.categories.structure.tree.TreeNode;

/**
 * @author Xin
 * @date 2020/10/23
 * Title : 04.04. 检查平衡性
 * Description : 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *              本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * link : https://leetcode-cn.com/problems/balanced-binary-tree/
 * Level : Easy
 */

public class Interview_0404 {
    public boolean isBalanced(TreeNode root) {
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
