package com.xinzhe.categories.structure.tree.easy;

import com.xinzhe.categories.structure.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Xin
 * @date 2020/9/27
 * Title : 235. 二叉搜索树的最近公共祖先
 * Description : 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * link : https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree
 * Level : Easy
 */
public class Leetcode235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || p == root || q == root) return root;
        List<TreeNode> pList = new ArrayList<>(), qList = new ArrayList<>();
        helper(root, p, pList);
        helper(root, q, qList);
        int i=1, j=1;
        TreeNode pre = root;
        while(i < pList.size() || j < qList.size()) {
            TreeNode pNode = i < pList.size() ? pList.get(i) : null;
            TreeNode qNode = j < qList.size() ? qList.get(j) : null;
            if(pNode == qNode) {
                pre = pNode;
                i++;
                j++;
            } else{
                break;
            }
        }
        return pre;
    }

    private boolean helper(TreeNode root, TreeNode p, List<TreeNode> list) {
        if(root == null) return false;
        list.add(root);
        if(root == p)return true;
        if(helper(root.left, p, list)) return true;
        if(helper(root.right, p, list))return true;
        list.remove(list.size()-1);
        return false;
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val > q.val) return lowestCommonAncestor2(root, q, p);
        if(p.val <= root.val && q.val >= root.val) return root;
        else if(p.val > root.val) return lowestCommonAncestor2(root.right, p, q);
        else return lowestCommonAncestor2(root.left, p, q);
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(3);
        TreeNode b = new TreeNode(5);
        TreeNode c = new TreeNode(1);
        TreeNode d = new TreeNode(6);
        TreeNode e = new TreeNode(2);
        TreeNode f = new TreeNode(0);
        TreeNode x = new TreeNode(8);
        TreeNode y = new TreeNode(7);
        TreeNode z = new TreeNode(4);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = x;
        e.left = y;
        e.right = z;

        Leetcode235 solve = new Leetcode235();
        TreeNode result = solve.lowestCommonAncestor(a, b, f);
        System.out.printf("lowestCommonAncestor = %d\n", result.val);
        result = solve.lowestCommonAncestor(a, d, z);
        System.out.printf("lowestCommonAncestor = %d\n", result.val);
        result = solve.lowestCommonAncestor(a, b, y);
        System.out.printf("lowestCommonAncestor = %d\n", result.val);
    }

}
