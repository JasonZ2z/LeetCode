package com.xinzhe.categories.structure.linkedlist.medium;

import com.xinzhe.categories.structure.linkedlist.ListNode;

/**
 * @author Xin
 * @date 2020/11/13
 * Title : 86. 分隔链表
 * Description : 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。你应当保留两个分区中每个节点的初始相对位置。
 * link : https://leetcode-cn.com/problems/split-linked-list-in-parts
 * Level : Medium
 */
//todo need to review
public class Leetcode086 {
    public static void main(String[] args) {
        Leetcode086 lc = new Leetcode086();
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(4);
        node1.next.next = new ListNode(3);
        node1.next.next.next = new ListNode(2);
        node1.next.next.next.next = new ListNode(5);
        node1.next.next.next.next.next = new ListNode(2);
        ListNode cur = node1;
        while (cur != null) {
            System.out.print(cur.val);
            cur = cur.next;
        }
        System.out.println();
        lc.partition(node1, 3);
        while (node1 != null) {
            System.out.print(node1.val);
            node1 = node1.next;
        }

    }
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null) return head;
        ListNode dummy1 = new ListNode(-1);
        ListNode dummy2 = new ListNode(-1);
        ListNode less = dummy1;
        ListNode more = dummy2;
        ListNode cur = head;
        while (cur  != null) {
            if(cur.val >= x) {
                more.next = cur;
                more = more.next;
            } else {
                less.next = cur;
                less = less.next;
            }
            cur = cur.next;
        }
        more.next = null;
        less.next = dummy2.next;
        return dummy1.next;
    }
}
