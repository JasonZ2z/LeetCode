package com.xinzhe.contest.biweeekly.biweekly21;

import com.xinzhe.categories.structure.tree.TreeNode;

/**
 * @author Xin
 * @date 2020/5/14
 * Title : 1373. 二叉搜索子树的最大键值和
 * Description : 给你一棵以 root 为根的 二叉树 ，请你返回 任意 二叉搜索子树的最大键值和。
 *              二叉搜索树的定义如下：
 *              任意节点的左子树中的键值都 小于 此节点的键值。
 *              任意节点的右子树中的键值都 大于 此节点的键值。
 *              任意节点的左子树和右子树都是二叉搜索树。
 * link : https://leetcode-cn.com/problems/maximum-sum-bst-in-binary-tree
 * Level : Hard
 * Comment 21双周赛04
 */

public class Leetcode_biweekly_2104 {

    int res = 0;

    public int maxSumBST(TreeNode root) {
        isSearch(root);
        return res;
    }

    public Data isSearch(TreeNode root) {
        if (root.left != null && root.right != null) {
            Data right = isSearch(root.right);
            Data left = isSearch(root.left);
            if (right.flag && left.flag && root.val > left.max && root.val < right.min) {
                Data data = new Data(root.val + right.sum + left.sum, true, right.max, left.min);
                res = Math.max(data.sum, res);
                return data;
            } else {
                return new Data(0, false, 0, 0);
            }
        } else if (root.right != null) {
            Data right = isSearch(root.right);
            if (right.flag && root.val < right.min) {
                Data data = new Data(root.val + right.sum, true, right.max, root.val);
                res = Math.max(data.sum, res);
                return data;
            } else {
                return new Data(0, false, 0, 0);
            }
        } else if (root.left != null) {
            Data left = isSearch(root.left);
            if (left.flag && root.val > left.max) {
                Data data = new Data(root.val + left.sum, true, root.val, left.min);
                res = Math.max(data.sum, res);
                return data;
            } else {
                return new Data(0, false, 0, 0);
            }
        }
        res = Math.max(root.val, res);
        return new Data(root.val, true, root.val, root.val);
    }

    static class Data {
        int sum;
        boolean flag;
        int max;
        int min;

        public Data(int sum, boolean flag, int max, int min) {
            this.sum = sum;
            this.flag = flag;
            this.max = max;
            this.min = min;
        }
    }

    public static void main(String[] args) {
        Leetcode_biweekly_2104 lc = new Leetcode_biweekly_2104();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.left.left = new TreeNode(1);
        System.out.println(lc.maxSumBST(root));
    }
}
