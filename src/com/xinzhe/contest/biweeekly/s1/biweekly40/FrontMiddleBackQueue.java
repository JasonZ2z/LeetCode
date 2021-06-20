package com.xinzhe.contest.biweeekly.s1.biweekly40;

import java.util.LinkedList;

/**
 * @author Xin
 * @date 2020/11/28
 * Title : 1670. 设计前中后队列
 * Description : 请你完成FrontMiddleBack类：FrontMiddleBack()初始化队列。
 *              void pushFront(int val) 将val添加到队列的 最前面。
 *              void pushMiddle(int val) 将val添加到队列的 正中间。
 *              void pushBack(int val)将val添加到队里的 最后面。
 *              int popFront()将 最前面 的元素从队列中删除并返回值，如果删除之前队列为空，那么返回 -1。
 *              int popMiddle() 将 正中间的元素从队列中删除并返回值，如果删除之前队列为空，那么返回 -1。
 *              int popBack() 将 最后面 的元素从队列中删除并返回值，如果删除之前队列为空，那么返回 -1。
 * link : https://leetcode-cn.com/problems/design-front-middle-back-queue
 * Level : Medium
 */
public class FrontMiddleBackQueue {
    public static void main(String[] args) {
        FrontMiddleBackQueue lc = new FrontMiddleBackQueue();
        int[] arr = {2, 4, 9, 3};
    }

    LinkedList<Integer> list = new LinkedList<>();
    int size = 0;
    public FrontMiddleBackQueue() {

    }

    public void pushFront(int val) {
        list.add(0, val);
        size++;
    }

    public void pushMiddle(int val) {
        list.add(size/2, val);
        size++;
    }

    public void pushBack(int val) {
        list.add(val);
        size++;
    }

    public int popFront() {
        if(size == 0) return -1;
        int x = list.pollFirst();
        size--;
        return x;
    }

    public int popMiddle() {
        if(size == 0) return -1;
        int x = list.remove((size-1)/2);
        size--;
        return x;
    }

    public int popBack() {
        if(size == 0) return -1;
        int x= list.pollLast();
        size--;
        return x;
    }
}