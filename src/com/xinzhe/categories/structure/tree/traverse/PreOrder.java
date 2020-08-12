package com.xinzhe.categories.structure.tree.traverse;

import com.xinzhe.categories.structure.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Xin
 * @date 2020/2/18 16:46
 */

/**
 * 前序遍历：根左右
 */
public class PreOrder {
    private static List<Integer> list = new ArrayList<>();
    /**
     *  递归
     */
    public List<Integer> preOrderRecur(TreeNode root) {
        traversal(root);
        return list;
    }
    public void traversal(TreeNode root){
        if(root == null) return;
        list.add(root.val);
        traversal(root.left);
        traversal(root.right);
    }

    /**
     * 非递归
     */
    public List<Integer> preOrderTraversal(TreeNode root) {
        if(root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode tmp = stack.pop();
            list.add(tmp.val);
            if(tmp.right != null){
                stack.push(tmp.right);
            }
            if(tmp.left != null) {
                stack.push(tmp.left);
            }
        }
        return list;
    }

    public static List<Integer> preOrderTraversal2(TreeNode root) {
        if(root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while(!stack.isEmpty() || node != null){
            if(node != null){
                list.add(node.val);
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                node = node.right;
            }
        }
        return list;
    }

    public static void printTree(TreeNode node) {
        System.out.println(preOrderTraversal2(node).toString());
    }
}
