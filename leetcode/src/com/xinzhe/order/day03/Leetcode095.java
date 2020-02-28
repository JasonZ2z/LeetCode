package com.xinzhe.order.day03;

import com.xinzhe.categories.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Xin
 * @create 2020/2/28 10:46
 * Title : 95. 不同的二叉搜索树 II
 * Description : 给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。
 * link : https://leetcode-cn.com/problems/unique-binary-search-trees-ii/
 * Level : Medium
 */

//Todo need to review
public class Leetcode095 {
    //递归
    public List<TreeNode> generateTrees(int n) {
        if(n == 0) return new ArrayList<>();
        return helper(1,n);
    }

    private List<TreeNode> helper(int start, int end) {
        List<TreeNode> list = new ArrayList<>();
        if(start > end) {
            list.add(null);
            return list;
        }
        if(start == end) {
            list.add(new TreeNode(start));
            return list;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> lefts = helper(start, i - 1);
            List<TreeNode> rights = helper(i+1, end);
            for (TreeNode left : lefts) {
                for (TreeNode right : rights) {
                    TreeNode node = new TreeNode(i);
                    node.left = left;
                    node.right = right;
                    list.add(node);
                }
            }
        }
        return list;
    }
}
