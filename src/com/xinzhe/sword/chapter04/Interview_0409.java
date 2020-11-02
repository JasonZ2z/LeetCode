package com.xinzhe.sword.chapter04;

import com.xinzhe.categories.structure.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Xin
 * @date 2020/11/02
 * Title : 04.09. 二叉搜索树序列
 * Description : 从左向右遍历一个数组，通过不断将其中的元素插入树中可以逐步地生成一棵二叉搜索树。给定一个由不同节点组成的二叉搜索树，输出所有可能生成此树的数组。
 * link : https://leetcode-cn.com/problems/bst-sequences-lcci/
 * Level : Hard
 */
//todo need to review
public class Interview_0409 {
    public static void main(String[] args) {
        Interview_0409 lc = new Interview_0409();
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(0);
        System.out.println(lc.BSTSequences(root));
    }

    public List<List<Integer>> BSTSequences(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if(root == null){
            res.add(new ArrayList<>());
            return res;
        }
        List<List<Integer>> left = BSTSequences(root.left);
        List<List<Integer>> right = BSTSequences(root.right);
        for (List<Integer> l : left) {
            for (List<Integer> r : right) {
                if(l.isEmpty()) {
                    r.add(0, root.val);
                    res.add(r);
                } else if(r.isEmpty()) {
                    l.add(0, root.val);
                    res.add(l);
                } else {
                    LinkedList<Integer> list = new LinkedList<>();
                    list.add(root.val);
                    merge(l, 0, r, 0, list, res);
                }

            }
        }
        return res;
    }

    private void merge(List<Integer> l, int i, List<Integer> r, int j, LinkedList<Integer> list, List<List<Integer>> res) {
        if(i == l.size() && j == r.size()) {
            res.add(new ArrayList<>(list));
            return;
        }
        if(i < l.size()) {
            list.addLast(l.get(i));
            merge(l, i+1, r, j, list, res);
            list.removeLast();
        }
        if(j < r.size()) {
            list.addLast(r.get(j));
            merge(l, i, r, j+1, list, res);
            list.removeLast();
        }
    }

}
