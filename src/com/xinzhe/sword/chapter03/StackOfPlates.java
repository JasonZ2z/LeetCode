package com.xinzhe.sword.chapter03;

import java.util.LinkedList;

/**
 * @author Xin
 * @date 2020/6/12
 * Title : 03.02. 栈的最小值
 * Description : 请设计一个栈，除了常规栈支持的pop与push函数以外，还支持min函数，该函数返回栈元素中的最小值。执行push、pop和min操作的时间复杂度必须为O(1)。
 * link : https://leetcode-cn.com/problems/min-stack-lcci
 * Level : Easy
 */
public class StackOfPlates {
    int cap;
    LinkedList<LinkedList<Integer>> list = new LinkedList<>();

    public StackOfPlates(int cap) {
        this.cap = cap;
    }

    public void push(int val) {
        if (cap == 0) {
            return;
        }
        if(list.isEmpty()) list.addLast(new LinkedList<>());
        LinkedList<Integer> stack = list.peekLast();
        if (stack.size() == cap) {
            LinkedList<Integer> newStack = new LinkedList<>();
            newStack.addLast(val);
            list.addLast(newStack);
        } else {
            stack.addLast(val);
        }
    }

    public int pop() {
        if(list.isEmpty()) return -1;
        LinkedList<Integer> stack = list.peekLast();
        if (stack.isEmpty()) return -1;
        if (stack.size() == 1 && list.size() > 1) {
            int poll = stack.pollLast();
            list.pollLast();
            return poll;
        }
        return stack.pollLast();
    }

    public int popAt(int index) {
        if(list.isEmpty()) return -1;
        if(index < 0 || index >= list.size()) return -1;
        LinkedList<Integer> stack = list.get(index);
        if (stack.isEmpty()) return -1;
        if (stack.size() == 1 && list.size() > 1) {
            Integer poll = stack.pollLast();
            list.remove(index);
            return poll;
        }
        return stack.pollLast();
    }
}
