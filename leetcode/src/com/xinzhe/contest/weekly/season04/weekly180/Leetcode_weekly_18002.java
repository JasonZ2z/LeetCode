package com.xinzhe.contest.weekly.season04.weekly180;

import java.util.LinkedList;

/**
 * @Author Xin
 * @create 2020/3/16 19:41
 * Title : 5357. 设计一个支持增量操作的栈
 * Description : 实现自定义栈类 CustomStack ：
 *          CustomStack(int maxSize)：用 maxSize 初始化对象，maxSize 是栈中最多能容纳的元素数量，栈在增长到 maxSize 之后则不支持 push 操作。
 *          void push(int x)：如果栈还未增长到 maxSize ，就将 x 添加到栈顶。
 *          int pop()：返回栈顶的值，或栈为空时返回 -1 。
 *          void inc(int k, int val)：栈底的 k 个元素的值都增加 val 。如果栈中元素总数小于 k ，则栈中的所有元素都增加 val 。
 * link : https://leetcode-cn.com/problems/design-a-stack-with-increment-operation
 * Level : Medium
 * Comment 180周賽02
 */
public class Leetcode_weekly_18002 {
    public static void main(String[] args) {
        CustomStack customStack = new CustomStack(3);
        customStack.push(1);
        System.out.println(customStack.pre);
        customStack.push(2);
        System.out.println(customStack.pre);
        customStack.pop();
        System.out.println(customStack.pre);
        customStack.push(2);
        System.out.println(customStack.pre);
        customStack.push(3);
        System.out.println(customStack.pre);
        customStack.push(4);
        System.out.println(customStack.pre);
        customStack.increment(5,100);
        System.out.println(customStack.pre);
        customStack.increment(2,100);
        System.out.println(customStack.pre);
        customStack.pop();
        System.out.println(customStack.pre);
        customStack.pop();
        System.out.println(customStack.pre);
        customStack.pop();
        System.out.println(customStack.pre);
        customStack.pop();
        System.out.println(customStack.pre);
    }
}

class CustomStack{
    LinkedList<Integer> pre;
    int max;
    public CustomStack(int maxSize) {
        pre = new LinkedList<>();
        max = maxSize;

    }

    public void push(int x) {
        if(pre.size() < max) {
            pre.addLast(x);
        }
    }

    public int pop() {
        if(pre.size() > 0){
            return pre.pollLast();
        } else {
            return -1;
        }
    }

    public void increment(int k, int val) {
        if(k <= 0) return;
        if(k >= pre.size()) {
            for (int i = 0; i < pre.size(); i++) {
                pre.set(i, pre.get(i) + val);
            }
        } else {
            LinkedList<Integer> cur = new LinkedList<>();
            int i=0;
            for (; i < k; i++) {
                cur.addLast(pre.get(i) + val);
            }
            while(i< pre.size()){
                cur.addLast(pre.get(i++));
            }
            pre = cur;
        }

    }
}



