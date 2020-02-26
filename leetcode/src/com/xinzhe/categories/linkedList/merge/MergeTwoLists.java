package com.xinzhe.categories.linkedList.merge;

import com.xinzhe.categories.linkedList.ListNode;

/**
 * @Author Xin
 * @create 2020/2/18 21:44
 */
public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode node = new ListNode(-1);
        ListNode cur = node;
        while(l1 != null && l2 != null){
            if(l1.val > l2.val){
                cur.next = l2;
                l2 = l2.next;
            } else {
                cur.next = l1;
                l1 = l1.next;
            }

        }
        if(l1 == null){
            cur.next = l2;
        }
        if(l2 == null) {
            cur.next = l1;
        }
        return node.next;
    }
}
