package com.xinzhe.categories.solutions.dfs.easy;

import com.xinzhe.categories.structure.tree.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author Xin
 * @create 2020/3/30 13:34
 * Title : 107. 二叉树的层次遍历 II
 * Description : 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * link : https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/
 * Level : Easy
 */

public class Leetcode107 {
    private List<List<Integer>> res = new ArrayList<>();

    //用Java Collections.reverse()逆序
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        helper(root, 0);
        Collections.reverse(res);
        return res;
    }
    private void helper(TreeNode root, int level) {
        if(root == null) return;
        if(res.size() <= level){
            res.add(new ArrayList<>());
        }
        res.get(level).add(root.val);
        helper(root.left, level+1);
        helper(root.right, level+1);
    }

    //利用ArrayList add(int index, E element)
    //获取层数为 res.size()-level-1
    public List<List<Integer>> levelOrderBottom2(TreeNode root) {
        helper(root, 0);
        return res;
    }

    private void helper2(TreeNode root, int level) {
        if(root == null) return;
        if(res.size() <= level){
            res.add(0, new ArrayList<>());
        }
        res.get(res.size()-level-1).add(root.val);
        helper(root.left, level+1);
        helper(root.right, level+1);
    }

    //非递归写法
    public List<List<Integer>> levelOrderBottom3(TreeNode root){
        if(root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> list;
        while(!queue.isEmpty()){
            list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                TreeNode cur = queue.poll();
                list.add(cur.val);
                if(cur.left != null) queue.add(cur.left);
                if(cur.right != null) queue.add(cur.right);
            }
            res.add(0, list);
        }
        return res;
    }
}
