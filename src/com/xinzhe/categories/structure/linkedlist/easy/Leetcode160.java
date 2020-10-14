package com.xinzhe.categories.structure.linkedlist.easy;

import com.xinzhe.categories.structure.linkedlist.ListNode;

/**
 * @author Xin
 * @date 2020/10/14
 * Title : 160. 相交链表
 * Description : 编写一个程序，找到两个单链表相交的起始节点。
 * link : https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 * level ： Easy
 */
//todo need to review
public class Leetcode160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        ListNode cur = headB;
        while(cur.next != null) {
            cur = cur.next;
        }
        cur.next = headB;
        ListNode fast = headA, slow = headA;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow) {
                slow = headA;
                while(fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                cur.next = null;
                return fast;
            }
        }
        cur.next = null;
        return null;
    }
}
