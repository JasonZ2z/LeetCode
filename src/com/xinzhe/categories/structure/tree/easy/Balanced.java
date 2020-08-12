package com.xinzhe.categories.structure.tree.easy;

import com.xinzhe.categories.structure.tree.TreeNode;

/**
 * @Author Xin
 * @create 2020/2/19 9:25
 */
public class Balanced {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        return depth(root) != -1;
    }
    public int depth(TreeNode node){
        if(node == null) return 0;
        int left = depth(node.left);
        if(left < 0) return -1;
        int right = depth(node.right);
        if(right < 0) return -1;
        if(Math.abs(left - right) > 1) return -1;
        return Math.max(left, right)+1;
    }
}
