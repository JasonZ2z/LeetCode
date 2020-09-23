package com.xinzhe.contest.weekly.season03.weekly124;

import com.xinzhe.categories.structure.tree.TreeNode;

/**
 * @author Xin
 * @date 2020/9/23
 * Title : 993. 二叉树的堂兄弟节点
 * Description : 在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。如果二叉树的两个节点深度相同，但父节点不同，则它们是一对堂兄弟节点。
 *              我们给出了具有唯一值的二叉树的根节点 root，以及树中两个不同节点的值 x 和 y。只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true。否则，返回 false。
 * link : https://leetcode-cn.com/problems/cousins-in-binary-tree
 * Level : Easy
 */

public class Leetcode_weekly_12401 {
    public static void main(String[] args) {
        Leetcode_weekly_12401 lc = new Leetcode_weekly_12401();
        int[] arr = {2,-3,-1,5,-4};
    }
    public boolean isCousins(TreeNode root, int x, int y) {
        if(x == root.val || y == root.val) return false;
        int[] left = helper(root, null, x, 0);
        int[] right = helper(root, null, y, 0);
        return left[0] != -1 && left[0] != right[0] && left[1] == right[1];
    }

    public int[] helper(TreeNode root, TreeNode father, int x, int level) {
        if(root == null) return new int[]{-1, -1};
        if(root.val == x) return new int[]{father.val, level};
        int[] left = helper(root.left, root, x, level+ 1);
        if(left[0] != -1) return left;
        return helper(root.right, root, x, level+ 1);
    }

}
