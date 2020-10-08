package com.xinzhe.contest.weekly.season05.weekly209;

import com.xinzhe.categories.structure.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Xin
 * @date 2020/10/4
 * Title : 1609. 奇偶树
 * Description : 如果一棵二叉树满足下述几个条件，则可以称为 奇偶树 ：
 *              二叉树根节点所在层下标为 0 ，根的子节点所在层下标为 1 ，根的孙节点所在层下标为 2 ，依此类推。
 *              偶数下标 层上的所有节点的值都是 奇 整数，从左到右按顺序 严格递增
 *              奇数下标 层上的所有节点的值都是 偶 整数，从左到右按顺序 严格递减
 *              给你二叉树的根节点，如果二叉树为 奇偶树 ，则返回 true ，否则返回 false 。
 * link : https://leetcode-cn.com/problems/even-odd-tree
 * Level : Medium
 */
public class Leetcode_weekly_20902 {
    public static void main(String[] args) {
        Leetcode_weekly_20902 lc = new Leetcode_weekly_20902();
        TreeNode treeNode = new TreeNode(1);
        System.out.println(lc.isEvenOddTree(treeNode));
    }

    public boolean isEvenOddTree(TreeNode root) {
        levelOrderRecur(root);
        for (int i = 0; i < result.size(); i++) {
            if(i % 2 == 0) {
                int pre = 0;
                for (int j = 0; j < result.get(i).size(); j++) {
                    Integer cur = result.get(i).get(j);
                    if(cur != null) {
                        if(cur % 2 == 0 || cur <= pre) {
                            return false;
                        } else {
                            pre = cur;
                        }
                    }
                }

            } else {
                int pre = (int)1e7;
                for (int j = 0; j < result.get(i).size(); j++) {
                    Integer cur = result.get(i).get(j);
                    if(cur != null) {
                        if(cur % 2 != 0 || cur >= pre) {
                            return false;
                        } else {
                            pre = cur;
                        }
                    }
                }
            }

        }
        return true;
    }

    private static final List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> levelOrderRecur(TreeNode root){
        order(root, 0);
        return result;
    }
    public void order(TreeNode root, int level){
        if(root == null) return;
        if(result.size() <= level){
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);
        order(root.left,level+1);
        order(root.right,level+1);
    }
}

