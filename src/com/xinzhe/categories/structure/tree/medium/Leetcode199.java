package com.xinzhe.categories.structure.tree.medium;

import com.xinzhe.categories.structure.tree.TreeNode;

import java.util.*;

/**
 * @author Xin
 * @date 2020/4/22
 * Title : 199. 二叉树的右视图
 * Description : 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * link : https://leetcode-cn.com/problems/binary-tree-right-side-view/
 * Level : Medium
 */

public class Leetcode199 {
    List<Integer> res = new ArrayList<>();
    //dfs
    public List<Integer> rightSideView(TreeNode root) {
        dfs(root, 0);
        return res;
    }

    private void dfs(TreeNode root, int high) {
        if(root == null) return;
        if(high == res.size()){
            res.add(root.val);
        }
        dfs(root.right, high+1);
        dfs(root.left, high+1);
    }

    //bfs
    public List<Integer> rightSideView2(TreeNode root) {
        if(root == null) return res;
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < size; ++i) {
                TreeNode cur = queue.poll();
                tmp.add(Objects.requireNonNull(cur).val);
                if(cur.left!= null) queue.add(cur.left);
                if(cur.right!= null) queue.add(cur.right);
            }
            list.add(tmp);
        }
        for (List<Integer> integers : list) {
            res.add(integers.get(integers.size()-1));
        }
        return res;
    }
}
