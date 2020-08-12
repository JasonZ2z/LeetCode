package com.xinzhe.categories.structure.design.easy;

import java.util.Stack;

/**
 * @Author Xin
 * @create 2020/5/12
 * Title : 232. 用栈实现队列
 * Description : 使用栈实现队列的下列操作：
 * push(x) -- 将一个元素放入队列的尾部。
 * pop() -- 从队列首部移除元素。
 * peek() -- 返回队列首部的元素。
 * empty() -- 返回队列是否为空。
 * link : https://leetcode-cn.com/problems/implement-queue-using-stacks
 * Level : Easy
 */

public class MyQueue {
    Stack<Integer> s1;
    Stack<Integer> s2;

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        s1.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (s2.size() == 0) {
            while (s1.size() > 0) {
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (s2.size() == 0) {
            while (s1.size() > 0) {
                s2.push(s1.pop());
            }
        }
        return s2.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}
