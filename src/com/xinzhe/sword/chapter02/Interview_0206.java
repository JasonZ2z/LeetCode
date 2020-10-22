package com.xinzhe.sword.chapter02;

import com.xinzhe.categories.structure.linkedlist.ListNode;

/**
 * @author Xin
 * @date 2020/10/22
 * Title : 02.06. Palindrome Linked List LCCI
 * Description :  Implement a function to check if a linked list is a palindrome.
 * link : https://leetcode-cn.com/problems/palindrome-linked-list-lcci/
 * Level : Easy
 */
public class Interview_0206 {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode newHead = slow.next;
        slow.next = null;
        ListNode cur = reverse(newHead);
        while(head != null && cur != null) {
            if(head.val != cur.val) return false;
            head = head.next;
            cur = cur.next;
        }
        return true;
    }

    private ListNode reverse(ListNode node) {
        if(node == null || node.next == null) return node;
        ListNode newHead = reverse(node.next);
        node.next.next = node;
        node.next = null;
        return newHead;
    }
}
