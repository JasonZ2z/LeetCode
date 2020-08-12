package com.xinzhe.categories.solutions.bitmanipulation.easy;

/**
 * @author Xin
 * @date 2020/8/12
 * Title : 371. 两整数之和
 * Description : 不使用运算符 + 和 - ​​​​​​​，计算两整数 ​​​​​​​a 、b ​​​​​​​之和。
 * link : https://leetcode-cn.com/problems/sum-of-two-integers/
 * Level : Easy
 */
//todo need to review
public class Leetcode371 {
    public static void main(String[] args) {
       int[] x = {1,-2,-5,0,10};
       int[] y = {0,-2,-1,-7,-4};
        Leetcode371 lc = new Leetcode371();
    }

    //a ^ b : 无进位结果
    // (a & b) << 1 进位
    public int getSum(int a, int b) {
        while(b != 0) {
            int tmp = a^b;
            b = (a&b) << 1;
            a = tmp;
        }
        return a;
    }
}
