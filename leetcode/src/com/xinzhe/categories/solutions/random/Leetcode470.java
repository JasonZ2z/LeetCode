package com.xinzhe.categories.solutions.random;

import java.util.Random;

/**
 * @Author Xin
 * @create 2020/5/6
 * Title : 470. 用 Rand7() 实现 Rand10()
 * Description : 已有方法 rand7 可生成 1 到 7 范围内的均匀随机整数，试写一个方法 rand10 生成 1 到 10 范围内的均匀随机整数。
 *              不要使用系统的 Math.random() 方法。
 * link : https://leetcode-cn.com/problems/implement-rand10-using-rand7
 * Level : Medium
 */
//todo need to review
public class Leetcode470 {
    public static void main(String[] args) {
        System.out.println(rand10());
    }
    public static int rand10() {
        while (true) {
            int num = (rand7() - 1) * 7 + rand7();
            if (num <= 40) return num % 10 + 1;
            num = (num - 40 - 1) * 7 + rand7();
            if (num <= 60) return num % 10 + 1;
            num = (num - 60 - 1) * 7 + rand7();
            if (num <= 20) return num % 10 + 1;
        }
    }
    public static int rand7(){
        Random random = new Random();
        return random.nextInt(8);
    }
}
