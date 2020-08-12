package com.xinzhe.categories.solutions.dfs.medium;

import com.xinzhe.categories.structure.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Xin
 * @date 2020/3/30 21:39
 * Title : 112. 路径总和
 * Description : 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 *              说明: 叶子节点是指没有子节点的节点。
 * link : https://leetcode-cn.com/problems/path-sum/
 * Level : Easy
 */

public class Leetcode113 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        helper(root, new ArrayList<>(), sum);
        return res;
    }

    public void helper(TreeNode root, ArrayList<Integer> track, int sum){
        if(root == null) return;
        if(sum == root.val && root.left == null && root.right == null){
            ArrayList<Integer> tmp = new ArrayList<>(track);
            tmp.add(root.val);
            res.add(tmp);
        }
        track.add(root.val);
        sum -= root.val;
        helper(root.left, track, sum);
        helper(root.right, track, sum);
        track.remove(track.size()-1);

    }
}
