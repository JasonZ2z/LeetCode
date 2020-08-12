package com.xinzhe.top100.medium;

import com.xinzhe.categories.structure.linkedlist.ListNode;

/**
 * @author Xin
 * @date 2020/2/28 21:09
 * Title : 2. 两数相加
 * Description : 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，
 *              并且它们的每个节点只能存储 一位 数字。
 *              如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *              您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * link : https://leetcode-cn.com/problems/add-two-numbers
 */
public class Leetcode002 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode p = l1;
        ListNode q = l2;
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        int carrier = 0;
        int i;
        int j;
        while (p != null || q != null){
            if(p == null){
                i = 0;
            } else {
                i = p.val;
                p = p.next;
            }
            if(q == null){
                j = 0;
            } else {
                j = q.val;
                q = q.next;
            }
            int tmp = i + j + carrier;
            cur.next = new ListNode(tmp % 10);
            carrier = tmp /10;
            cur = cur.next;
        }
        if(carrier == 1){
            cur.next = new ListNode(1);
        }

        return head.next;

    }
}
