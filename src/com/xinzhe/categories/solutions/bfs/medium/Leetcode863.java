package com.xinzhe.categories.solutions.bfs.medium;

import com.xinzhe.categories.structure.tree.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Xin
 * @date 2020/6/30
 * Title : 863. 二叉树中所有距离为 K 的结点
 * Description : 给定一个二叉树（具有根结点 root）， 一个目标结点 target ，和一个整数值 K , 返回到目标结点 target 距离为 K 的所有结点的值的列表。 答案可以以任何顺序返回。
 * link : https://leetcode-cn.com/problems/all-nodes-distance-k-in-binary-tree
 * Level : Medium
 */

public class Leetcode863 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(4);

        Leetcode863 lc = new Leetcode863();
        System.out.println(lc.distanceK(root, new TreeNode(4), 2));
    }
    Map<TreeNode, TreeNode> map = new HashMap<>();
    List<Integer> res = new ArrayList<>();
    Set<TreeNode> visited = new HashSet<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        if (root == null) return res;
        dfs(root, null);
        while (k >= 0 && target  != null) {
            helper(target, k);
            visited.add(target);
            target = map.get(target);
            k--;
        }
        return res;
    }

    private void helper(TreeNode root, int k) {
        if (root == null) return;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if(visited.contains(cur)) continue;
                if(k == 0) res.add(cur.val);
                if(cur.left != null) queue.offer(cur.left);
                if(cur.right != null) queue.offer(cur.right);
            }
            k--;
        }
    }

    private void dfs(TreeNode node, TreeNode father) {
        if(node != null) {
            map.put(node, father);
            dfs(node.left, node);
            dfs(node.right, node);
        }
    }
}
