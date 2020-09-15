package com.xinzhe.contest.lccup.spring2020;

/**
 * @author Xin
 * @date 2020/9/15
 * Title : LCP 01. 猜数字
 * Description : ...
 * link : https://leetcode-cn.com/problems/guess-numbers/
 * Level : Easy
 */
public class LCP_01 {
    public int game(int[] guess, int[] answer) {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            if (guess[i] == answer[i]) {
                count++;
            }
        }
        return count;
    }
}
