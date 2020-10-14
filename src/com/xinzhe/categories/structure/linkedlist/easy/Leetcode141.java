package com.xinzhe.categories.structure.linkedlist.easy;

import com.xinzhe.categories.structure.linkedlist.ListNode;

/**
 * @author Xin
 * @date 2020/10/14
 * Title : 141. 环形链表
 * Description : 给定一个链表，判断链表中是否有环。
 * link : https://leetcode-cn.com/problems/linked-list-cycle/
 * level ： easy
 */
public class Leetcode141 {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast.next != null && fast.next.next != null) {
            if(slow == fast) return true;
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }
}
