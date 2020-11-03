package com.xinzhe.sword.chapter05;

/**
 * @author Xin
 * @date 2020/11/03
 * Title : 面试题 05.01. 插入
 * Description : 插入。给定两个32位的整数N与M，以及表示比特位置的i与j。编写一种方法，将M插入N，使得M从N的第j位开始，到第i位结束。
 *              假定从j位到i位足以容纳M，也即若M = 10 011，那么j和i之间至少可容纳5个位。例如，不可能出现j = 3和i = 2的情况，因为第3位和第2位之间放不下M。
 * link : https://leetcode-cn.com/problems/insert-into-bits-lcci
 * Level : Medium
 */
//todo need to review
public class Interview_0501 {
    public static void main(String[] args) {
        Interview_0501 lc = new Interview_0501();
        System.out.println(lc.insertBits(1024,19,2,6));
    }
    public int insertBits(int N, int M, int i, int j) {
        int mask = ((1<<(j-i+1))-1)<<i;
        mask = ~mask;
        N &= mask;
        M = M<<i;
        return M|N;
    }
}
