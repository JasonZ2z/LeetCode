package com.xinzhe.contest.weekly.weekly172;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Xin
 * @create 2020/5/23
 * Title : 1323. 6 和 9 组成的最大数字
 * Description : 给你一个仅由数字 6 和 9 组成的正整数 num。你最多只能翻转一位数字，将 6 变成 9，或者把 9 变成 6 。请返回你可以得到的最大数字
 * link :  https://leetcode-cn.com/problems/maximum-69-number/
 * Level : Easy
 * Comment 172周赛01
 */

public class Leetcode_weekly_17201 {
    public int maximum69Number(int num) {
        List<Integer> list = new ArrayList<>();
        while (num > 0) {
            int res = num % 10;
            num /= 10;
            list.add(res);
        }
        StringBuilder sb = new StringBuilder();
        boolean count = true;
        for (int i = list.size() - 1; i >= 0; i--) {
            if (count && list.get(i) == 6) {
                count = false;
                sb.append(9);
            } else {
                sb.append(list.get(i));
            }

        }
        return Integer.parseInt(sb.toString());
    }

}
