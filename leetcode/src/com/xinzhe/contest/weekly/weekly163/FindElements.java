package com.xinzhe.contest.weekly.weekly163;

import com.xinzhe.categories.structure.tree.TreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author Xin
 * @create 2020/6/16
 * Title : 1261. 在受污染的二叉树中查找元素
 * Description : 给出一个满足下述规则的二叉树：
 *                  root.val == 0
 *                  如果 treeNode.val == x 且 treeNode.left != null，那么 treeNode.left.val == 2 * x + 1
 *                  如果 treeNode.val == x 且 treeNode.right != null，那么 treeNode.right.val == 2 * x + 2
 *              现在这个二叉树受到「污染」，所有的 treeNode.val 都变成了 -1。请你先还原二叉树，然后实现 FindElements 类：
 *          FindElements(TreeNode* root) 用受污染的二叉树初始化对象，你需要先把它还原。
 *          bool find(int target) 判断目标值 target 是否存在于还原后的二叉树中并返回结果。
 * link : https://leetcode-cn.com/problems/find-elements-in-a-contaminated-binary-tree
 * Level : Medium
 * Comment 163周赛02
 */

public class FindElements {
    Set<Integer> set = new HashSet<>();
    public FindElements(TreeNode root) {
        root.val = 0;
        set.add(0);
        helper(root);
    }

    private void helper(TreeNode root) {
        if(root.left != null) {
            root.left.val = root.val * 2 + 1;
            set.add(root.left.val);
            helper((root.left));
        }
        if(root.right != null) {
            root.right.val = root.val * 2 + 2;
            set.add(root.right.val);
            helper((root.right));
        }
    }

    public boolean find(int target) {
        return set.contains(target);
    }
}
