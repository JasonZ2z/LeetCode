package com.xinzhe.categories.structure.linkedlist.medium;

import com.xinzhe.categories.structure.linkedlist.ListNode;

/**
 * @author Xin
 * @date 2020/11/13
 * Title : 725. 分隔链表
 * Description : 给定一个头结点为 root 的链表, 编写一个函数以将链表分隔为 k 个连续的部分。 每部分的长度应该尽可能的相等: 任意两部分的长度差距不能超过 1，也就是说可能有些部分为 null。
 *              这k个部分应该按照在链表中出现的顺序进行输出，并且排在前面的部分的长度应该大于或等于后面的长度。返回一个符合上述规则的链表的列表。
 * link : https://leetcode-cn.com/problems/split-linked-list-in-parts
 * Level : Medium
 */

public class Leetcode725 {
    public static void main(String[] args) {
        Leetcode725 lc = new Leetcode725();
        ListNode head = new ListNode(1);
        ListNode cur = head;
        for (int i = 2; i <= 3; ++i) {
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        ListNode cur1 = head;
        while (cur1 != null) {
            System.out.print(cur1.val);
            cur1 = cur1.next;
        }
        System.out.println();
        ListNode[] listNodes = lc.splitListToParts(head, 5);
        for (ListNode listNode : listNodes) {
            ListNode cur2 = listNode;
            while (cur2 != null) {
                System.out.print(cur2.val);
                cur2 = cur2.next;
            }
            System.out.println();
        }
    }
    public ListNode[] splitListToParts(ListNode root, int k) {
        int cnt = 0;
        ListNode cur = root;
        while (cur != null) {
            cur = cur.next;
            cnt++;
        }
        ListNode[] ans = new ListNode[k];
        int i = 0;
        while (root != null && k > 0) {
            int x = (int) Math.ceil(cnt * 1.0 / k);
            cnt -= x;
            ListNode next = root;
            while (next != null && x > 1) {
                next = next.next;
                x--;
            }
            if(next != null) {
                ListNode newHead = next.next;
                next.next = null;
                ans[i++] = root;
                root= newHead;
            } else {
                ans[i++] = root;
                root = next;
            }
            k--;
        }
        return ans;
    }
}
