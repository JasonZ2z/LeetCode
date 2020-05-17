package com.xinzhe.contest.biweeekly.biweeekly26;

import com.xinzhe.categories.structure.tree.TreeNode;

/**
 * @Author Xin
 * @create 2020/5/16
 * Title :
 * Description :
 * link :
 * Level :
 */
public class Leetcode_biweekly_2603 {
    int count = 0;

    public int goodNodes(TreeNode root) {
        helper(root, Integer.MIN_VALUE);
        return count;
    }

    public void helper(TreeNode root, int max) {
        if (root == null) return;
        if (root.val > max) {
            count++;
            helper(root.left, root.val);
            helper(root.right, root.val);
        } else {
            helper(root.left, max);
            helper(root.right, max);
        }
    }

//    class Data{
//        TreeNode node;
//        int max;
//
//        public Data(TreeNode node, int max) {
//            this.node = node;
//            this.max = max;
//        }
//    }
}
