package com.xinzhe.contest.biweeekly.s1.biweekly40;

import com.xinzhe.categories.structure.linkedlist.ListNode;

/**
 * @author Xin
 * @date 2020/11/28
 * Title : 1669. 合并两个链表
 * Description : 给你两个链表list1 和list2，它们包含的元素分别为n 个和m 个。请你将list1中第a个节点到第b个节点删除，并将list2接在被删除节点的位置。
 * link : https://leetcode-cn.com/problems/merge-in-between-linked-lists
 * Level : Medium
 */
public class Leetcode_biweekly_4002 {
    public static void main(String[] args) {
        Leetcode_biweekly_4002 lc = new Leetcode_biweekly_4002();
        int[] arr = {2, 4, 9, 3};
    }

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode l2End = list2;
        while(l2End.next != null) {
            l2End = l2End.next;
        }
        ListNode cur = list1;
        ListNode end = null;
        ListNode pre = null;
        for (int i = 0; i <= b; i++) {
            pre = cur;
            cur = cur.next;
            if(i == a) {
                end = pre;
            }
        }
        end.next = null;
        pre.next = null;
        end.next = list2;
        l2End.next = cur;
        return list1;
    }
}