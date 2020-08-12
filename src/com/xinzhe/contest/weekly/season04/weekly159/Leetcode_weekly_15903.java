package com.xinzhe.contest.weekly.season04.weekly159;

import java.util.Arrays;
import java.util.List;

/**
 * @author Xin
 * @date 2020/6/23
 * Title : 1234. 替换子串得到平衡字符串
 * Description : 有一个只含有 'Q', 'W', 'E', 'R' 四种字符，且长度为 n 的字符串。假如在该字符串中，这四个字符都恰好出现 n/4 次，那么它就是一个「平衡字符串」。给你一个这样的字符串 s，请通过「替换一个子串」的方式，使原字符串 s 变成一个「平衡字符串」。
                你可以用和「待替换子串」长度相同的 任何 其他字符串来完成替换。 请返回待替换子串的最小可能长度。如果原字符串自身就是一个平衡字符串，则返回 0。
 * link : https://leetcode-cn.com/problems/replace-the-substring-for-balanced-string
 * Level : Medium
 * Comment 159周赛03
 */

public class Leetcode_weekly_15903 {

    public static void main(String[] args) {
        Leetcode_weekly_15903 lc = new Leetcode_weekly_15903();
        String s = "WWEQERQWQWWRWWERQWEQ";
       // String s = "QQWE";
        System.out.println(lc.balancedString(s));
    }
    public int balancedString(String s) {
        int n = s.length();
        int aver = n / 4;
        int[] count = new int[4];
        List<Character> dist = Arrays.asList('Q', 'W', 'E', 'R');
        char[] arr = s.toCharArray();
        for (char c : arr) {
            count[dist.indexOf(c)]++;
        }
        if(helper(count, aver)) return 0;
        int left = 0, right = 0;
        int res = n;
        while (right < n) {
            count[dist.indexOf(arr[right])]--;
            while (left <= right && helper(count, aver)) {
                res = Math.min(res, right - left + 1);
                count[dist.indexOf(arr[left++])]++;
            }
            right++;
        }
        return res;
    }

    private boolean helper(int[] count, int aver) {
        for (int value : count) {
            if (value > aver) {
                return false;
            }
        }
        return true;
    }
}
