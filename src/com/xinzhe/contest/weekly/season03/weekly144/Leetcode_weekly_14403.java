package com.xinzhe.contest.weekly.season03.weekly144;

import com.xinzhe.categories.structure.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Xin
 * @date 2020/8/18
 * Title : 1110. 删点成林
 * Description : 给出二叉树的根节点 root，树上每个节点都有一个不同的值。
 *              如果节点值在 to_delete 中出现，我们就把该节点从树上删去，最后得到一个森林（一些不相交的树构成的集合）。
 *              返回森林中的每棵树。你可以按任意顺序组织答案。
 * link : https://leetcode-cn.com/problems/delete-nodes-and-return-forest
 * Level : Medium
 */

public class Leetcode_weekly_14403 {
    public static void main(String[] args) {
        Leetcode_weekly_14403 lc = new Leetcode_weekly_14403();
    }
    List<TreeNode> res = new ArrayList<>();
    public List<TreeNode> delNodes(TreeNode root, int[] to) {
        res.add(root);
        for (int i : to) {
            for (TreeNode node : res) {
                if(helper(node, null, i, 0)) break;
            }
        }
        return res;
    }

    private boolean helper(TreeNode node, TreeNode father, int i, int side) {
        if(node == null) return false;
        if(node.val == i) {
            if(father == null) {
                if(node.left != null) res.add(node.left);
                if(node.right != null) res.add(node.right);
                res.remove(node);
                return true;
            }
            if(side == 1) father.left = null;
            else if(side == 2) father.right = null;
            if(node.left != null) res.add(node.left);
            if(node.right != null) res.add(node.right);
            return true;
        }
        boolean left = helper(node.left, node, i, 1);
        if(left) return true;
        return helper(node.right, node, i, 2);
    }
}
