package com.xinzhe.top100.medium;

import com.xinzhe.categories.linkedList.ListNode;

import java.util.Stack;

/**
 * @Author Xin
 * @create 2020/2/28 21:53
 * Title :
 * Description : 给定两个非空链表来代表两个非负整数。数字最高位位于链表开始位置。它
 *              们的每个节点只存储单个数字。将这两数相加会返回一个新的链表。
 *              你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * link : https://leetcode-cn.com/problems/add-two-numbers-ii
 * Level :
 */
public class Leetcode445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode p = l1;
        Stack<Integer> stack1 = new Stack<>();
        while(p != null){
            stack1.push(p.val);
            p = p.next;
        }

        ListNode q = l2;
        Stack<Integer> stack2 = new Stack<>();
        while(q != null){
            stack2.push(q.val);
            q = q.next;
        }
        int carrier = 0;
        ListNode head = new ListNode(1);
        while(!stack1.isEmpty() || !stack2.isEmpty()){
            int i = stack1.isEmpty()? 0 : stack1.pop();
            int j = stack2.isEmpty()? 0 : stack2.pop();
            int sum = i +j + carrier;
            ListNode node = new ListNode(sum % 10);
            carrier = sum /10;
            ListNode tmp = head.next;
            head.next = node;
            node.next = tmp;
        }

        if(carrier == 1){
            return head;
        } else {
            return head.next;
        }
    }
}
