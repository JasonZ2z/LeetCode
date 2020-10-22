package com.xinzhe.sword.chapter02;

import com.xinzhe.categories.structure.linkedlist.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Xin
 * @date 2020/6/12
 * Title : 02.01. Remove Duplicate Node LCCI
 * Description : Write code to remove duplicates from an unsorted linked list.
 * link : https://leetcode-cn.com/problems/remove-duplicate-node-lcci/
 * Level : Easy
 */
public class Interview_0201 {
    public ListNode removeDuplicateNodes(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode cur = head.next;
        ListNode pre = head;
        Set<Integer> set = new HashSet<>();
        set.add(head.val);
        while(cur != null) {
            if(set.contains(cur.val)) {
                pre.next = cur.next;
                cur = cur.next;
            } else {
                set.add(cur.val);
                cur = cur.next;
                pre = pre.next;
            }
        }
        return head;
    }
}
