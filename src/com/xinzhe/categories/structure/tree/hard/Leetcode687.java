package com.xinzhe.categories.structure.tree.hard;

import com.xinzhe.categories.structure.tree.TreeNode;

/**
 * @author Xin
 * @date 2020/4/23 21:33
 * Title : 687. 最长同值路径
 * Description : 给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。
 *              注意：两个节点之间的路径长度由它们之间的边数表示。
 * link : https://leetcode-cn.com/problems/longest-univalue-path/
 * Level : Easy
 */
public class Leetcode687 {
    int max = 0;
    public int longestUnivaluePath(TreeNode root) {
        if(root == null) return 0;
        helper(root, root.val);
        return max;
    }

    public int helper(TreeNode node, int val){
        if(node == null) return 0;
        int left = helper(node.left, node.val);
        int right = helper(node.right, node.val);
        max = Math.max(max, left+right);
        if(node.val == val) {
            return Math.max(left, right) + 1;
        }
        return 0;
    }
}
