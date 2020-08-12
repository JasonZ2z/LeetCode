package com.xinzhe.top100.medium;

import com.xinzhe.categories.structure.linkedlist.ListNode;

/**
 * @author Xin
 * @date 2020/3/5 21:17
 * Title : 19. 删除链表的倒数第N个节点
 * Description : 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * 示例：
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * link : https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 * Level : Medium
 */
public class Leetcode019 {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode tmp = new ListNode(-1);
        tmp.next = head;
        ListNode p = head;
        ListNode q = tmp;
        int k = n-1;
        while(p.next != null){
            while(k-- > 0){
                p = p.next;
            }
            if(p.next != null){
                p = p.next;
                q = q.next;
            }

        }
        q.next = q.next.next;
        return tmp.next;
    }
}
