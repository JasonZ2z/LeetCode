package com.xinzhe.contest.weekly.season05.weekly223;

import com.xinzhe.categories.structure.linkedlist.ListNode;

/**
 * @author Xin
 * @date 2021/01/10
 * Title : 1721. 交换链表中的节点
 * Description : 给你链表的头节点 head 和一个整数 k 。交换 链表正数第 k 个节点和倒数第 k 个节点的值后，返回链表的头节点（链表 从 1 开始索引）。
 * link : https://leetcode-cn.com/problems/swapping-nodes-in-a-linked-list/
 * Level : Medium
 */
public class Leetcode_weekly_22302 {
    public static void main(String[] args) {
        Leetcode_weekly_22302 lc = new Leetcode_weekly_22302();
        int[] arr = {3,5};
    }
    public ListNode swapNodes(ListNode head, int k) {
        int n = 0;
        ListNode dummy = new ListNode( -1);
        dummy.next = head;
        ListNode cur = head;
        ListNode first = head;
        ListNode next = head;
        while (cur != null) {
            n++;
            if(n == k) {
                first = cur;
            }
            cur = cur.next;

        }

        int x = 0;
        cur = head;
        while (cur != null) {
            x++;
            if(x == n - k + 1) {
                next = cur;
            }
            cur = cur.next;
        }

        int tmp = first.val;
        first.val = next.val;
        next.val = tmp;
        return dummy.next;
    }
}
