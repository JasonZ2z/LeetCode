package com.xinzhe.categories.structure.linkedlist.hard;

import com.xinzhe.categories.structure.linkedlist.ListNode;

/**
 * @Author Xin
 * @create 2020/5/16
 * Title : 25. K 个一组翻转链表
 * Description : 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * link : https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 * Level : Hard
 */
public class Leetcode025 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(3);
        node1.next.next.next = new ListNode(4);
        node1.next.next.next.next = new ListNode(5);
        ListNode cur = node1;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
        ListNode head = reverseKGroup(node1, 3);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur = head;
        int a = 0;
        while (a + 1 < k && cur != null) {
            cur = cur.next;
            a++;
        }
        if (cur == null) return head;
        cur.next = reverseKGroup(cur.next, k);
        return reverse(head, cur);

    }

    private static ListNode reverse(ListNode head, ListNode cur) {
        ListNode tmp;
        ListNode next = cur.next;
        while (true) {
            tmp = head;
            if (tmp == cur) break;
            head = head.next;
            cur.next = tmp;
            tmp.next = next;
            next = cur.next;
        }
        return cur;
    }
}
