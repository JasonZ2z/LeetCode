package com.xinzhe.categories.solutions.binarysearch.math;

/**
 * @author Xin
 * @date 2020/4/15 14:56
 * Title : 29. 两数相除
 * Description : 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 *              返回被除数 dividend 除以除数 divisor 得到的商。
 *              整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 * link : https://leetcode-cn.com/problems/divide-two-integers
 * Level : Medium
 */
//todo need to review
public class Leetcode029 {
    public static void main(String[] args) {
        System.out.println(divide(100,-1));
    }
    public static int divide(int a, int b) {
        if(a == 0) return 0;
        if(a == Integer.MIN_VALUE && b == -1) return Integer.MAX_VALUE;
        boolean flag = (a ^ b) < 0;
        long c = Math.abs((long)a);
        long d = Math.abs((long)b);
        int res = 0;
        for(int i = 31; i >= 0; --i) {
          if((c >> i) >= d){
              res += 1<<i;
              c -= d<<i;
          }
        }
        return flag ? -res : res;
    }
}
