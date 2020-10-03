package com.xinzhe.order.day01;

import com.xinzhe.categories.structure.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Xin
 * @date 2020/2/27 14:53
 * Title : 129. 求根到叶子节点数字之和
 * Description : 给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
 *              例如，从根到叶子节点路径 1->2->3 代表数字 123。
 *              计算从根到叶子节点生成的所有数字之和。
 * link : https://leetcode-cn.com/problems/sum-root-to-leaf-numbers
 * Level : medium
 */
public class Leetcode129 {
    private final List<String> list = new ArrayList<>();
    public int sumNumbers(TreeNode root) {
        helper(root, "");
        return list.stream().mapToInt(Integer::valueOf).sum();
    }

    private void helper(TreeNode root, String s) {
        if(root == null) return;
        StringBuilder  sb = new StringBuilder(s);
        sb.append(root.val);
        if(root.left == null && root.right == null){
            list.add(sb.toString());
        } else {
            helper(root.left, sb.toString());
            helper(root.right, sb.toString());
        }
    }
}
