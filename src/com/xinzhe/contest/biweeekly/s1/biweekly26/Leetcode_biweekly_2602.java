package com.xinzhe.contest.biweeekly.s1.biweekly26;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Xin
 * @date 2020/5/16
 * Title : 1447. 最简分数
 * Description : 给你一个整数 n ，请你返回所有 0 到 1 之间（不包括 0 和 1）满足分母小于等于  n 的 最简 分数 。分数可以以 任意 顺序返回。
 * link : https://leetcode-cn.com/problems/simplified-fractions/
 * Level : Medium
 */
public class Leetcode_biweekly_2602 {
    public int GCD(int m, int n) {
        int result;
        while (n != 0) {
            result = m % n;
            m = n;
            n = result;
        }
        return m;
    }

    public List<String> simplifiedFractions(int n) {
        List<String> res = new ArrayList<>();
        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j < i; ++j) {
                if (GCD(i, j) == 1) {
                    res.add(i + "/" + j);
                }
            }
        }
        return res;
    }
}
