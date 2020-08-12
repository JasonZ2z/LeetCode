package com.xinzhe.order.day11;

import com.xinzhe.categories.structure.linkedlist.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Xin
 * @date 2020/4/26
 * Title : 23. 合并K个排序链表
 * Description : 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * link : https://leetcode-cn.com/problems/merge-k-sorted-lists/
 * Level : Hard
 */

public class Leetcode023 {
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        if(n == 0) return null;
        if(n == 1) return lists[0];

        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        for (ListNode list : lists) {
            if (list != null) {
                queue.add(list);
            }
        }
        ListNode pre = new ListNode(-1);
        ListNode cur = pre;
        while (!queue.isEmpty()){
            cur.next = queue.poll();
            cur = cur.next;
            if(cur.next != null) {
                queue.add(cur.next);
            }
        }
        return pre.next;
    }
}
