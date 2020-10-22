package com.xinzhe.sword.chapter02;

import com.xinzhe.categories.structure.linkedlist.ListNode;

/**
 * @author Xin
 * @date 2020/10/22
 * Title : 02.02. Kth Node From End of List LCCI
 * Description : Implement an algorithm to find the kth to last element of a singly linked list. Return the value of the element.
 * link : https://leetcode-cn.com/problems/kth-node-from-end-of-list-lcci
 * Level : Easy
 */
public class Interview_0202 {
    public int kthToLast(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null) {
            if(k > 0) {
                k--;
            } else {
                slow = slow.next;
            }
            fast = fast.next;
        }
        return slow.val;
    }
}
