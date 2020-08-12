package com.xinzhe.categories.structure.tree.medium;

import com.xinzhe.categories.structure.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Xin
 * @date 2020/5/10
 * Title : 236. 二叉树的最近公共祖先
 * Description : 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * link : https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree
 * Level : Medium
 */
public class Leetcode236 {
    //回溯
    List<TreeNode> list = new ArrayList<>();
    List<TreeNode> qlist;
    List<TreeNode> plist;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        traverse(root, p, q);
        int i = 0;
        while (i < plist.size() && i < qlist.size() && plist.get(i) == qlist.get(i)) {
            i++;
        }
        return qlist.get(i-1);
    }

    private void traverse(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return;
        list.add(root);
        if(root == p) plist = new ArrayList<>(list);
        if(root == q) qlist = new ArrayList<>(list);
        traverse(root.left, p, q);
        traverse(root.right, p, q);
        list.remove(list.size()-1);
    }
    //递归
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor2(root.left, p, q);
        TreeNode right = lowestCommonAncestor2(root.right, p, q);
        if(left != null && right != null) return root;
        return left == null ? right : left;
    }

}
