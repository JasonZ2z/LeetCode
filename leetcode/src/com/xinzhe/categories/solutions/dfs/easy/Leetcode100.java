package com.xinzhe.categories.solutions.dfs.easy;

import com.xinzhe.categories.structure.tree.TreeNode;

/**
 * @Author Xin
 * @create 2020/3/30 11:33
 * Title : 100. 相同的树
 * Description : 给定两个二叉树，编写一个函数来检验它们是否相同。如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 * link : https://leetcode-cn.com/problems/same-tree/
 * Level : Easy
 */

public class Leetcode100 {
    public boolean isSameTree(TreeNode left, TreeNode right) {
        if(left == null && right == null) return true;
        if(left == null || right == null ) return false;
        return left.val == right.val && isSameTree(left.left, right.left) && isSameTree(left.right, right.right);
    }
}
