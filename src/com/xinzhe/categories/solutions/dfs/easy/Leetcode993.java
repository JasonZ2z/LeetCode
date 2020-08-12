package com.xinzhe.categories.solutions.dfs.easy;


import com.xinzhe.categories.structure.tree.TreeNode;

/**
 * @author Xin
 * @date 2020/3/30 15:34
 * Title : 993. 二叉树的堂兄弟节点
 * Description : 在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。
 *              如果二叉树的两个节点深度相同，但父节点不同，则它们是一对堂兄弟节点。
 *              我们给出了具有唯一值的二叉树的根节点 root，以及树中两个不同节点的值 x 和 y。
 *              只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true。否则，返回 false。
 * link : https://leetcode-cn.com/problems/cousins-in-binary-tree
 * Level : Easy
 */

public class Leetcode993 {
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) return false;
        InnerNode d1 = getDepth(root, 0, x, 0);
        InnerNode d2 = getDepth(root, 0, y, 0);
        return d1.level == d2.level && d1.parent != d2.parent;
    }

    private InnerNode getDepth(TreeNode root, int parent, int x, int level) {
        if(root == null) return new InnerNode(0, 0);
        if(root.val == x) return new InnerNode(parent,level);
        InnerNode left = getDepth(root.left, root.val, x, level+1);
        if(left.level > 0) return left;
        return getDepth(root.right, root.val, x, level+1);
    }

}

class InnerNode{
    public int level;
    public int parent;
    public InnerNode(int parent, int level){
        this.parent = parent;
        this.level = level;
    }
}
