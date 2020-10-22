package com.xinzhe.sword.chapter02;

import com.xinzhe.categories.structure.linkedlist.ListNode;

/**
 * @author Xin
 * @date 2020/10/22
 * Title : 02.04. Partition List LCCI
 * Description : Write code to partition a linked list around a value x, such that all nodes less than x come before all nodes greater than or equal to x.
 *              If x is contained within the list, the values of x only need to be after the elements less than x (see below). The partition element x can appear anywhere in the "right partition"; it does not need to appear between the left and right partitions.
 * link : https://leetcode-cn.com/problems/partition-list-lcci
 * Level : Medium
 */
public class Interview_0204 {
    public ListNode partition(ListNode head, int x) {
        ListNode cur = head, prev = head;
        while (cur != null) {
            if (cur.val < x) {
                int tmp = prev.val;
                prev.val = cur.val;
                cur.val = tmp;
                prev = prev.next;
            }
            cur = cur.next;
        }
        return head;
    }
}
