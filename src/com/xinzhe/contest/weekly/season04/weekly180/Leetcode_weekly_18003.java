package com.xinzhe.contest.weekly.season04.weekly180;

import com.xinzhe.categories.structure.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Xin
 * @date 2020/3/16 19:51
 * Title : 1382. 将二叉搜索树变平衡
 * Description : 给你一棵二叉搜索树，请你返回一棵 平衡后 的二叉搜索树，新生成的树应该与原来的树有着相同的节点值。
 *              如果一棵二叉搜索树中，每个节点的两棵子树高度差不超过 1 ，我们就称这棵二叉搜索树是 平衡的 。
 *              如果有多种构造方法，请你返回任意一种。
 * link : https://leetcode-cn.com/problems/balance-a-binary-search-tree
 * Level : Medium
 * Comment : 180周赛03
 */
public class Leetcode_weekly_18003 {
    List<Integer> list = new ArrayList<>();
    public TreeNode balanceBST(TreeNode root) {
        if(root == null) return root;
        inorder(root);
        System.out.println(list.toString());
        return helper(list, 0,list.size()-1);
    }

    private TreeNode helper(List<Integer> list, int start, int end) {
        if (start <= end){
            int mid = start + ((end - start) >> 1);
            TreeNode node = new TreeNode(list.get(mid));
            node.left = helper(list, start, mid-1);
            node.right = helper(list,mid+1, end);
            return node;
        }
        return null;
    }

    private void inorder(TreeNode root) {
        if(root == null) return;
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }


}
