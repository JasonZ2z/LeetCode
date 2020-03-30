package com.xinzhe.categories.structure.tree.traverse;

import com.xinzhe.categories.structure.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author Xin
 * @create 2020/2/18 16:47
 */

/**
 * 中序遍历：跟左右
 */
public class Inorder {
    private List<Integer> list = new ArrayList<>();

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
    public List<Integer> inOrderTraversal(TreeNode root){
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
}
