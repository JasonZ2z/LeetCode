package com.xinzhe.order.day01;

import com.xinzhe.categories.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Xin
 * @create 2020/2/27 15:33
 * Title : 257. 二叉树的所有路径
 * Description : 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 * link : https://leetcode-cn.com/problems/binary-tree-paths/
 * Level : Easy
 */
public class Leetcode257 {
    private List<String> list = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        helper(root, "");
        return list;
    }

    private void helper(TreeNode root, String s) {
        if(root == null) return;
        StringBuilder sb = new StringBuilder(s);
        sb.append(root.val);
        if(root.left == null && root.right == null){
            list.add(sb.toString());
        } else {
            sb.append("->");
            helper(root.left, sb.toString());
            helper(root.right, sb.toString());
        }

    }
}
