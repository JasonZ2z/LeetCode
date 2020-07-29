package com.xinzhe.categories.structure.linkedlist.medium;

import com.xinzhe.categories.structure.linkedlist.ListNode;

/**
 * @Author Xin
 * @create 2020/5/16
 * Title : 24. 两两交换链表中的节点
 * Description : 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * link : https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 * Level : Medium
 */
public class Leetcode024 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(3);
        node1.next.next.next = new ListNode(4);
        ListNode cur = node1;
        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }

        ListNode head = swapPairs(node1);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }

    }

    public static ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        while (head != null && head.next != null) {
            ListNode third = head.next.next;
            pre.next = head.next;
            head.next.next = head;
            head.next = third;
            pre = head;
            head = third;
        }
        return dummy.next;
    }

    public ListNode swapPairs2(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode node = swapPairs2(head.next.next);
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode next = head.next;
        dummy.next = next;
        next.next = head;
        head.next = node;

        return dummy.next;

    }
}
