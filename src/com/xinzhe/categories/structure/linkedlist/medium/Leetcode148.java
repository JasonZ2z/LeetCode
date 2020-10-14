package com.xinzhe.categories.structure.linkedlist.medium;

import com.xinzhe.categories.structure.linkedlist.ListNode;

/**
 * @author Xin
 * @date 2020/5/16
 * Title : 148. 排序链表
 * Description : 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 * link : https://leetcode-cn.com/problems/sort-list/
 * Level : Medium
 */

//todo need to review
public class Leetcode148 {
    public ListNode sortList(ListNode head) {
        if(head == null) return null;
        return mergeSort(head);
    }
    private ListNode mergeSort(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode slow = head, fast = head, pre = null;
        while(fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        ListNode l = mergeSort(head);
        ListNode r = mergeSort(slow);
        return merge(l, r);
    }

    private ListNode merge(ListNode p, ListNode q) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while(p != null && q != null) {
            if(p.val < q.val) {
                cur.next = p;
                p = p.next;
            } else {
                cur.next = q;
                q = q.next;
            }
            cur = cur.next;
        }
        if(p != null) cur.next = p;
        if(q != null) cur.next = q;
        return dummy.next;
    }
}
