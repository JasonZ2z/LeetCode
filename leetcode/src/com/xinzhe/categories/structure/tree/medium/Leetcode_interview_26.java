package com.xinzhe.categories.structure.tree.medium;

import com.xinzhe.categories.structure.tree.TreeNode;

import java.util.Stack;

/**
 * @Author Xin
 * @create 2020/3/10 18:32
 * Title : 面试题 04.02. 最小高度树
 * Description : 给定一个有序整数数组，元素各不相同且按升序排列，编写一个算法，创建一棵高度最小的二叉搜索树。
 * link : https://leetcode-cn.com/problems/minimum-height-tree-lcci/
 * Level : Easy
 */
public class Leetcode_interview_26 {
    public boolean isSubStructure(TreeNode t1, TreeNode t2) {
        if(t1 == null || t2 == null) return false;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur;
        stack.add(t1);
        while (!stack.isEmpty()){
            cur = stack.pop();
            if(cur.val == t2.val){
                if(helper(cur, t2)){
                    return true;
                }
            }
            if(t1.left != null) stack.add(t1.left);
            if(t1.right != null) stack.add(t1.right);
        }
        return false;
    }

    private boolean helper(TreeNode t1, TreeNode t2) {
        if(t2 == null) return true;
        if(t1 == null) return false;
        return t1.val == t2.val && helper(t1.left, t2.left) && helper(t1.right, t2.right);

    }
}
