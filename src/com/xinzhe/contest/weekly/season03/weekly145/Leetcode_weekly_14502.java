package com.xinzhe.contest.weekly.season03.weekly145;

import com.xinzhe.categories.structure.tree.TreeNode;

/**
 * @author Xin
 * @date 2020/8/23
 * Title : 1123. 最深叶节点的最近公共祖先
 * Description : 给你一个有根节点的二叉树，找到它最深的叶节点的最近公共祖先。
 * link : https://leetcode-cn.com/problems/lowest-common-ancestor-of-deepest-leaves/
 * Level : Medium
 */

public class Leetcode_weekly_14502 {

    public static void main(String[] args) {
        Leetcode_weekly_14502 lc = new Leetcode_weekly_14502();
    }

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if(root == null) return null;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        if(left == right) return root;
        else if(left > right) return lcaDeepestLeaves(root.left);
        else return lcaDeepestLeaves(root.right);
    }

    private int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }


}
