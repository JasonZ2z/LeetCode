package com.xinzhe.contest.weekly.season04.weekly199;

import com.xinzhe.categories.structure.tree.TreeNode;

/**
 * @author Xin
 * @date 2020/7/25
 * Title : 1530. 好叶子节点对的数量
 * Description : 给你二叉树的根节点 root 和一个整数 distance 。
 *              如果二叉树中两个 叶 节点之间的 最短路径长度 小于或者等于 distance ，那它们就可以构成一组 好叶子节点对 。 返回树中 好叶子节点对的数量 。
 * link : https://leetcode-cn.com/problems/number-of-good-leaf-nodes-pairs
 * Level : Medium
 */
//todo need to review
public class Leetcode_weekly_19903 {
    public static void main(String[] args) {
        Leetcode_weekly_19903 lc = new Leetcode_weekly_19903();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        System.out.println(lc.countPairs(root, 3));
    }
    int count = 0;
    public int countPairs(TreeNode root, int distance) {
        helper(root, distance);
        return count;
    }

    private int[] helper(TreeNode root, int distance) {
        int[] dist = new int[distance + 1];
        if(root == null) return dist;
        if(root.left == null && root.right == null) {
            dist[0] = 1;
            return dist;
        }
        int[] left = helper(root.left, distance);
        int[] right = helper(root.right, distance);
        for (int i = 1; i <= distance; ++i) {
            dist[i] = left[i-1] + right[i-1];
        }
        for (int i = 0; i <= distance; ++i) {
            for (int j = 0; i +  j <= distance - 2; ++j) {
                count += left[i] * right[j];
            }
        }
        return dist;
    }

}
