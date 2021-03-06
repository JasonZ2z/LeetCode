package com.xinzhe.contest.biweeekly.s1.biweekly21;

import com.xinzhe.categories.structure.tree.TreeNode;

/**
 * @author Xin
 * @date 2020/5/14
 * Title : 1372. 二叉树中的最长交错路径
 * Description : 给你一棵以 root 为根的二叉树，二叉树中的交错路径定义如下：
 *          选择二叉树中 任意 节点和一个方向（左或者右）。
 *          如果前进方向为右，那么移动到当前节点的的右子节点，否则移动到它的左子节点。
 *          改变前进方向：左变右或者右变左。
 *          重复第二步和第三步，直到你在树中无法继续移动。
 *          交错路径的长度定义为：访问过的节点数目 - 1（单个节点的路径长度为 0 ）。请你返回给定树中最长 交错路径 的长度。
 * Level : Medium
 * Comment 21双周赛03
 */

public class Leetcode_biweekly_2103 {
    int max = 0;

    public int longestZigZag(TreeNode root) {
        if (root == null) return max;
        longestZigZag(root, true);
        //longestZigZag(root, false);
        return max;

    }

    public int longestZigZag(TreeNode root, boolean flag) {
        if (root == null) return 0;
        int left = longestZigZag(root.left, true);
        int right = longestZigZag(root.right, false);
        max = Math.max(max, Math.max(left, right));
        if (flag) {
            return right + 1;
        } else {
            return left + 1;
        }
    }

}
