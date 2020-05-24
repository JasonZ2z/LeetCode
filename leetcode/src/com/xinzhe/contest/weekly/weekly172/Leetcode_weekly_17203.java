package com.xinzhe.contest.weekly.weekly172;

import com.xinzhe.categories.structure.tree.TreeNode;

/**
 * @Author Xin
 * @create 2020/5/23
 * Title : 1325. 删除给定值的叶子节点
 * Description : 给你一棵以 root 为根的二叉树和一个整数 target ，请你删除所有值为 target 的 叶子节点 。
 * 注意，一旦删除值为 target 的叶子节点，它的父节点就可能变成叶子节点；如果新叶子节点的值恰好也是 target ，那么这个节点也应该被删除。
 * 也就是说，你需要重复此过程直到不能继续删除。
 * link : https://leetcode-cn.com/problems/delete-leaves-with-a-given-value
 * Level : Medium
 * Comment 172周赛03
 */

public class Leetcode_weekly_17203 {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        while (!iterate(root, target)) {
            root = deleteNode(root, target);
        }
        return root;
    }

    private TreeNode deleteNode(TreeNode root, int target) {
        if (root == null) return null;
        if (root.left == null && root.right == null) {
            if (root.val == target) return null;
            else return root;
        }
        root.left = deleteNode(root.left, target);
        root.right = deleteNode(root.right, target);
        return root;
    }

    private boolean iterate(TreeNode root, int target) {
        if (root == null) return true;
        if (root.left == null && root.right == null) {
            return root.val != target;
        }
        return iterate(root.left, target) && iterate(root.right, target);
    }

}
