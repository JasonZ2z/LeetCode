package com.xinzhe.contest.biweeekly.s1.biweekly16;

import com.xinzhe.categories.structure.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Xin
 * @date 2020/5/29
 * Title : 1302. 层数最深叶子节点的和
 * Description : 给你一棵二叉树，请你返回层数最深的叶子节点的和。
 * link : https://leetcode-cn.com/problems/deepest-leaves-sum/
 * Level : Medium
 * Comment 16双周赛03
 */

public class Leetcode_biweekly_1603 {
    List<List<Integer>> list = new ArrayList<>();

    public int deepestLeavesSum(TreeNode root) {
        level(root, 0);
        return list.get(list.size() - 1).stream().mapToInt(Integer::intValue).sum();
    }

    private void level(TreeNode root, int i) {
        if (root == null) return;
        if (list.size() <= i) {
            list.add(new ArrayList<>());
        }
        list.get(i).add(root.val);
        level(root.left, i + 1);
        level(root.right, i + 1);
    }
}
