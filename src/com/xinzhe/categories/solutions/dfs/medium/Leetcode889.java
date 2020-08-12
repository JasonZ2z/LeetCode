package com.xinzhe.categories.solutions.dfs.medium;

import com.xinzhe.categories.structure.tree.TreeNode;
import com.xinzhe.categories.structure.tree.traverse.PreOrder;

/**
 * @Author Xin
 * @create 2020/8/7
 * Title : 889. 根据前序和后序遍历构造二叉树
 * Description : 返回与给定的前序和后序遍历匹配的任何二叉树。pre 和 post 遍历中的值是不同的正整数。
 * link : https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/
 * Level : Medium
 */

//todo need to review
public class Leetcode889 {
    public static void main(String[] args) {
        Leetcode889 lc = new Leetcode889();
        int[] pre = {1,2,4,5,3,6,7};
        int[] post = {4,5,2,6,7,3,1};
        TreeNode node = lc.constructFromPrePost(pre, post);
        PreOrder.printTree(node);
    }
    int[] pre;
    int[] post;
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        this.pre = pre;
        this.post = post;
        int n = pre.length;
        return helper(0, n-1, 0 , n-1);
    }
    public TreeNode helper(int preLeft, int preRight, int postLeft, int postRight) {
        if(preLeft > preRight || postLeft > postRight) return null;
        if(preLeft == preRight) return new TreeNode(pre[preLeft]);
        TreeNode root = new TreeNode(post[postRight]);
        int i = preLeft;
        for(; i<= preRight; i++) {
            if(pre[i] == post[postRight-1]){
                break;
            }
        }
        int len = i-1 - preLeft;
        root.left = helper(preLeft+1, i-1, postLeft, postLeft + len - 1);
        root.right = helper(i, preRight, postLeft+len, postRight-1);
        return root;
    }
}
