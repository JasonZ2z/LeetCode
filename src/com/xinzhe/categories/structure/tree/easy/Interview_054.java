package com.xinzhe.categories.structure.tree.easy;

import com.xinzhe.categories.structure.tree.TreeNode;

import java.util.PriorityQueue;

/**
 * @Author Xin
 * @create 2020/4/24 22:39
 * Title : 面试题54. 二叉搜索树的第k大节点
 * Description : 给定一棵二叉搜索树，请找出其中第k大的节点。
 * link :  https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/
 * Level : Easy
 */
public class Interview_054 {
    public int kthLargest(TreeNode root, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2-o1);
        visited(root, k, queue);
        if(queue.size() == 0) {
            return 0;
        }
        return queue.peek();
    }

    private void visited(TreeNode root, int k, PriorityQueue<Integer> queue) {
        if(root == null) return;
        queue.add(root.val);
        while (queue.size() > k){
            queue.poll();
        }
        visited(root.left, k, queue);
        visited(root.right, k, queue);
    }

}
