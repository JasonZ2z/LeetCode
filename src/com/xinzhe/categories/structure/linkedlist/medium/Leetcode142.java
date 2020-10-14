package com.xinzhe.categories.structure.linkedlist.medium;

import com.xinzhe.categories.structure.linkedlist.ListNode;

/**
 * @author Xin
 * @date 2020/10/14
 * Title : 142. 环形链表 II
 * Description : 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * link : https://leetcode-cn.com/problems/linked-list-cycle-ii/
 * level ： Medium
 */
public class Leetcode142 {
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
