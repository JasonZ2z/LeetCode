package com.xinzhe.contest.weekly.season03.weekly118;

import com.xinzhe.categories.structure.tree.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Xin
 * @date 2020/10/23
 * Title : 971. 翻转二叉树以匹配先序遍历
 * Description : 给定一个有 N 个节点的二叉树，每个节点都有一个不同于其他节点且处于 {1, ..., N} 中的值。通过交换节点的左子节点和右子节点，可以翻转该二叉树中的节点。
 *              考虑从根节点开始的先序遍历报告的 N 值序列。将这一 N 值序列称为树的行程。我们的目标是翻转最少的树中节点，以便树的行程与给定的行程 voyage 相匹配。 
 *              如果可以，则返回翻转的所有节点的值的列表。你可以按任何顺序返回答案。 如果不能，则返回列表 [-1]。
 * link : https://leetcode-cn.com/problems/flip-binary-tree-to-match-preorder-traversal
 * Level : Medium
 */
//todo need to review
public class Leetcode_weekly_11803 {
    public static void main(String[] args) {
        Leetcode_weekly_11803 lc = new Leetcode_weekly_11803();
        int[][] arr = {{1,3}, {-2,2}};
    }
    int i = 0;
    List<Integer> res = new ArrayList<>();
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        if (dfs(root, voyage)) {
            return res;
        }
        return Collections.singletonList(-1);
    }

    private boolean dfs(TreeNode root, int[] v) {
        if (root == null) return true;
        if (root.val != v[i++]) return false;
        if (root.left != null && root.left.val != v[i]) {
            res.add(root.val);
            return dfs(root.right, v) && dfs(root.left, v);
        }
        return dfs(root.left, v) && dfs(root.right, v);
    }
}
