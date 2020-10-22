package com.xinzhe.sword.chapter03;

import java.util.Stack;

/**
 * @author Xin
 * @date 2020/6/12
 * Title : 03.04. Implement Queue using Stacks LCCI
 * Description : Implement a MyQueue class which implements a queue using two stacks.
 * link : https://leetcode-cn.com/problems/implement-queue-using-stacks-lcci/
 * Level : Easy
 */
public class MyQueue2 {
    Stack<Integer> orig;
    Stack<Integer> minStack;
    /** Initialize your data structure here. */
    public MyQueue2() {
        orig = new Stack<>();
        minStack = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        orig.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        peek();
        return minStack.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (minStack.isEmpty()) {
            while (!orig.isEmpty()) {
                minStack.push(orig.pop());
            }
        }
        return minStack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return minStack.isEmpty() && orig.isEmpty();
    }
}
