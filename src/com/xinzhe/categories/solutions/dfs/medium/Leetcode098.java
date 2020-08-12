package com.xinzhe.categories.solutions.dfs.medium;

import com.xinzhe.categories.structure.tree.TreeNode;

/**
 * @author Xin
 * @date 2020/4/1 18:37
 * Title : 98. 验证二叉搜索树
 * Description : 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *      假设一个二叉搜索树具有如下特征：
 *              节点的左子树只包含小于当前节点的数。
 *              节点的右子树只包含大于当前节点的数。
 *              所有左子树和右子树自身必须也是二叉搜索树。
 * link : https://leetcode-cn.com/problems/validate-binary-search-tree
 * Level : Medium
 */

public class Leetcode098 {
    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }

    public boolean helper(TreeNode root, long max, long min){
        if(root == null) return true;
        if(root.val >= max || root.val <= min) return false;
        return helper(root.left, root.val, min) && helper(root.right, max, root.val);
    }
}
