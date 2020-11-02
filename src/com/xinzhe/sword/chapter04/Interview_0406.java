package com.xinzhe.sword.chapter04;

import com.xinzhe.categories.structure.tree.TreeNode;

import java.util.Stack;

/**
 * @author Xin
 * @date 2020/11/02
 * Title : 04.06. 后继者
 * Description : 设计一个算法，找出二叉搜索树中指定节点的“下一个”节点（也即中序后继）。如果指定节点没有对应的“下一个”节点，则返回null。
 * link : https://leetcode-cn.com/problems/validate-binary-search-tree
 * Level : Medium
 */

public class Interview_0406 {
    public static void main(String[] args) {
        Interview_0406 lc = new Interview_0406();
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        System.out.println(lc.inorderSuccessor(root, new TreeNode(1)).val);
    }
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root == null || p == null ) return null;
        if(root == p) return root.right;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        boolean flag = false;
        while (!stack.isEmpty() || cur != null) {
            if(cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                if(flag) return cur;
                if(cur == p) flag = true;
                cur = cur.right;
            }
        }
        return null;
    }
    public TreeNode inorderSuccessor2(TreeNode root, TreeNode p) {
        TreeNode res = root;
        TreeNode tmp = root;
        while(tmp != null) {
            if(tmp.val <= p.val) {
                tmp = tmp.right;
            } else {
                res = tmp;
                tmp = tmp.left;
            }
        }
        return res.val <= p.val ? null : res;
    }

}
