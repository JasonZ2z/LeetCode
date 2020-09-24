package com.xinzhe.categories.structure.tree.easy;

import com.xinzhe.categories.structure.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Xin
 * @date 2020/9/24
 * Title : 501. 二叉搜索树中的众数
 * Description : 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。 假定 BST 有如下定义：
 *              结点左子树中所含结点的值小于等于当前结点的值结点, 右子树中所含结点的值大于等于当前结点的值,左子树和右子树都是二叉搜索树
 * link : https://leetcode-cn.com/problems/find-mode-in-binary-search-tree
 * Level : Easy
 */
public class Leetcode501 {
    int maxVal = 0, maxCount = 0, curVal = 0, curCount = 0;
    List<Integer> list = new ArrayList<>();
    public int[] findMode(TreeNode root) {
        if(root == null) return new int[0];
        inOrder(root);
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    private void inOrder(TreeNode root) {
        if(root == null) return;
        inOrder(root.left);
        if(root.val == curVal) {
            curCount++;
        }else {
            curVal = root.val;
            curCount = 1;
        }
        if(curCount == maxCount) {
            list.add(curVal);
        } else if(curCount > maxCount) {
            list.clear();
            maxVal = curVal;
            maxCount = curCount;
            list.add(curVal);
        }
        inOrder(root.right);
    }
}
