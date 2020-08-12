package com.xinzhe.contest.weekly.season04.weekly169;

import com.xinzhe.categories.structure.tree.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Xin
 * @date 2020/5/29
 * Title : 1305. 两棵二叉搜索树中的所有元素
 * Description : 给你 root1 和 root2 这两棵二叉搜索树。请你返回一个列表，其中包含 两棵树 中的所有整数并按 升序 排序。.
 * link : https://leetcode-cn.com/problems/all-elements-in-two-binary-search-trees/
 * Level : Medium
 * Comment 169周赛02
 */

public class Leetcode_weekly_16902 {
    List<Integer> list1 = new ArrayList<>();
    List<Integer> list2 = new ArrayList<>();

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        helper(root1);
        helper(root2);
        list1.addAll(list2);
        Collections.sort(list1);
        return list1;
    }

    private void helper(TreeNode root) {
        if (root == null) return;
        helper(root.left);
        list1.add(root.val);
        helper(root.right);
    }
}
