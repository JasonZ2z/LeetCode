package com.xinzhe.categories.solutions.dfs.medium;

import com.xinzhe.categories.structure.tree.TreeNode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author Xin
 * @create 2020/4/1 18:37
 * Title : 105. 从前序与中序遍历序列构造二叉树
 * Description : 根据一棵树的前序遍历与中序遍历构造二叉树。你可以假设树中没有重复的元素。
 *      前序遍历 preorder = [3,9,20,15,7]
 *      中序遍历 inorder = [9,3,15,20,7]
 * link : https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * Level : Medium
 */

public class Leetcode105 {
    private static List<Integer> pre;
    private static List<Integer> in;
    private static int n;
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        n = preorder.length;
        if(n == 0) return null;
        pre = Arrays.stream(preorder).boxed().collect(Collectors.toList());
        in = Arrays.stream(inorder).boxed().collect(Collectors.toList());
        return helper(0, n-1, 0, n-1);
    }

    public static TreeNode helper(int start, int end, int left, int right){
        if(start > end || left > right ) return null;
        System.out.println(start + " " + end);
        int value = pre.get(start);

        TreeNode node = new TreeNode(value);
        int index = in.indexOf(value) - left;

        node.left = helper(start+1, start+index, left, left+index-1);
        node.right = helper(start+index+1, end, left+index+1, right);
        return node;
    }
}
