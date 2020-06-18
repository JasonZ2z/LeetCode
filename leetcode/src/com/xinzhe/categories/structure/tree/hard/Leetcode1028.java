package com.xinzhe.categories.structure.tree.hard;

import com.xinzhe.categories.structure.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Xin
 * @create 2020/6/18
 * Title : 1028. 从先序遍历还原二叉树
 * Description : 我们从二叉树的根节点 root 开始进行深度优先搜索。
 *              在遍历中的每个节点处，我们输出 D 条短划线（其中 D 是该节点的深度），然后输出该节点的值。（如果节点的深度为 D，则其直接子节点的深度为 D + 1。根节点的深度为 0）。
 *              如果节点只有一个子节点，那么保证该子节点为左子节点。
 *              给出遍历输出 S，还原树并返回其根节点 root。
 * link : https://leetcode-cn.com/problems/recover-a-tree-from-preorder-traversal
 * Level : Hard
 */

public class Leetcode1028 {
    List<Integer> list = new ArrayList<>();
    public TreeNode recoverFromPreorder(String s) {
        return helper(s, 1);
    }

    private TreeNode helper(String s, int i) {
        if(s == null || s.length() == 0) return null;
        char[] arr = s.toCharArray();
        TreeNode node = new TreeNode(arr[0] - '0');
        String tmp = "-".repeat(i);
        int start = s.indexOf(tmp);
        int count = 0, end = 0;
        for(int j = s.length()-1; j >= 0; --j) {
            if(arr[j] == '-') {
                count++;
            } else {
                if(count == i) {
                    end = j + i+ 1;
                    break;
                }
                count = 0;
            }
        }
        if(start < 0) return node;
        if(start == end) {
            //String substring = s.substring(start + i);
            node.left = start + i <= s.length() ? helper(s.substring(start + i), i+1) : null;
        } else if(end <= 0){
            return node;
        } else {
//            String substring = s.substring(start + i, end-i);
//            String substring1 = s.substring(end);
            node.left = start + i <= end -i && end - i <= s.length()? helper(s.substring(start + i, end-i), i+1) : null;
            node.right = end + i <= s.length() ? helper(s.substring(end), i+1) : null;
        }
        return node;
    }

    public static void main(String[] args) {
        Leetcode1028 codec = new Leetcode1028();
        String s = "1-2--3--4-5--6--7";
        TreeNode root = codec.recoverFromPreorder(s);
        codec.traversal(root);
        System.out.println(codec.list.toString());
    }

    public void traversal(TreeNode root){
        if(root == null) return;
        list.add(root.val);
        traversal(root.left);
        traversal(root.right);
    }
}
