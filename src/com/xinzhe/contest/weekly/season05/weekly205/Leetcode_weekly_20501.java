package com.xinzhe.contest.weekly.season05.weekly205;

import java.util.Arrays;

/**
 * @author Xin
 * @date 2020/9/6
 * Title : 1576. 替换所有的问号
 * Description : 给你一个仅包含小写英文字母和 '?' 字符的字符串 s<var> </var>，请你将所有的 '?' 转换为若干小写字母，使最终的字符串不包含任何 连续重复 的字符。
 *          注意：你 不能 修改非 '?' 字符。题目测试用例保证 除 '?' 字符 之外，不存在连续重复的字符。
 *          在完成所有转换（可能无需转换）后返回最终的字符串。如果有多个解决方案，请返回其中任何一个。可以证明，在给定的约束条件下，答案总是存在的。
 * link : https://leetcode-cn.com/problems/replace-all-s-to-avoid-consecutive-repeating-characters
 * Level : Easy
 */
public class Leetcode_weekly_20501 {
    public static void main(String[] args) {
        Leetcode_weekly_20501 lc = new Leetcode_weekly_20501();
        int[] arr = {1,2,3,1,2};
        System.out.println(Arrays.toString("a?a".split("\\?")));
    }


    public String modifyString(String s) {
        StringBuilder sb = new StringBuilder();
        s = " " + s + " ";
        char pre = ' ';
        for (int i = 1; i < s.length()-1; ++i) {
            if(s.charAt(i) == '?') {
                int j = 0;
                for (; j < 26; ++j) {
                    if((char)(j + 'a') != pre && (char)(j + 'a') != s.charAt(i+1)) {
                        sb.append((char)(j + 'a'));
                        pre = (char)(j + 'a');
                        break;
                    }
                }
            } else {
                pre = s.charAt(i);
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();

    }
}
