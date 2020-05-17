package com.xinzhe.contest.weekly.weekly178;

import com.xinzhe.categories.structure.linkedlist.ListNode;
import com.xinzhe.categories.structure.tree.TreeNode;

/**
 * @Author Xin
 * @create 2020/5/15
 * Title : 1367. 二叉树中的列表
 * Description : 给你一棵以 root 为根的二叉树和一个 head 为第一个节点的链表。
 * 如果在二叉树中，存在一条一直向下的路径，且每个点的数值恰好一一对应以 head 为首的链表中每个节点的值，那么请你返回 True ，否则返回 False 。
 * 一直向下的路径的意思是：从树中某个节点开始，一直连续向下的路径。
 * link : https://leetcode-cn.com/problems/linked-list-in-binary-tree
 * Level : Medium
 * Comment 178周赛03
 */

//todo need to review
//same as 剑指offer第26题
public class Leecode_weekly_17803 {

    public boolean isSubPath(ListNode head, TreeNode root) {
        if (root == null) return false;
        return help(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    public boolean help(ListNode head, TreeNode root) {
        if (head == null) return true;
        if (root == null) return false;
        if (root.val != head.val) return false;
        return help(head.next, root.left) || help(head.next, root.right);
    }
}
