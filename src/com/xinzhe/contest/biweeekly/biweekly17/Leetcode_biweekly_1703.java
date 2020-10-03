package com.xinzhe.contest.biweeekly.biweekly17;

import com.xinzhe.categories.structure.tree.TreeNode;

/**
 * @author Xin
 * @date 2020/5/26
 * Title : 1315. 祖父节点值为偶数的节点和
 * Description : 给你一棵二叉树，请你返回满足以下条件的所有节点的值之和：
 * 该节点的祖父节点的值为偶数。（一个节点的祖父节点是指该节点的父节点的父节点。）
 * 如果不存在祖父节点值为偶数的节点，那么返回 0 。
 * link : https://leetcode-cn.com/problems/sum-of-nodes-with-even-valued-grandparent
 * Level : Medium
 * Comment 17双周赛03
 */

public class Leetcode_biweekly_1703 {
    int max = 0;

    public int sumEvenGrandparent(TreeNode root) {
        sumEvenGrandparent(new Data(null, null, root));
        return max;
    }

    public void sumEvenGrandparent(Data root) {
        if (root.node == null) return;
        if (root.grand != null && root.grand.val % 2 == 0) {
            max += root.node.val;
        }
        sumEvenGrandparent(new Data(root.father, root.node, root.node.left));
        sumEvenGrandparent(new Data(root.father, root.node, root.node.right));
    }

    static class Data {
        TreeNode grand;
        TreeNode father;
        TreeNode node;

        public Data(TreeNode grand, TreeNode father, TreeNode node) {
            this.grand = grand;
            this.father = father;
            this.node = node;
        }
    }

}
