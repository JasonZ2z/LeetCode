package com.xinzhe.order.day01;

import com.xinzhe.categories.structure.tree.TreeNode;

import java.util.*;

/**
 * @Author Xin
 * @create 2020/2/27 15:16
 * Title : 988. 从叶结点开始的最小字符串
 * Description : 给定一颗根结点为 root 的二叉树，书中的每个结点都有一个从 0 到 25 的值，
 *              分别代表字母 'a' 到 'z'：值 0 代表 'a'，值 1 代表 'b'，依此类推。
 *              找出按字典序最小的字符串，该字符串从这棵树的一个叶结点开始，到根结点结束。
 * Level : Medium
 */
public class Leetcode988 {

    private List<String> list = new ArrayList<>();
    public String smallestFromLeaf(TreeNode root) {
        helper(root, "");
        return list.stream().min(String::compareTo).orElse("");
    }

    private void helper(TreeNode root, String s) {
        if(root == null) return;
        StringBuilder sb = new StringBuilder(s);
        sb.append((char)(root.val + 'a'));
        if(root.left == null && root.right == null){
            list.add(sb.reverse().toString());
        } else{
            helper(root.left, sb.toString());
            helper(root.right,sb.toString());
        }
    }
}
