package com.xinzhe.categories.solutions.dfs.easy;

import com.xinzhe.categories.structure.linkedlist.ListNode;
import com.xinzhe.categories.structure.tree.TreeNode;

/**
 * @Author Xin
 * @create 2020/3/30 21:39
 * Title : 109. 有序链表转换二叉搜索树
 * Description : 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 *              本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * link : https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree
 * Level : Easy
 */
public class Leetcode109 {
    public TreeNode sortedListToBST(ListNode head) {

        if(head == null ) return null;
        if(head.next == null) return new TreeNode(head.val);

        ListNode fast = head;
        ListNode slow = head;
        ListNode pre = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            pre = slow;
            slow = slow.next;

        }
        TreeNode node = new TreeNode(slow.val);
        pre.next = null;
        node.left = sortedListToBST(head);
        node.right = sortedListToBST(slow.next);
        return node;
    }
}
