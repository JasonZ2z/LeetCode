package com.xinzhe.order.day01;

import com.xinzhe.categories.structure.tree.TreeNode;

import java.util.Stack;

/**
 * @Author Xin
 * @create 2020/2/26 21:58
 * Title : 112. 路径总和
 * Description : 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 *               说明: 叶子节点是指没有子节点的节点。
 * link : https://leetcode-cn.com/problems/path-sum/
 * Level : Easy
 */

class Inner{
    public TreeNode node;
    public int val;
    public Inner (TreeNode node, int val){
        this.node = node;
        this.val = val;
    }
}
public class Leetcode112 {
    //迭代
    public boolean hasPathSum2(TreeNode root, int sum) {
        if(root == null) return false;
        Stack<Inner> stack = new Stack<>();
        stack.push(new Inner(root, root.val));
        while(!stack.isEmpty()){
            Inner cur = stack.pop();
            if(cur.node.left == null && cur.node.right == null && cur.val == sum){
                return true;
            }
            if(cur.node.left != null){
                stack.push(new Inner(cur.node.left, cur.val+cur.node.left.val));
            }
            if(cur.node.right != null){
                stack.push(new Inner(cur.node.right, cur.val+cur.node.right.val));
            }
        }
        return false;
    }


    //递归
    public boolean hasPathSum(TreeNode root, int sum) {
        return helper(root, sum);
    }

    public boolean helper(TreeNode root, int sum){
        if(root == null) return false;
        sum -= root.val;
        if(root.left == null && root.right == null && sum == 0) {
            return true;
        }
        return helper(root.left, sum) || helper(root.right,sum);
    }
}
