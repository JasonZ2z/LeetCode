package com.xinzhe.contest.biweeekly.biweekly27;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Xin
 * @date 2020/5/30
 * Title :
 * Description :
 * link :
 * Level : Medium
 */
public class Leetcode_biweekly_2702 {
    public static void main(String[] args) {
        String s = "00110";
        int k = 2;
        System.out.println(hasAllCodes(s, 2));
    }

    public static boolean hasAllCodes(String s, int k) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i <= s.length() - k; ++i) {
            set.add(s.substring(i, i + k));
        }
        return set.size() == Math.pow(2, k);
    }

}
