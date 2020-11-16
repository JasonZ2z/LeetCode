package com.xinzhe.categories.structure.linkedlist.medium;

import com.xinzhe.categories.structure.linkedlist.ListNode;

/**
 * @author Xin
 * @date 2020/10/14
 * Title : 147. 对链表进行插入排序
 * Description : 对链表进行插入排序。
 * link : https://leetcode-cn.com/problems/insertion-sort-list/
 * level ： Medium
 */
public class Leetcode147 {
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode res = new ListNode(-1);
        ListNode cur = head.next;
        head.next = null;
        res.next = head;

        while(cur != null) {
            ListNode next = cur.next;
            cur.next = null;
            ListNode tmp = res.next;
            ListNode pre = res;
            boolean flag = false;
            while(tmp != null) {
                if(cur.val < tmp.val) {
                    pre.next = cur;
                    cur.next = tmp;
                    flag = true;
                    break;
                }
                tmp =  tmp.next;
                pre = pre.next;
            }
            if(!flag) pre.next = cur;
            cur = next;
        }
        return res.next;
    }
}
