package com.xinzhe.categories.solutions.bitmanipulation.easy;

/**
 * @Author Xin
 * @create 2020/5/2
 * Title : 389. 找不同
 * Description : 给定两个字符串 s 和 t，它们只包含小写字母。
 *      字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 *      请找出在 t 中被添加的字母。
 * link : https://leetcode-cn.com/problems/find-the-difference/
 * Level : Easy
 */
public class Leetcode389 {
    //char 也可以位运算
    public char findTheDifference(String s, String t) {
        char res = 0;
        for(int i=0; i< s.length(); i++){
            res ^= s.charAt(i);
        }
        for(int i=0; i< t.length(); i++){
            res ^= t.charAt(i);
        }
        return res;
    }
}
