package com.xinzhe.categories.structure.test;

import com.xinzhe.categories.structure.linkedlist.ListNode;

import java.util.Stack;

/**
 * @author xzheng
 * @since 1
 */
public class TestSolution {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        node.next = node2;
        node2.next = node3;
        System.out.println(isPalindrome(node));

    }
    public static boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        Stack<Integer> stack= new Stack<>();
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode fast = pre;
        ListNode slow = pre;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            stack.push(slow.val);
        }
        if(fast == null) stack.pop();
        while(slow.next != null && !stack.isEmpty()){

            slow = slow.next;
            int value = stack.pop();
            if(slow.val != value){
                return false;
            }
        }
        return true;

    }

}
