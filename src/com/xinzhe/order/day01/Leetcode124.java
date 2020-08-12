package com.xinzhe.order.day01;

import com.xinzhe.categories.structure.tree.TreeNode;


/**
 * @author Xin
 * @date 2020/2/27 15:03
 * Title : 124. 二叉树中的最大路径和
 * Description : 给定一个非空二叉树，返回其最大路径和。
 *              本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 * link : https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/
 * Level : hard
 */
//todo need to review
public class Leetcode124 {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return max;
    }

    public int helper(TreeNode root){
        if(root == null) return 0;
        int left = Math.max(helper(root.left), 0);
        int right = Math.max(helper(root.right), 0);
        max = Math.max(max, root.val + left + right);
        return root.val + Math.max(left, right);
    }
}
