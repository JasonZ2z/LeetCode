package com.xinzhe.order.day10;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Xin
 * @create 2020/4/18 22:16
 * Title :
 * Description :
 * link :
 * Level :
 */
public class Leetcode_dweekly_2404 {
    public static void main(String[] args) {

    }
    public int numberOfArrays(String s, int k) {
        int n = s.length();
        int[][] dp = new int[n][n];

        int size = (k+"").length();
        for (int i = 1; i < n; ++i) {
            for(int j = 0; j <= size; ++j) {
                int tmp = Integer.parseInt(s.substring(i-j, i+1));
                if(tmp <= k && tmp > 0) {

                }
            }
        }
        return 0;
    }

}
