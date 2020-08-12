package com.xinzhe.order.day03;

import com.xinzhe.categories.structure.tree.TreeNode;

/**
 * @author Xin
 * @date 2020/2/27 16:20
 * Title : 450. 删除二叉搜索树中的节点
 * Description : 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
 *               一般来说，删除节点可分为两个步骤：
 *                  首先找到需要删除的节点；
 *                  如果找到了，删除它。
 * link : https://leetcode-cn.com/problems/delete-node-in-a-bst
 * Level : Medium
 */

//Todo: need to review
public class Leetcode450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        if(key < root.val){
            root.left =  deleteNode(root.left, key);
        } else if(key > root.val){
            root.right = deleteNode(root.right, key);
        } else {
            if(root.left == null){
                return root.right;
            } else if(root.right == null){
                return root.left;
            } else {
                TreeNode node = root.right;
                while(node.left != null) {
                    node = node.left;
                }
                node.left = root.left;
                return root.right;
            }
        }
        return root;
    }
}
