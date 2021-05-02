package com.xinzhe.categories.structure.linkedlist.medium;

import com.xinzhe.categories.structure.linkedlist.ListNode;

/**
 * @author Xin
 * @date 2020/11/13
 * Title : 82. 删除排序链表中的重复元素 II
 * Description : 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 * link : https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/
 * Level : Medium
 */

public class Leetcode082 {
    public static void main(String[] args) {
        Leetcode082 lc = new Leetcode082();
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(2);
        ListNode cur = node1;
        while (cur != null) {
            System.out.print(cur.val);
            cur = cur.next;
        }
        System.out.println();
        lc.deleteDuplicates(node1);
        while (node1 != null) {
            System.out.print(node1.val);
            node1 = node1.next;
        }
    }
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode dummy  = new ListNode(-1);
        ListNode cur = dummy;
        ListNode tmp = head;
        int cnt = 1;
        head = head.next;
        while(head != null) {
            if(head.val != tmp.val) {
                if(cnt == 1) {
                    cur.next = tmp;
                    cur =  cur.next;
                    cur.next = null;
                    tmp = head;
                } else {
                    tmp = head;
                    cnt = 1;
                }
            } else {
                cnt++;
            }
            head = head.next;
        }
        if(cnt == 1) cur.next = tmp;
        return dummy.next;
    }
}
