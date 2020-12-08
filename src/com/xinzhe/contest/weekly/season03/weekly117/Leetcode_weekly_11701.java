package com.xinzhe.contest.weekly.season03.weekly117;

import com.xinzhe.categories.structure.tree.TreeNode;

/**
 * @author Xin
 * @date 2020/12/08
 * Title : 965. 单值二叉树
 * Description : 如果二叉树每个节点都具有相同的值，那么该二叉树就是单值二叉树。只有给定的树是单值二叉树时，才返回 true；否则返回 false。
 * link : https://leetcode-cn.com/problems/univalued-binary-tree/
 * Level : Easy
 */

public class Leetcode_weekly_11701 {
    public static void main(String[] args) {
        Leetcode_weekly_11701 lc = new Leetcode_weekly_11701();
        int[][] arr = {{1,3}, {-2,2}};
    }
    public boolean isUnivalTree(TreeNode root) {
        if(root == null) return true;
        return helper(root, root.val);
    }

    private boolean helper(TreeNode root, int val) {
        if(root == null) return true;
        return (root.val != val) && helper(root.left, val) && helper(root.right, val);

    }
}
