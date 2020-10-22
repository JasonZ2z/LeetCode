package com.xinzhe.sword.chapter03;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Xin
 * @date 2020/6/12
 * Title : 03.02. 栈的最小值
 * Description : 请设计一个栈，除了常规栈支持的pop与push函数以外，还支持min函数，该函数返回栈元素中的最小值。执行push、pop和min操作的时间复杂度必须为O(1)。
 * link : https://leetcode-cn.com/problems/min-stack-lcci
 * Level : Easy
 */
public class MinStack {
    Deque<Integer> orig;
    Deque<Integer> minStack;

    public MinStack() {
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
