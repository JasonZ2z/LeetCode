package com.xinzhe.contest.biweeekly.biweeekly26;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Xin
 * @create 2020/5/16
 * Title :
 * Description :
 * link :
 * Level :
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
