package com.xinzhe.categories.structure.tree.traverse;

import com.xinzhe.categories.structure.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Xin
 * @date 2020/2/18 16:47
 */

/**
 * 中序遍历：左跟右
 */
public class InOrder {
    private static List<Integer> list = new ArrayList<>();

    /**
     * 递归方式
     */
    public List<Integer> inOrderRecur(TreeNode root){
        traversal(root);
        return list;
    }

    private void traversal(TreeNode root) {
        if(root == null) return;
        traversal(root.left);
        list.add(root.val);
        traversal(root.right);
    }
    /**
     * 非递归
     */
    //todo need to review
    public static List<Integer> inOrderTraversal(TreeNode root){
        if(root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while(!stack.isEmpty() || node != null){
            if(node != null){
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                list.add(node.val);
                node = node.right;
            }
        }
        return list;

    }
    //Morris
    public static List<Integer> inOrderTraversal3(TreeNode root){
        TreeNode cur = root;
        while(cur != null) {
            if(cur.left == null) {
                list.add(cur.val);
                cur = cur.right;
            } else {
                TreeNode pre = cur.left;
                while(pre.right != null && pre.right != cur) {
                    pre = pre.right;
                }
                if(pre.right == cur) {
                    pre.right = null;
                    cur = cur.right;
                } else {
                    pre.right = cur;
                    cur= cur.left;
                }
            }
        }
        return list;
    }

    public static void printTree(TreeNode node) {
        System.out.println(inOrderTraversal(node).toString());
    }
}
