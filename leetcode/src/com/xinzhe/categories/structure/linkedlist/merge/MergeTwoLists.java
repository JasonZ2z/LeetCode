package com.xinzhe.categories.structure.linkedlist.merge;

import com.xinzhe.categories.structure.linkedlist.ListNode;

/**
 * @Author Xin
 * @create 2020/2/18 21:44
 */
public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode node = new ListNode(-1);
        while(l1 != null && l2 != null){
            if(l1.val > l2.val){
                node.next = l2;
                l2 = l2.next;
            } else {
                node.next = l1;
                l1 = l1.next;
            }

        }
        if(l1 == null){
            node.next = l2;
        }
        if(l2 == null) {
            node.next = l1;
        }
        return node.next;
    }
}
