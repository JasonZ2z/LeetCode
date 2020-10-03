package com.xinzhe.contest.weekly.season03.weekly132;

import com.xinzhe.categories.structure.tree.TreeNode;

/**
 * @author Xin
 * @date 2020/9/10
 * Title : 1026. 节点与其祖先之间的最大差值
 * Description : 给定二叉树的根节点 root，找出存在于不同节点 A 和 B 之间的最大值 V，其中 V = |A.val - B.val|，且 A 是 B 的祖先。
 *              （如果 A 的任何子节点之一为 B，或者 A 的任何子节点是 B 的祖先，那么我们认为 A 是 B 的祖先）
 * link : https://leetcode-cn.com/problems/maximum-difference-between-node-and-ancestor
 * Level : Medium
 */

public class Leetcode_weekly_13202 {
    public static void main(String[] args) {
        Leetcode_weekly_13202 lc = new Leetcode_weekly_13202();
    }
    int res = 0;
    public int maxAncestorDiff(TreeNode root) {
        helper(root, root.val, root.val);
        return res;
    }

    public void helper(TreeNode root, int max, int min) {
        res = Math.max(res, max - min);
        if(root == null) return;
        max = Math.max(root.val, max);
        min = Math.min(root.val, min);
        helper(root.left, max, min);
        helper(root.right, max, min);
    }
}
