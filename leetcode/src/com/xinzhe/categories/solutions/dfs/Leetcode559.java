package com.xinzhe.categories.solutions.dfs;

import com.xinzhe.categories.structure.tree.Node;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author Xin
 * @create 2020/3/30 13:23
 * Title : 559. N叉树的最大深度
 * Description : 给定一个 N 叉树，找到其最大深度。最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
 * link : https://leetcode-cn.com/problems/maximum-depth-of-n-ary-tree/
 * Level : Easy
 */

public class Leetcode559 {
    //递归
    public int maxDepth(Node root) {
        if(root == null) return 0;
        if(root.children == null) return 1;
        List<Node> children = root.children;
        int depth = 1;
        for (Node child : children) {
            depth = Math.max(depth, maxDepth(child) + 1);
        }
        return depth;
    }

    //非递归 bfs
    public int maxDepth2(Node root){
        if(root == null) return 0;
        int res = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                Node cur = queue.poll();
                if(!cur.children.isEmpty()) {
                    for (Node child : cur.children) {
                        queue.offer(child);
                    }
                }
            }
            res++;
        }
        return res;
    }
}
