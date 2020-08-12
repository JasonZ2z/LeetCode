package com.xinzhe.categories.solutions.bfs.medium;

import com.xinzhe.categories.structure.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author Xin
 * @create 2020/3/31 16:39
 * Title : 102. 二叉树的层序遍历
 * Description : 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 * link : https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 * Level : Medium
 */

public class Leetcode102 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return res;
        helper(root,0);
        return res;
    }
    //递归
    private void helper(TreeNode root, int level) {
        if(root == null) return;
        if(level >= res.size()){
            res.add(new ArrayList<>());
        }
        res.get(level).add(root.val);
        helper(root.left, level+1);
        helper(root.right, level+1);
    }

    public List<List<Integer>> levelOrder2(TreeNode root){
        if(root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; ++i) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left != null){ queue.offer(node.left); }
                if(node.right != null){ queue.offer(node.right); }
            }
            res.add(list);
        }
        return res;
    }
}
