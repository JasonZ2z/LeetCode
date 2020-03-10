package com.xinzhe.categories.tree.easy;

import com.xinzhe.categories.tree.TreeNode;

/**
 * @Author Xin
 * @create 2020/3/10 18:32
 * Title : 面试题 04.02. 最小高度树
 * Description : 给定一个有序整数数组，元素各不相同且按升序排列，编写一个算法，创建一棵高度最小的二叉搜索树。
 * link : https://leetcode-cn.com/problems/minimum-height-tree-lcci/
 * Level : Easy
 */
public class Leetcode_interview_0402 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length-1);
    }

    private TreeNode helper(int[] nums, int start, int end) {
        if(start == end) {
            return new TreeNode(nums[start]);
        } else if(start < end){
            int mid = start + ((end-start)>>1) ;
            TreeNode head = new TreeNode(nums[mid]);
            head.left = helper(nums, start, mid-1);
            head.right = helper(nums, mid+1, end);
            return head;
        }else {
            return null;
        }
    }
}
