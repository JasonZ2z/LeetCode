package com.xinzhe.categories.structure.tree.easy;

import com.xinzhe.categories.structure.tree.TreeNode;

/**
 * @author Xin
 * @date 2020/3/10 18:22
 * Title : 538. 把二叉搜索树转换为累加树
 * Description : 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 * link : https://leetcode-cn.com/problems/convert-bst-to-greater-tree
 * Level : Easy
 */
public class Leetcode538 {
    int pre = 0;
    public TreeNode convertBST(TreeNode root) {
        if(root == null) return root;
        convertBST(root.right);
        pre += root.val;
        root.val = pre;
        convertBST(root.left);
        return root;
    }
}
