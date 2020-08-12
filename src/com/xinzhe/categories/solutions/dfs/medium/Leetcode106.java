package com.xinzhe.categories.solutions.dfs.medium;

import com.xinzhe.categories.structure.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Xin
 * @date 2020/4/2 19:37
 * Title : 106. 从中序与后序遍历序列构造二叉树
 * Description : 根据一棵树的中序遍历与后序遍历构造二叉树。你可以假设树中没有重复的元素。
 *      中序遍历 inorder = [9,3,15,20,7]
 *      后序遍历 postorder = [9,15,7,20,3]
 * link : https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 * Level : Medium
 */

//todo need to review
public class Leetcode106 {
    private int[] postorder;
    private Map<Integer, Integer> map;
    public TreeNode buildTree(int[] postorder, int[] inorder) {
        this.postorder = postorder;
        int n = postorder.length;
        map = new HashMap<>(n);
        for (int i = 0; i < n; ++i) {
            map.put(inorder[i], i);
        }
        return helper(0, n-1, 0, n-1);
    }

    private TreeNode helper(int postLeft, int postRight, int inLeft, int inRight) {
        if(postLeft > postRight || inLeft > inRight) return null;
        int value = postorder[postRight];
        TreeNode node = new TreeNode(value);
        int index = map.get(value) - inLeft;
        node.left = helper(postLeft, postLeft + index -1, inLeft, inLeft + index -1);
        node.right = helper(index + postLeft, postRight-1, index+inLeft + 1, inRight);
        return node;
    }
}
