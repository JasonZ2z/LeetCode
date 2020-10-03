package com.xinzhe.contest.weekly.season03.weekly131;

import com.xinzhe.categories.structure.tree.TreeNode;

/**
 * @author Xin
 * @date 2020/9/17
 * Title : 1022. 从根到叶的二进制数之和
 * Description : 给出一棵二叉树，其上每个结点的值都是 0 或 1 。每一条从根到叶的路径都代表一个从最高有效位开始的二进制数。例如，如果路径为 0 -> 1 -> 1 -> 0 -> 1，那么它表示二进制数 01101，也就是 13 。
 *              对树上的每一片叶子，我们都要找出从根到该叶子的路径所表示的数字。以 10^9 + 7 为模，返回这些数字之和。
 * link : https://leetcode-cn.com/problems/sum-of-root-to-leaf-binary-numbers
 * Level : Easy
 */

public class Leetcode_weekly_13102 {
    public static void main(String[] args) {
        Leetcode_weekly_13102 lc = new Leetcode_weekly_13102();
    }
    int mod = (int)1e9 + 7;
    long res = 0L;
    public int sumRootToLeaf(TreeNode root) {
        dfs(root, 0L);
        return (int) (res % mod);
    }

    private void dfs(TreeNode root, long x) {
        if(root == null)  return;
        long val = x*2 + root.val;
        if(root.left == null && root.right == null) {
            res += val;
            return;
        }
        dfs(root.left, val);
        dfs(root.right,val);
    }
}
