package com.xinzhe.categories.solutions.hash;

import com.xinzhe.categories.structure.linkedlist.ListNode;

import java.util.LinkedList;

/**
 * @author Xin
 * @date 2020/4/14 21:53
 * Title : 445. 两数相加 II
 * Description : 给定两个非空链表来代表两个非负整数。数字最高位位于链表开始位置。它
 *              们的每个节点只存储单个数字。将这两数相加会返回一个新的链表。
 *              你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * link : https://leetcode-cn.com/problems/add-two-numbers-ii
 * Level : Medium
 */

public class Leetcode445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        LinkedList<Integer> list1 = new LinkedList<>();
        while (l1 != null){
            list1.addLast(l1.val);
            l1 = l1.next;
        }
        LinkedList<Integer> list2 = new LinkedList<>();
        while (l2 != null){
            list2.addLast(l2.val);
            l2 = l2.next;
        }
        boolean flag = false;
        ListNode pre = new ListNode(-1);
        ListNode cur = null;
        while (!list1.isEmpty() || !list2.isEmpty()){
            int node1 = list1.isEmpty() ? 0 : list1.pollLast();
            int node2 = list2.isEmpty() ? 0 : list2.pollLast();
            int sum;
            if(flag) {
                sum = node1 + node2 + 1;
            } else {
                sum = node1 + node2;
            }
            int value = sum % 10;
            flag = sum / 10 > 0;
            ListNode tmp = new ListNode(value);
            tmp.next = cur;
            pre.next = tmp;
            cur = tmp;
        }
        if(flag){
            pre.val = 1;
            return pre;
        }
        return pre.next;
    }
}
