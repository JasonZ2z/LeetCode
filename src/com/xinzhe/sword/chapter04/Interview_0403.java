package com.xinzhe.sword.chapter04;

import com.xinzhe.categories.structure.linkedlist.ListNode;
import com.xinzhe.categories.structure.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Xin
 * @date 2020/6/12
 * Title : 04.03. 特定深度节点链表
 * Description : 给定一棵二叉树，设计一个算法，创建含有某一深度上所有节点的链表（比如，若一棵树的深度为 D，则会创建出 D 个链表）。返回一个包含所有深度的链表的数组。
 * link : https://leetcode-cn.com/problems/list-of-depth-lcci/
 * Level : Medium
 */
public class Interview_0403 {
    List<List<Integer>> list = new ArrayList<>();
    public ListNode[] listOfDepth(TreeNode tree) {
        bfs(tree, 0);
        ListNode[] res = new ListNode[list.size()];
        ListNode head = new ListNode(-1);
        for (int i = 0; i < list.size(); i++) {
            ListNode cur = head;
            for (int j : list.get(i)) {
                cur.next = new ListNode(j);
                cur = cur.next;
            }
            res[i] = head.next;
            head.next = null;
        }
        return res;
    }

    private void bfs(TreeNode tree, int level) {
        if(tree == null) return;
        if(level >= list.size()) {
            list.add(new ArrayList<>());
        }
        list.get(level).add(tree.val);
        bfs(tree.left, level+1);
        bfs(tree.right, level+1);
    }
}
