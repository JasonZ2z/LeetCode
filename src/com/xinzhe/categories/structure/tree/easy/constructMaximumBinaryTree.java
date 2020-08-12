package com.xinzhe.categories.structure.tree.easy;

import com.xinzhe.categories.structure.tree.TreeNode;

public class constructMaximumBinaryTree {
    public static TreeNode constructMaximumBinary(int[] nums) {
        if(nums == null || nums.length == 0) {
            return new TreeNode(0);
        }
        return maxTree(nums, 0, nums.length-1);

    }
    public static TreeNode maxTree(int[] nums, int left, int right){
        int index = maxValue(nums, left, right);
        TreeNode root = new TreeNode(nums[index]);
        if(index == 0){
            root.right = maxTree(nums, 1, nums.length-1);
            return root;
        }
        if(index == nums.length -1){
            root.left = maxTree(nums, 0, index-1);
            return root;
        }
        root.left = maxTree(nums, 0, index-1);
        root.right = maxTree(nums, index+1, nums.length-1);
        return  root;

    }
    public static int maxValue(int[] nums, int left, int right){
        int max = Integer.MIN_VALUE;
        int i = left;
        for(;i<=right;i++){
            if(nums[i] > max){
                max = nums[i];
            }
        }
        return i;
    }
}
