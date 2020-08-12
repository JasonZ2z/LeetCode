package com.xinzhe.categories.solutions.bfs.medium;

import com.xinzhe.categories.structure.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author Xin
 * @create 2020/6/29
 * Title : 515. 在每个树行中找最大值
 * Description : 您需要在二叉树的每一行中找到最大的值。
 * link : https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row/
 * Level : Medium
 */

public class Leetcode515 {
    public List<Integer> largestValues(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> tmp = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                tmp.add(cur.val);
                if(cur.left != null) queue.offer(cur.left);
                if(cur.right != null) queue.offer(cur.right);
            }
            res.add(tmp.stream().max(Integer::compareTo).get());
        }
        return res;
    }
}
