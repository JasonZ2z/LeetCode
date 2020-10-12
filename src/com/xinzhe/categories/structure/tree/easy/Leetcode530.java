package com.xinzhe.categories.structure.tree.easy;

import com.xinzhe.categories.structure.tree.TreeNode;

/**
 * @author Xin
 * @date 2020/10/12
 * Title : 530. 二叉搜索树的最小绝对差
 * Description : 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
 * link : https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/
 * Level : Easy
 */
public class Leetcode530 {
    TreeNode pre = null;
    int min = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        helper(root);
        return min;
    }
    private void helper(TreeNode root) {
        if(root == null) return;
        helper(root.left);
        if(pre != null) min = Math.min(root.val - pre.val, min);
        pre = root;
        helper(root.right);
    }
}
