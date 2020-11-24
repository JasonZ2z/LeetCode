package com.xinzhe.categories.structure.tree.medium;

import com.xinzhe.categories.structure.tree.TreeNode;

/**
 * @author Xin
 * @date 2020/11/24
 * Title : 222. 完全二叉树的节点个数
 * Description : 给出一个完全二叉树，求出该树的节点个数。
 * link : https://leetcode-cn.com/problems/count-complete-tree-nodes/
 * Level : Medium
 */

public class Leetcode222 {
    int cnt = 0;
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        int level = getLevel(root, 0);
        count(root, 0, level);
        return (int)Math.pow(2, level) - 1 - cnt;
    }

    private int getLevel(TreeNode root, int level) {
        if(root == null) return level;
        return getLevel(root.left, level + 1);
    }

    private void count(TreeNode root, int cur, int level) {
        if(root == null) {
            if(cur == level - 1) cnt++;
            return;
        }
        count(root.left, cur + 1, level);
        count(root.right, cur + 1, level);
    }
}
