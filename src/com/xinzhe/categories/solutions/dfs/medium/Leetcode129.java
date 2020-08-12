package com.xinzhe.categories.solutions.dfs.medium;

import com.xinzhe.categories.structure.tree.TreeNode;

/**
 * @author Xin
 * @date 2020/4/3 14:53
 * Title : 129. 求根到叶子节点数字之和
 * Description : 给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
 *              例如，从根到叶子节点路径 1->2->3 代表数字 123。
 *              计算从根到叶子节点生成的所有数字之和。
 * link : https://leetcode-cn.com/problems/sum-root-to-leaf-numbers
 * Level : medium
 */
public class Leetcode129 {
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        helper(root, 0);
        return sum;
    }

    private void helper(TreeNode root, int pre) {
        if(root == null) return;
        int cur = pre*10 + root.val;
        if(root.left == null && root.right == null){
            sum += cur;
        }
        helper(root.left , cur);
        helper(root.right , cur);
    }


}
