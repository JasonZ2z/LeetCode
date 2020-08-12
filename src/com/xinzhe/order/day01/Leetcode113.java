package com.xinzhe.order.day01;

import com.xinzhe.categories.structure.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Xin
 * @date 2020/2/27 11:32
 * Title : 113. 路径总和 II
 * Description : 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 *              说明: 叶子节点是指没有子节点的节点。
 * link : https://leetcode-cn.com/problems/path-sum-ii/
 * Level : Medium
 */
public class Leetcode113 {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        helper(root, sum, new ArrayList<>());
        return result;
    }

    private void helper(TreeNode root, int sum, List<Integer> list) {
        if(root == null) return;
        sum -= root.val;

        List<Integer> newList = new ArrayList<>(list);
        newList.add(root.val);
        if(sum == 0 && root.left == null && root.right == null){
            result.add(newList);
        }
        helper(root.left, sum, newList);
        helper(root.right, sum, newList);
        newList.remove(newList.size()-1);
    }
}
