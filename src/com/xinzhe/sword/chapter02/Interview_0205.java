package com.xinzhe.sword.chapter02;

import com.xinzhe.categories.structure.linkedlist.ListNode;

/**
 * @author Xin
 * @date 2020/10/22
 * Title : 02.05. Sum Lists LCCI
 * Description :  You have two numbers represented by a linked list, where each node contains a single digit. The digits are stored in reverse order, such that the 1's digit is at the head of the list.
 *                Write a function that adds the two numbers and returns the sum as a linked list.
 * link : https://leetcode-cn.com/problems/sum-lists-lcci
 * Level : Medium
 */
public class Interview_0205 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carrier = 0;
        ListNode res = new ListNode(-1);
        ListNode cur = res;
        while(l1 != null || l2 != null) {
            int sum = carrier;
            if(l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            cur.next = new ListNode(sum % 10);
            carrier = sum / 10;
            cur = cur.next;
        }
        if(carrier > 0) cur.next = new ListNode(1);
        return res.next;
    }
}
