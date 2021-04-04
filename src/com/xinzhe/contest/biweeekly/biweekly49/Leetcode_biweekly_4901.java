package com.xinzhe.contest.biweeekly.biweekly49;

/**
 * @author Xin
 * @date 2021/04/03
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_biweekly_4901 {
    public static void main(String[] args) {
        Leetcode_biweekly_4901 lc = new Leetcode_biweekly_4901();
    }
    public boolean squareIsWhite(String coordinates) {
        char x = coordinates.charAt(0);
        char y = coordinates.charAt(1);
        if((x - 'a') % 2 == 0) {
            return (y - '1') % 2 != 0;
        }else {
            return (y - '1') % 2 == 0;
        }
    }
}