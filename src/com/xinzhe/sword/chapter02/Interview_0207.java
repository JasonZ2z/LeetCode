package com.xinzhe.sword.chapter02;

import com.xinzhe.categories.structure.linkedlist.ListNode;

/**
 * @author Xin
 * @date 2020/10/22
 * Title : 02.07. Intersection of Two Linked Lists LCCI
 * Description :  Given two (singly) linked lists, determine if the two lists intersect. Return the intersecting node.
 *                  Note that the intersection is defined based on reference, not value.
 *                  That is, if the kth node of the first linked list is the exact same node (by reference) as the jth node of the second linked list, then they are intersecting.
 * link : https://leetcode-cn.com/problems/intersection-of-two-linked-lists-lcci
 * Level : Easy
 */
public class Interview_0207 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        ListNode a = headA, b = headB;
        while(a.next != null) a = a.next;
        while(b.next != null) b = b.next;
        if(a != b) return null;
        a.next = headB;
        ListNode fast = headA.next.next, slow = headA.next;
        while(slow != fast) {
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = headA;
        while(fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        a.next = null;
        return slow;
    }
}
