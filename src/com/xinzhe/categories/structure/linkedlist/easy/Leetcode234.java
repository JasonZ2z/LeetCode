package com.xinzhe.categories.structure.linkedlist.easy;

import com.xinzhe.categories.structure.linkedlist.ListNode;

/**
 * @author Xin
 * @date 2020/10/15
 * Title : 234. 回文链表
 * Description : 请判断一个链表是否为回文链表。你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 * link : https://leetcode-cn.com/problems/palindrome-linked-list/
 * level ： easy
 */
public class Leetcode234 {
    public static void main(String[] args) {
        Leetcode234 lc = new Leetcode234();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(1);
        n1.next = n2;
        n2.next = n3;
        System.out.println(lc.isPalindrome(n1));
    }
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        ListNode fast = head, slow = head;
        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode tmp = slow.next;
        slow.next = null;
        ListNode newHead = reverse(tmp);
        fast = head;
        while(fast != null && newHead != null) {
            if(fast.val != newHead.val) return false;
            fast =  fast.next;
            newHead = newHead.next;
        }
        if(fast != null) return fast.next == null;
        return true;
    }
    private ListNode reverse(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode cur = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return cur;
    }
}
