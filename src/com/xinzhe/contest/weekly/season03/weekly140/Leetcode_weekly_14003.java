package com.xinzhe.contest.weekly.season03.weekly140;

import com.xinzhe.categories.structure.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Xin
 * @date 2020/8/21
 * Title : 1080. 根到叶路径上的不足节点
 * Description : 给定一棵二叉树的根 root，请你考虑它所有 从根到叶的路径：从根到任何叶的路径。（所谓一个叶子节点，就是一个没有子节点的节点）
 *              假如通过节点 node 的每种可能的 “根-叶” 路径上值的总和全都小于给定的 limit，则该节点被称之为「不足节点」，需要被删除。
 *              请你删除所有不足节点，并返回生成的二叉树的根。
 * link :  https://leetcode-cn.com/problems/insufficient-nodes-in-root-to-leaf-paths
 * Level : Medium
 */

public class Leetcode_weekly_14003 {
    public static void main(String[] args) {
        Leetcode_weekly_14003 lc = new Leetcode_weekly_14003();
    }
    Map<TreeNode, Integer> map = new HashMap<>();
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        TreeNode father = new TreeNode(0);
        father.left = root;
        helper(root, father, true, 0, limit);
        return father.left;
    }
    public void helper(TreeNode root, TreeNode father, boolean flag, int sum, int limit) {
        if(root == null) return;
        int total =  sum + getSumMax(root);
        if(total < limit) {
            if(flag) {
                father.left = null;
            } else {
                father.right = null;
            }
        }else {
            helper(root.left, root, true, sum + root.val, limit);
            helper(root.right, root, false, sum + root.val, limit);
        }
    }

    private int getSumMax(TreeNode root) {
        if(root.left == null && root.right == null) {
            map.put(root, root.val);
            return root.val;
        }
        if(root.left == null) {
            int res = root.val + getSumMax(root.right);
            map.put(root, res);
            return res;
        }
        if(root.right == null) {
            int res = root.val + getSumMax(root.left);
            map.put(root, res);
            return res;
        }
        if(map.containsKey(root)) return map.get(root);
        int val = root.val + Math.max(getSumMax(root.left), getSumMax(root.right));
        map.put(root, val);
        return val;
    }
}
