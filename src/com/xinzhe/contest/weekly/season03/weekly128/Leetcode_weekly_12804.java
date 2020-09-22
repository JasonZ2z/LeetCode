package com.xinzhe.contest.weekly.season03.weekly128;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author Xin
 * @date 2020/9/22
 * Title : 1012. 至少有 1 位重复的数字
 * Description : 给定正整数 N，返回小于等于 N 且具有至少 1 位重复数字的正整数的个数。
 * link : https://leetcode-cn.com/problems/numbers-with-repeated-digits/
 * Level : Hard
 */
//todo need to review

/**
 * E.g :3562
 * case 1:
 * 4th 3th 2th 1th total
 *  0   0   0  1-9 9xA(9,0)
 *  0   0  1-9 0-9 9xA(9,1)
 *  0  1-9 0-9 0-9 9xA(9,2)
 *
 * case 2:
 * 4th 3th 2th 1th total
 * 1-2 0-9 0-9 0-9 2xA(9,3)
 *  3  0-4 0-9 0-9 5xA(8,2)
 *  3   5  0-5 0-9 6xA(7,1)
 *  3   5   6  0-1 2xA(6,0)
 *  3   5   6   2  1
 */
public class Leetcode_weekly_12804 {
    public static void main(String[] args) {
        Leetcode_weekly_12804 lc = new Leetcode_weekly_12804();
        System.out.println(lc.numDupDigitsAtMostN(20));
    }
    public int numDupDigitsAtMostN(int N) {
        List<Integer> list = new ArrayList<>();
        int n = N + 1;
        int ans = 0;
        while (n != 0) {
            list.add(0, n % 10);
            n /= 10;
        }
        int len = list.size();
        for (int i = 0; i < len-1; ++i) {
            ans += 9 * A(9, i);
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < len; ++i) {
            for (int j = i > 0 ? 0 : 1; j < list.get(i); ++j) {
                if(!set.contains(j)) {
                    ans += A(9 - i, len - i - 1);
                }
            }
            if(set.contains(list.get(i))) break;
            set.add(list.get(i));
        }
        return N - ans;

    }

    private int A(int n, int k) {
        int ans = 1;
        for (; k > 0 ; k--, n--) {
            ans *= n;
        }
        return ans;
    }
}
