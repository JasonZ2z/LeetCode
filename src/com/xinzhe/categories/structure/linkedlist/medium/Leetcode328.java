package com.xinzhe.categories.structure.linkedlist.medium;

import com.xinzhe.categories.structure.linkedlist.ListNode;

/**
 * @author Xin
 * @date 2020/5/16
 * Title : 328. 奇偶链表
 * Description : 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 *              请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 * link : https://leetcode-cn.com/problems/odd-even-linked-list
 * Level : Medium
 */

public class Leetcode328 {
    public static void main(String[] args) {
        Leetcode328 lc = new Leetcode328();
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(3);
        node1.next.next.next = new ListNode(4);
        ListNode cur = node1;
        while (cur != null) {
            System.out.print(cur.val);
            cur = cur.next;
        }
        System.out.println();
        lc.oddEvenList(node1);
        while (node1 != null) {
            System.out.print(node1.val);
            node1 = node1.next;
        }
    }
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) return head;
        ListNode fix = head.next;
        ListNode tail = head;
        ListNode cur =  fix.next;
        ListNode pre = fix;
        ListNode next;
        while(cur != null) {
            next = cur.next;
            pre.next = cur.next;
            tail.next = cur;
            cur.next = fix;
            tail = tail.next;
            cur = next;
            if (cur != null) {
                pre = cur;
                cur = cur.next;
            }
        }
        return head;
    }
    //todo need to review
    public ListNode oddEvenList2(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return head;
        ListNode odd = head;
        ListNode evenHead = head.next;
        ListNode even = evenHead;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;

    }

}
