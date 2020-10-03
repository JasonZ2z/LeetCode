package com.xinzhe.categories.structure.tree.hard;

import com.xinzhe.categories.structure.tree.TreeNode;
import com.xinzhe.categories.structure.tree.traverse.LevelOrder;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Xin
 * @date 2020/6/18
 * Title : 1028. 从先序遍历还原二叉树
 * Description : 我们从二叉树的根节点 root 开始进行深度优先搜索。
 *              在遍历中的每个节点处，我们输出 D 条短划线（其中 D 是该节点的深度），然后输出该节点的值。（如果节点的深度为 D，则其直接子节点的深度为 D + 1。根节点的深度为 0）。
 *              如果节点只有一个子节点，那么保证该子节点为左子节点。
 *              给出遍历输出 S，还原树并返回其根节点 root。
 * link : https://leetcode-cn.com/problems/recover-a-tree-from-preorder-traversal
 * Level : Hard
 */

public class Leetcode1028 {
    public static void main(String[] args) {
        String s = "1-2--3--4-5--6--7";
        //String s = "1-401--349---90--88";
        Leetcode1028 lc = new Leetcode1028();
        LevelOrder.printTree(lc.recoverFromPreorder(s));
    }


    public TreeNode recoverFromPreorder(String s) {
        List<Data> list = new ArrayList<>();
        char[] arr = s.toCharArray();
        int start = 0;
        int count = 0;
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] == '-' ) {
                if(arr[i-1] != '-') {
                    list.add(new Data(new TreeNode(Integer.parseInt(s.substring(start,i))), count));
                    count = 1;
                } else {
                    count++;
                }
            }else if(arr[i-1] == '-') {
                start = i;
            }
        }
        list.add(new Data(new TreeNode(Integer.parseInt(s.substring(start))), count));
        ArrayDeque<Data> stack = new ArrayDeque<>();

        for (Data data : list) {
            while (!stack.isEmpty() && stack.peek().level >= data.level) {
                Data cur = stack.pop();
                Data pre = stack.pop();
                TreeNode node = buildTree(pre, cur);
                stack.push(new Data(node, pre.level));
            }
            stack.push(data);
        }
        while (stack.size() > 1) {
            Data cur = stack.pop();
            Data pre = stack.pop();
            TreeNode node = buildTree(pre, cur);
            stack.push(new Data(node, pre.level));
        }
        return Objects.requireNonNull(stack.poll()).node;
    }

    private TreeNode buildTree(Data pre, Data cur) {
        TreeNode node = pre.node;
        if(node.left == null) {
            node.left = cur.node;
        } else {
            node.right = cur.node;
        }
        return node;
    }

    static class Data {
        TreeNode node;
        int level;

        public Data(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }
}
