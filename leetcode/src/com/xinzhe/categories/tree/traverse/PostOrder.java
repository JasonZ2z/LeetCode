package com.xinzhe.categories.tree.traverse;

import com.xinzhe.categories.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author Xin
 * @create 2020/2/18 16:47
 */
public class PostOrder {
    private List<Integer> list = new ArrayList<>();
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
    public List<Integer> postOrderTraversal(TreeNode root){
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
}
