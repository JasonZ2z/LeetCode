package com.xinzhe.categories.solutions.bfs.medium;

import com.xinzhe.categories.structure.tree.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Xin
 * @date 2020/3/31 16:34
 * Title : 429. N叉树的层序遍历
 * Description : 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
 * link : https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/
 * Level : Medium
 */

public class Leetcode429 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> levelOrder(Node root) {
        if(root == null) return res;
        helper(root,0);
        return res;
    }
    //递归
    private void helper(Node root, int level) {
        if(root == null) return;
        if(level >= res.size()){
            res.add(new ArrayList<>());
        }
        res.get(level).add(root.val);
        for (Node child : root.children) {
            helper(child, level+1);
        }
    }

    public List<List<Integer>> levelOrder2(Node root){
        if(root == null) return res;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; ++i) {
                Node node = queue.poll();
                list.add(node.val);
                if(node.children != null){
                    for (Node child : node.children) {
                        queue.offer(child);
                    }
                }
            }
            res.add(list);
        }
        return res;
    }
}
