package com.xinzhe.categories.structure.linkedlist.hard;

import com.xinzhe.categories.structure.linkedlist.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author Xin
 * @create 2020/4/21
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
            if(list != null) {
                queue.add(list);
            }
        }
        ListNode pre = new ListNode(-1);
        ListNode cur = pre;
        while (!queue.isEmpty()){
            ListNode tmp = queue.poll();
            cur.next = tmp;
            cur = cur.next;
            if(cur.next != null){
                queue.add(tmp.next);
            }
        }
        return pre.next;
    }
}
