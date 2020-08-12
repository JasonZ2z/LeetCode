package com.xinzhe.categories.solutions.bfs.medium;

import com.xinzhe.categories.structure.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Xin
 * @date 2020/3/31 16:45
 * Title : 103. 二叉树的锯齿形层次遍历
 * Description : 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * link : https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/
 * Level : Medium
 */

public class Leetcode103 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) return res;
        helper(root,0, true);
        return res;
    }
    //递归
    private void helper(TreeNode root, int level, boolean flag) {
        if(root == null) return;
        if(level >= res.size()){
            res.add(new ArrayList<>());
        }
        if(flag){
            res.get(level).add(root.val);
        } else {
            res.get(level).add(0, root.val);
        }

        helper(root.left, level+1, !flag);
        helper(root.right, level+1, !flag);
    }

    public List<List<Integer>> levelOrder2(TreeNode root){
        if(root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean flag = true;
        while (!queue.isEmpty()){
            int size = queue.size();
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; ++i) {
                TreeNode node = queue.poll();
                if(flag){
                    list.add(node.val);
                }else {
                    list.add(0, node.val);
                }
                if(node.left != null){ queue.offer(node.left); }
                if(node.right != null){ queue.offer(node.right); }
            }
            flag = !flag;
            res.add(list);
        }
        return res;
    }
}
