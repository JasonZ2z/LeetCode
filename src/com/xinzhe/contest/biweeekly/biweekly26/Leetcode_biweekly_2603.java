package com.xinzhe.contest.biweeekly.biweekly26;

import com.xinzhe.categories.structure.tree.TreeNode;

/**
 * @Author Xin
 * @create 2020/5/16
 * Title : 1448. 统计二叉树中好节点的数目
 * Description : 给你一棵根为 root 的二叉树，请你返回二叉树中好节点的数目。「好节点」X 定义为：从根到该节点 X 所经过的节点中，没有任何节点的值大于 X 的值。
 * link : https://leetcode-cn.com/problems/count-good-nodes-in-binary-tree/
 * Level : Medium
 */

public class Leetcode_biweekly_2603 {
    private int count = 0;

    public int goodNodes(TreeNode root) {
        helper(root, Integer.MIN_VALUE);
        return count;
    }

    public void helper(TreeNode root, int max) {
        if (root == null) return;
        if (root.val > max) {
            count++;
            helper(root.left, root.val);
            helper(root.right, root.val);
        } else {
            helper(root.left, max);
            helper(root.right, max);
        }
    }
}
