package com.xinzhe.contest.weekly.season04.weekly185;

import java.util.HashMap;

/**
 * @author Xin
 * @date 2020/4/19 10:24
 * Title : 5390. 数青蛙
 * Description : 给你一个字符串 croakOfFrogs，它表示不同青蛙发出的蛙鸣声（字符串 "croak" ）的组合。由于同一时间可以有多只青蛙呱呱作响，所以 croakOfFrogs 中会混合多个 “croak” 。
 *              请你返回模拟字符串中所有蛙鸣所需不同青蛙的最少数目。
 *              注意：要想发出蛙鸣 "croak"，青蛙必须 依序 输出 ‘c’, ’r’, ’o’, ’a’, ’k’ 这 5 个字母。如果没有输出全部五个字母，那么它就不会发出声音。
 *              如果字符串 croakOfFrogs 不是由若干有效的 "croak" 字符混合而成，请返回 -1 。
 * link : https://leetcode-cn.com/problems/minimum-number-of-frogs-croaking
 * Level : Medium
 * Comment : 185周赛03
 */

//todo need to review
public class Leetcode_weekly_18503 {
    public static void main(String[] args) {
        System.out.println(minNumberOfFrogs("crocracokrakoak"));
    }
    public static int minNumberOfFrogs(String s) {
        int n = s.length();
        if (n % 5 != 0) return -1;
        if (!s.startsWith("c")) return -1;
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < n; ++i) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        if (map.size() != 5) return -1;
        int max = map.get('c');
        for (Integer value : map.values()) {
            if (value != max) {
                return -1;
            }
        }
        int c = 0,k = 0,r = 0,a = 0,o = 0;
        int res = 0;
        char[] croakOfFrogs = s.toCharArray();
        for (char croakOfFrog : croakOfFrogs) {
            if (croakOfFrog == 'c') c++;
            else if (croakOfFrog == 'r') r++;
            else if (croakOfFrog == 'o') o++;
            else if (croakOfFrog == 'a') a++;
            else if (croakOfFrog == 'k') k++;
            res = Math.max(c - k, res);
            if (c < r || r < o || o < a || a < k) {
                return -1;
            }
        }
        if(c == a && o == k) {
            return res;
        } else {
            return -1;
        }
    }
}
