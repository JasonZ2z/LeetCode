package com.xinzhe.sword.chapter03;

import java.util.Stack;

/**
 * @author Xin
 * @date 2020/10/23
 * Title : 03.05. 栈排序
 * Description : 栈排序。 编写程序，对栈进行排序使最小元素位于栈顶。最多只能使用一个其他的临时栈存放数据，但不得将元素复制到别的数据结构（如数组）中。该栈支持如下操作：push、pop、peek 和 isEmpty。当栈为空时，peek 返回 -1。
 * link : https://leetcode-cn.com/problems/sort-of-stacks-lcci
 * Level : Medium
 */
public class SortedStack {
    Stack<Integer> s = new Stack<>();
    Stack<Integer> h = new Stack<>();

    public SortedStack() {

    }

    public void push(int val) {
        while (!s.isEmpty() && val > s.peek()) {
            h.push(s.pop());
        }
        s.push(val);
        while (!h.isEmpty()) {
            s.push(h.pop());
        }
    }

    public void pop() {
        if(isEmpty()) return;
        s.pop();
    }

    public int peek() {
        if (isEmpty()) return -1;
        return s.peek();
    }

    public boolean isEmpty() {
        return s.isEmpty();
    }
}
