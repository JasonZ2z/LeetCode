package com.xinzhe.contest.weekly.season04.weekly174;

import com.xinzhe.categories.structure.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Xin
 * @date 2020/5/20
 * Title : 1339. 分裂二叉树的最大乘积
 * Description : 给你一棵二叉树，它的根为 root 。请你删除 1 条边，使二叉树分裂成两棵子树，且它们子树和的乘积尽可能大。由于答案可能会很大，请你将结果对 10^9 + 7 取模后再返回。
 * link : https://leetcode-cn.com/problems/maximum-product-of-splitted-binary-tree
 * Level : Medium
 * Comment 174周赛03
 */

public class Leetcode_weekly_17403 {

    static final int MOD = (int) (1e9 + 7);

    Map<TreeNode, Double> map = new HashMap<>();
    double max = 0;

    public int maxProduct(TreeNode root) {
        double total = getSum(root);
        for (Double i : map.values()) {
            max = Math.max(max, i * (total - i));
        }
        return (int) (max % MOD);
    }

    private double getSum(TreeNode root) {
        if (root == null) return 0;
        double val = root.val + getSum(root.left) + getSum(root.right);
        map.put(root, val);
        return val;
    }


}
