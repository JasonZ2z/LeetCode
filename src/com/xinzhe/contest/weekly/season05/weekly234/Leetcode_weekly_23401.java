package com.xinzhe.contest.weekly.season05.weekly234;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Xin
 * @date 2021/03/28
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_weekly_23401 {
    public static void main(String[] args) {
        Leetcode_weekly_23401 lc = new Leetcode_weekly_23401();
        System.out.println(lc.numDifferentIntegers("167278959591294"));

    }
    public int numDifferentIntegers(String word) {
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(Character.isLetter(chars[i])) {
                chars[i] = ' ';
            }
        }
        String tmp = new String(chars);
        String[] s = tmp.split(" ");
        Set<BigInteger> set = new HashSet<>();

        for (String s1 : s) {
            if("".equals(s1)) continue;
            set.add(new BigInteger(s1));
        }
        return set.size();
    }
}
