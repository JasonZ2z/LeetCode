package com.xinzhe.categories.structure.tree.traverse;

import com.xinzhe.categories.structure.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Xin
 * @date 2020/2/18 16:47
 */
public class PostOrder {
    private static List<Integer> list = new ArrayList<>();
    public List<Integer> postOrder(TreeNode root){
        postOrderRecur(root);
        return list;
    }

    private void postOrderRecur(TreeNode root) {
        if(root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        list.add(root.val);
    }
    //左右中
    //中右左
    public static List<Integer> postOrderTraversal(TreeNode root){
        if(root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while(!stack.isEmpty() || node != null ){
            if(node != null){
                stack.push(node);
                list.add(0, node.val);
                node = node.right;
            } else {
                node = stack.pop();
                node = node.left;
            }
        }
        return list;
    }

    public static void printTree(TreeNode node) {
        System.out.println(postOrderTraversal(node).toString());
    }
}
