package com.xinzhe.contest.weekly.season03.weekly132;

import com.xinzhe.categories.structure.tree.TreeNode;
import com.xinzhe.categories.structure.tree.traverse.PreOrder;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Xin
 * @date 2020/9/10
 * Title : 1028. 从先序遍历还原二叉树
 * Description : 我们从二叉树的根节点 root 开始进行深度优先搜索。在遍历中的每个节点处，我们输出 D 条短划线（其中 D 是该节点的深度），然后输出该节点的值。
 *              （如果节点的深度为 D，则其直接子节点的深度为 D + 1。根节点的深度为 0）。 如果节点只有一个子节点，那么保证该子节点为左子节点。
 *              给出遍历输出 S，还原树并返回其根节点 root。
 * link : https://leetcode-cn.com/problems/recover-a-tree-from-preorder-traversal
 * Level : Hard
 */

public class Leetcode_weekly_13204 {
    public static void main(String[] args) {
        Leetcode_weekly_13204 lc = new Leetcode_weekly_13204();
        PreOrder.printTree(lc.recoverFromPreorder("1-2--3---4-5--6---7"));
    }
    public TreeNode recoverFromPreorder(String s) {
        if(s == null || s.length() == 0) return null;
        int n = s.length(), i = 0;
        StringBuilder sb = new StringBuilder();
        while( i < n && s.charAt(i) != '-') {
            sb.append(s.charAt(i++));
        }
        TreeNode root = new TreeNode(Integer.parseInt(sb.toString()));
        List<String> arr = delete(s.substring(i));
        if(arr == null || arr.size() == 0) return root;
        if(arr.size() == 1) {
            root.left = recoverFromPreorder(arr.get(0));
            return root;
        }
        root.left = recoverFromPreorder(arr.get(0));
        root.right = recoverFromPreorder(arr.get(1));
        return root;
    }

    private List<String> delete(String s) {
        ArrayList<String> res = new ArrayList<>();
        if(s == null || s.length() == 0)  return res;
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if(c == '-') {
                count++;
            }else {
                if(count == 1) {
                    if(sb.length() != 0) {
                        res.add(sb.toString());
                        sb = new StringBuilder();
                    }
                } else if(count > 0){
                    sb.append("-".repeat(count - 1));
                }
                count = 0;
                sb.append(c);
            }
        }
        res.add(sb.toString());
        return res;
    }
}
