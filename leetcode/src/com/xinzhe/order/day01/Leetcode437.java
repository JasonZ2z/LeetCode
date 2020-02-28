package com.xinzhe.order.day01;

import com.xinzhe.categories.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author Xin
 * @create 2020/2/26 13:53
 * Title : 437. 路径总和 III
 * Description : 给定一个二叉树，它的每个结点都存放着一个整数值。
 *              找出路径和等于给定数值的路径总数。
 *              路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 * link : https://leetcode-cn.com/problems/path-sum-iii
 * Level : easy
 */
public class Leetcode437 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        System.out.println(pathSum(root, 1));
    }
    public static int pathSum(TreeNode root, int sum) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        return helper(root, sum, list);
    }

    private static int helper(TreeNode root, int sum, List<Integer> list) {
        if(root == null) return 0;
        List<Integer> newList = new ArrayList<>(list);
        int tmp = list.get(list.size()-1) + root.val;
        newList.add(tmp);
        int count = 0;
        for (int i = list.size()-1; i >= 0; i--) {
            if(tmp - list.get(i) == sum){
                count++;
            }
        }
        int left = helper(root.left, sum, newList);
        int right = helper(root.right, sum, newList);
        return  count+ left +right;
    }
}
