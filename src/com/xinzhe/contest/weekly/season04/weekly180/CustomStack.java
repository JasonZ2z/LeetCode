package com.xinzhe.contest.weekly.season04.weekly180;

/**
 * @author Xin
 * @date 2020/3/16 19:41
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
public class CustomStack {
    int[] stack;
    int[] increase;
    int pos = -1;
    int maxSize;
    public CustomStack(int maxSize) {
        stack = new int[maxSize];
        increase = new int[maxSize];
        this.maxSize = maxSize;
    }

    public void push(int x) {
        if(pos == maxSize - 1) return;
        stack[++pos] = x;
    }

    public int pop() {
        if(pos == -1) return -1;
        int x = stack[pos];
        int y = increase[pos];
        increase[pos] = 0;
        if(pos != 0) increase[pos-1] += y;
        pos--;
        return x + y;
    }

    public void increment(int k, int val) {
        if(pos == -1) return;
        if(k -1 > pos) {
            increase[pos] += val;
        } else {
            increase[k-1] += val;
        }
    }
}





