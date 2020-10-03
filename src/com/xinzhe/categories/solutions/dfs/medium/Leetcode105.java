package com.xinzhe.categories.solutions.dfs.medium;

import com.xinzhe.categories.structure.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Xin
 * @date 2020/4/1 18:37
 * Title : 105. 从前序与中序遍历序列构造二叉树
 * Description : 根据一棵树的前序遍历与中序遍历构造二叉树。你可以假设树中没有重复的元素。
 *      前序遍历 preorder = [3,9,20,15,7]
 *      中序遍历 inorder = [9,3,15,20,7]
 * link : https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * Level : Medium
 */

//todo need to review
public class Leetcode105 {
    private int[] preorder;
    private Map<Integer, Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        int n = preorder.length;
        map = new HashMap<>(n);
        for (int i = 0; i < n; ++i) {
            map.put(inorder[i], i);
        }
        return helper(0, n-1, 0, n-1);
    }

    private TreeNode helper(int preLeft, int preRight, int inLeft, int inRight) {
        if(preLeft >preRight || inLeft > inRight) return null;
        int value = preorder[preLeft];
        TreeNode node = new TreeNode(value);
        int index = map.get(value) - inLeft;
        node.left = helper(preLeft+1, preLeft+ index, inLeft, inLeft+ index-1);
        node.right = helper(index + preLeft + 1, preRight, index+inLeft + 1, inRight);
        return node;
    }
}
