package com.xinzhe.sword.chapter03;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Xin
 * @date 2020/6/12
 * Title : 03.02. Min Stack LCCI
 * Description : How would you design a stack which, in addition to push and pop, has a function min which returns the minimum element?
 * Push, pop and min should all operate in 0(1) time.
 * link : https://leetcode-cn.com/problems/min-stack-lcci
 * Level : Easy
 */
public class Interview_0302 {
    Deque<Integer> orig;
    Deque<Integer> minStack;

    public Interview_0302() {
        orig = new LinkedList<>();
        minStack = new LinkedList<>();
    }

    public void push(int x) {
        orig.push(x);
        if (minStack.isEmpty()) {
            minStack.push(x);
        } else {
            if (x <= minStack.peek()) {
                minStack.push(x);
            }
        }
    }

    public void pop() {
        int pop = orig.pop();
        if (minStack.peek() == pop) {
            minStack.pop();
        }
    }

    public int top() {
        return orig.isEmpty() ? 0 : orig.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
