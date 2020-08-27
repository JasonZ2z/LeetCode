package com.xinzhe.contest.weekly.season03.weekly135;

import com.xinzhe.categories.structure.tree.TreeNode;

/**
 * @author Xin
 * @date 2020/8/27
 * Title : 1038. 从二叉搜索树到更大和树
 * Description : 给出二叉 搜索 树的根节点，该二叉树的节点值各不相同，修改二叉树，使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和。
 * link : https://leetcode-cn.com/problems/binary-search-tree-to-greater-sum-tree/
 * Level : Medium
 */

//todo need to review
public class Leetcode_weekly_13502 {
    public static void main(String[] args) {
        Leetcode_weekly_13502 lc = new Leetcode_weekly_13502();
    }
    int pre = 0;
    public TreeNode bstToGst(TreeNode root) {
       if(root == null) return null;
       bstToGst(root.right);
       pre += root.val;
       root.val = pre;
       bstToGst(root.left);
       return root;
    }
}
