package com.xinzhe.contest.summer2020;

/**
 * @author Xin
 * @date 2020/9/12
 * Title :
 * Description :
 * link :
 * Level :
 */
public class Leetcode_singel_001 {
    public int calculate(String s) {
        int n = s.length();
        if(n == 0) return 1;
        char[] arr = s.toCharArray();
        int x = 1, y=0;
        for (char c : arr) {
            if(c == 'A') {
                x = 2*x +y;
            } else {
                y = 2 *y + x;
            }
        }
        return x + y;
    }
}
