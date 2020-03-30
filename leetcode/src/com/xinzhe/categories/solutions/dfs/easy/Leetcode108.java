package com.xinzhe.categories.solutions.dfs.easy;

import com.xinzhe.categories.structure.tree.TreeNode;

/**
 * @Author Xin
 * @create 2020/3/30 21:39
 * Title : 108. 将有序数组转换为二叉搜索树
 * Description : 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 *              本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * link : https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/
 * Level : Easy
 */
public class Leetcode108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        int n = nums.length;
        if(n == 0) return null;
        return helper(nums, 0, n-1);
    }

    private TreeNode helper(int[] nums, int start, int end) {
        TreeNode node = null;
        if(start <= end){
            int mid = start + ((end -start) >> 1);
            node = new TreeNode(nums[mid]);
            node.left = helper(nums, start, mid-1);
            node.right = helper(nums, mid+1, end);
        }
        return node;
    }
}
