package com.xinzhe.categories.solutions.dp.math;

/**
 * @author Xin
 * @date 2020/3/17 18:41
 * Title : 263. 丑数
 * Description : 编写一个程序判断给定的数是否为丑数。丑数就是只包含质因数 2, 3, 5 的正整数。
 * link : https://leetcode-cn.com/problems/ugly-number/
 * Level : Easy
 */
public class Leetcode263 {
    public boolean isUgly(int num) {
        while ( num % 2 == 0){
            num /= 2;
        }
        while ( num % 5 == 0){
            num /= 5;
        }
        while ( num % 3 == 0){
            num /= 3;
        }
        return num == 1;
    }
}
