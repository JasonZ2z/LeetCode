package com.xinzhe.sword.chapter03;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author Xin
 * @create 2020/6/12
 * Title : 03.04. Implement Queue using Stacks LCCI
 * Description : Implement a MyQueue class which implements a queue using two stacks.
 * link : https://leetcode-cn.com/problems/implement-queue-using-stacks-lcci/
 * Level : Easy
 */
public class Interview_0304 {
    Deque<Integer> orig;
    Deque<Integer> minStack;

    public Interview_0304() {
        orig = new LinkedList<>();
        minStack = new LinkedList<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        orig.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        peek();
        return minStack.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (minStack.isEmpty()) return orig.peek();
        while (!orig.isEmpty()) {
            minStack.push(orig.pop());
        }
        return minStack.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return minStack.isEmpty() && orig.isEmpty();
    }
}
