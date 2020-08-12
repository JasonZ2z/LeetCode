package com.xinzhe.categories.structure.linkedlist.hard;

import com.xinzhe.categories.structure.linkedlist.ListNode;

/**
 * @author Xin
 * @date 2020/7/29
 * Title : 92. 反转链表 II
 * Description : 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * link : https://leetcode-cn.com/problems/reverse-linked-list-ii/
 * Level : Hard
 */
public class Leetcode092 {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m == n) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode last = head;
        ListNode cur = head;
        int i = 1;
        while(i < n) {
            if(i < m) {
                pre = pre.next;
                cur = cur.next;
            }
            last = last.next;
            i++;
        }
        ListNode tail = last.next;
        last.next = null;

        ListNode[] newHead = reverse(cur);
        pre.next = newHead[0];

        newHead[1].next = tail;

        return dummy.next;
    }

    public ListNode[] reverse(ListNode head) {
        if(head == null || head.next == null) return new ListNode[]{head, head};
        ListNode[] newHead = reverse(head.next);
        newHead[1].next = head;
        head.next = null;
        return new ListNode[]{newHead[0], head};
    }
}
