package com.xinzhe.categories.structure.linkedlist.medium;

import com.xinzhe.categories.structure.linkedlist.ListNode;

/**
 * @author Xin
 * @date 2020/5/16
 * Title : 143. 重排链表
 * Description : 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * link : https://leetcode-cn.com/problems/reorder-list
 * Level : Medium
 */
public class Leetcode143 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(3);
        node1.next.next.next = new ListNode(4);
        node1.next.next.next.next = new ListNode(5);
        ListNode cur = node1;
        while (cur != null) {
            System.out.print(cur.val);
            cur = cur.next;
        }
        System.out.println();
        reorderList(node1);
        while (node1 != null) {
            System.out.print(node1.val);
            node1 = node1.next;
        }

    }

    public static void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) return;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;

        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode newHead = slow.next;
        slow.next = null;

        newHead = reorder(newHead);
        merge(head, newHead);
    }

    private static void merge(ListNode h1, ListNode newHead) {
        while(newHead != null){
            ListNode tmp = h1.next;
            h1.next = newHead;
            h1 = h1.next;
            newHead = tmp;
        }
    }

    public static ListNode reorder(ListNode head) {
        if(head.next == null) return head;
        ListNode newHead = reorder(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
