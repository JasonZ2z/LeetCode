package com.xinzhe.sword.chapter08;

/**
 * @author Xin
 * @date 2020/7/14
 * Title : 08.05. 递归乘法
 * Description : 递归乘法。 写一个递归函数，不使用 * 运算符， 实现两个正整数的相乘。可以使用加号、减号、位移，但要吝啬一些。
 * link : https://leetcode-cn.com/problems/recursive-mulitply-lcci/
 * Level : Medium
 */
public class Interview_0805 {
    public static void main(String[] args) {
        Interview_0805 lc = new Interview_0805();
        System.out.println(lc.multiply(5, 9));
    }
    public int multiply(int A, int B) {
        if(A == 0 || B == 0 ) return 0;
        if(A == 1) return B;
        if(B == 1) return A;
        if(B > A) return multiply(B, A);
        int ans = 0;
        while(B > 1) {
            ans += (A << 1);
            B -= 2;
        }
        return B == 0 ? ans : ans + A;
    }
}
