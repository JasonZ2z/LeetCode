package com.xinzhe.contest.biweeekly.biweekly40;

import java.util.LinkedList;

/**
 * @author Xin
 * @date 2020/11/28
 * Title :
 * Description :
 * link :
 * Level :
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