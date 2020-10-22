package com.xinzhe.sword.chapter03;

import java.util.Arrays;

/**
 * @author Xin
 * @date 2020/6/12
 * Title : 03.01. 三合一
 * Description : 三合一。描述如何只用一个数组来实现三个栈。
 *              你应该实现push(stackNum, value)、pop(stackNum)、isEmpty(stackNum)、peek(stackNum)方法。
 *              stackNum表示栈下标，value表示压入的值。构造函数会传入一个stackSize参数，代表每个栈的大小。
 * link : https://leetcode-cn.com/problems/three-in-one-lcci
 * Level : Easy
 */
public class TripleInOne {
    int[] arr;
    int a, b, c, stackSize;
    public TripleInOne(int stackSize) {
        this.stackSize = stackSize;
        arr = new int[3 * (stackSize + 1)];
        Arrays.fill(arr, -1);
        a = 0;
        b = stackSize + 1;
        c = 2 * (stackSize + 1);
    }

    public void push(int stackNum, int value) {
        if(stackNum == 0) {
            if(a < stackSize) {
                a++;
                arr[a] = value;
            }
        } else if(stackNum == 1) {
            if(b < 2 * (stackSize + 1) - 1) {
                b++;
                arr[b] = value;
            }

        } else {
            if(c < 3 * (stackSize + 1) - 1) {
                c++;
                arr[c] = value;
            }
        }
    }

    public int pop(int stackNum) {
        int x;
        if(stackNum == 0) {
            x = arr[a];
            if(a > 0) a--;
        } else if(stackNum == 1) {
            x = arr[b];
            if(b > stackSize + 1) b--;
        } else {
            x = arr[c];
            if(c > 2 * (stackSize + 1)) c--;
        }
        return x;
    }

    public int peek(int stackNum) {
        if(stackNum == 0) {
            return arr[a];
        } else if(stackNum == 1) {
            return arr[b];
        } else {
            return arr[c];
        }
    }

    public boolean isEmpty(int stackNum) {
        if(stackNum == 0) {
            return a == 0;
        } else if(stackNum == 1) {
            return b == stackSize + 1;
        } else {
            return c == 2 * (stackSize + 1);
        }
    }
}
