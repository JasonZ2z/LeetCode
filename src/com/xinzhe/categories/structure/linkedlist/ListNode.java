package com.xinzhe.categories.structure.linkedlist;


public class ListNode {
     public int val;
     public ListNode next;

     public ListNode(int x) {
          val = x;
     }

     @Override
     public String toString() {
          return "ListNode{" +
                  "val=" + val +
                  '}';
     }
}
