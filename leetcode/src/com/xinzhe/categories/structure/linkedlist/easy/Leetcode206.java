package com.xinzhe.categories.structure.linkedlist.easy;

import com.xinzhe.categories.structure.linkedlist.ListNode;

/**
 * @Author Xin
 * @create 2020/03/02 18:01
 * Title : 206. 反转链表
 * Description : 反转一个单链表。
 * link : https://leetcode-cn.com/problems/reverse-linked-list/
 * level ： easy
 */
public class Leetcode206 {
    //递归
    public ListNode reverseList(ListNode head) {
        if(head == null ||head.next == null) return head;
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
