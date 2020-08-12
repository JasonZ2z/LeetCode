package com.xinzhe.categories.solutions.dp.math;

/**
 * @author Xin
 * @date 2020/3/16 18:41
 * Title : 338. 比特位计数
 * Description : 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 *
 * 示例 1:
 *
 * 输入: 2
 * 输出: [0,1,1]
 * link : https://leetcode-cn.com/problems/counting-bits/
 * Level : Medium
 */
public class Leetcode338 {
    public static void main(String[] args) {
        int i = 1 & 3;
        int i1 = 3 >> 1;
        System.out.println(i);
        System.out.println(i1);
    }
    public int[] countBits(int num) {
        int[] res = new int[num+1];
        res[0] = 0;
        res[1] = 1;
        for (int i = 2; i <= num; i++) {
            res[i] = res[i >> 1] + (1 & i);
        }
        return res;
    }
}
