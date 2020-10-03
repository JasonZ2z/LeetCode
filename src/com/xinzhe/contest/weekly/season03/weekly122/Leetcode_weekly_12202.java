package com.xinzhe.contest.weekly.season03.weekly122;

import com.xinzhe.categories.structure.tree.TreeNode;

/**
 * @author Xin
 * @date 2020/9/25
 * Title : 988. 从叶结点开始的最小字符串
 * Description : 给定一颗根结点为 root 的二叉树，树中的每一个结点都有一个从 0 到 25 的值，分别代表字母 'a' 到 'z'：值 0 代表 'a'，值 1 代表 'b'，依此类推。
 *              找出按字典序最小的字符串，该字符串从这棵树的一个叶结点开始，到根结点结束。
 * link : https://leetcode-cn.com/problems/smallest-string-starting-from-leaf
 * Level : Easy
 */

public class Leetcode_weekly_12202 {
    public static void main(String[] args) {
        Leetcode_weekly_12202 lc = new Leetcode_weekly_12202();
        int[] arr = {2,-3,-1,5,-4};
    }

    int min = 26;
    String res = "";
    public String smallestFromLeaf(TreeNode root) {
        if(root == null) return "";
        helper(root, "");
        return res;
    }

    private void helper(TreeNode root, String s) {
        if(root == null) return;
        s = (char)(root.val + 'a') + s;
        if(root.left == null && root.right == null) {
            if(root.val == min) {
                boolean flag = true;
                int i = 0;
                for(; i < Math.min(res.length(), s.length()); i++) {
                    if(res.charAt(i) > s.charAt(i)) {
                        res = s;
                        flag = false;
                        break;
                    } else if(res.charAt(i) < s.charAt(i)) {
                        flag = false;
                        break;
                    }
                }
                if(flag) {
                    if(res.length() > i && s.length() == i) {
                        res = s;
                    }
                }
            } else if(root.val < min){
                min = root.val;
                res = s;
            }
            return;
        }
        helper(root.right, s);
        helper(root.left, s);
    }
}
