package com.xinzhe.contest.weekly.season03.weekly125;

import com.xinzhe.categories.structure.tree.TreeNode;

/**
 * @author Xin
 * @date 2020/9/23
 * Title : 998. 最大二叉树 II
 * Description : 最大树定义：一个树，其中每个节点的值都大于其子树中的任何其他值。 给出最大树的根节点 root。
 *              就像之前的问题那样，给定的树是从表 A（root = Construct(A)）递归地使用下述 Construct(A) 例程构造的：...
 * link : https://leetcode-cn.com/problems/maximum-binary-tree-ii/
 * Level : Medium
 */

public class Leetcode_weekly_12503 {
    public static void main(String[] args) {
        Leetcode_weekly_12503 lc = new Leetcode_weekly_12503();
        int[] arr = {2,-3,-1,5,-4};
    }

    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if(root == null) return new TreeNode(val);
        if(val > root.val) {
            return new TreeNode(val, root, null);
        } else {
            root.right = insertIntoMaxTree(root.right, val);
            return root;
        }
    }
}
