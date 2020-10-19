package com.xinzhe.contest.biweeekly.biweekly37;

import java.math.BigInteger;
import java.util.ArrayList;

/**
 * @author Xin
 * @date 2020/10/17
 * Title : 1622. 奇妙序列
 * Description : 请你实现三个 API append，addAll 和 multAll 来实现奇妙序列。请实现 Fancy 类 ：
 *              Fancy() 初始化一个空序列对象。
 *              void append(val) 将整数 val 添加在序列末尾。
 *              void addAll(inc) 将所有序列中的现有数值都增加 inc 。
 *              void multAll(m) 将序列中的所有现有数值都乘以整数 m 。
 *              int getIndex(idx) 得到下标为 idx 处的数值（下标从 0 开始），并将结果对 109 + 7 取余。如果下标大于等于序列的长度，请返回 -1 。
 * link : https://leetcode-cn.com/problems/fancy-sequence
 * Level : Hard
 */

//todo too hard to solve
public class Fancy {

    private final int p = 1_000_000_007;
    private final BigInteger bigP = BigInteger.valueOf(p);
    private final ArrayList<BigInteger> arr = new ArrayList<>();
    private BigInteger a = BigInteger.ONE;
    private BigInteger b = BigInteger.ZERO;
    private BigInteger revA = a;

    public void append(int val) {
        if (revA == null) revA = a.modInverse(bigP);
        arr.add(BigInteger.valueOf(val).add(bigP).subtract(b).multiply(revA).mod(bigP));
    }

    public void addAll(int inc) {
        b = b.add(BigInteger.valueOf(inc)).mod(bigP);
    }

    public void multAll(int m) {
        a = a.multiply(BigInteger.valueOf(m)).mod(bigP);
        b = b.multiply(BigInteger.valueOf(m).mod(bigP));
        revA = null;
    }

    public int getIndex(int idx) {
        if (idx >= arr.size()) return -1;
        return arr.get(idx).multiply(a).add(b).mod(bigP).intValue();
    }
}
