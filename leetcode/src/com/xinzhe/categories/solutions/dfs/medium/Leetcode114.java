package com.xinzhe.categories.solutions.dfs.medium;

import com.xinzhe.categories.structure.tree.TreeNode;

/**
 * @Author Xin
 * @create 2020/4/2 20:37
 * Title : 114. 二叉树展开为链表
 * Description : 给定一个二叉树，原地将它展开为链表。
 * link : https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
 * Level : Medium
 */
public class Leetcode114 {

    //思路：
    //1. 将左子树插入root右子树位置
    //2. 右子树插入左子树最右边节点的右子树位置
    //3. root -> root.right;
    public void flatten1(TreeNode root) {
        while (root != null){
            if(root.left == null){
                root = root.right;
            } else {

                TreeNode pre = root.left;
                while (pre.right != null){
                    pre = pre.right;
                }
                root.right = root.left;
                pre.right = root.right;
                root.left = null;
                root = root.right;
            }
        }
    }
    //改进的后续遍历  右左根
    //全局变量保存当前节点的右节点
    private TreeNode pre = null;
    public void flatten2(TreeNode root) {
        if(root == null) return;
        flatten2(root.right);
        flatten2(root.left);
        root.right = pre;
        root.left = null;
        pre = root;
    }

}
