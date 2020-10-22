package com.xinzhe.sword.chapter02;

import com.xinzhe.categories.structure.linkedlist.ListNode;

/**
 * @author Xin
 * @date 2020/10/22
 * Title : 02.08. Linked List Cycle LCCI
 * Description :  Given a circular linked list, implement an algorithm that returns the node at the beginning of the loop.
 *              Circular linked list: A (corrupt) linked list in which a node's next pointer points to an earlier node, so as to make a loop in the linked list.
 * link : https://leetcode-cn.com/problems/linked-list-cycle-lcci
 * Level : Medium
 */
public class Interview_0208 {
    public ListNode detectCycle(ListNode head) {
        if(head == null) return null;
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {
                fast = head;
                while(fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
        }
        return null;
    }
}
