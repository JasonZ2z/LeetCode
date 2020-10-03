package com.xinzhe.contest.weekly.season03.weekly127;

import com.xinzhe.categories.structure.tree.TreeNode;
import com.xinzhe.categories.structure.tree.traverse.LevelOrder;

/**
 * @author Xin
 * @date 2020/9/22
 * Title : 1008. 先序遍历构造二叉树
 * Description : 返回与给定先序遍历 preorder 相匹配的二叉搜索树（binary search tree）的根结点。
 * link : https://leetcode-cn.com/problems/construct-binary-search-tree-from-preorder-traversal
 * Level : Hard
 */

public class Leetcode_weekly_12704 {
    public static void main(String[] args) {
        Leetcode_weekly_12704 lc = new Leetcode_weekly_12704();
        int[] arr = {8,5,1,7,10,12};
        LevelOrder.printTree(lc.bstFromPreorder(arr));
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder, 0, preorder.length-1);
    }

    public TreeNode helper(int[] arr, int left, int right) {
        if(left > right) return null;
        if(left == right) return new TreeNode(arr[left]);
        int s = left;
        while(s <= right) {
            if(arr[s] > arr[left]) break;
            s++;
        }
        if(s ==  right + 1) return new TreeNode(arr[left], helper(arr, left + 1, right), null);
        if(s == left + 1) return new TreeNode(arr[left], null, helper(arr, s, right));
        return new TreeNode(arr[left], helper(arr, left + 1, s-1), helper(arr, s, right));
    }
}
