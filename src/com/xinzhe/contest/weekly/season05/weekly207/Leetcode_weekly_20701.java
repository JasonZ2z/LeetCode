package com.xinzhe.contest.weekly.season05.weekly207;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Xin
 * @date 2020/9/20
 * Title : 1592. 重新排列单词间的空格
 * Description : 给你一个字符串 text ，该字符串由若干被空格包围的单词组成。每个单词由一个或者多个小写英文字母组成，并且两个单词之间至少存在一个空格。题目测试用例保证 text 至少包含一个单词 。
 *              请你重新排列空格，使每对相邻单词之间的空格数目都 相等 ，并尽可能 最大化 该数目。如果不能重新平均分配所有空格，请 将多余的空格放置在字符串末尾 ，这也意味着返回的字符串应当与原 text 字符串的长度相等。
 *              返回 重新排列空格后的字符串 。
 * link : https://leetcode-cn.com/problems/rearrange-spaces-between-words
 * Level : Easy
 */
public class Leetcode_weekly_20701 {
    public static void main(String[] args) {
        Leetcode_weekly_20701 lc = new Leetcode_weekly_20701();
        String s = "  hello";
        System.out.println(lc.reorderSpaces(s));
    }

    public String reorderSpaces(String text) {
        int n = text.length();
        int count = 0;
        int j = 0;
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if(text.charAt(i) == ' ') {
                if(i > 0 && text.charAt(i-1) != ' ') {
                    list.add(text.substring(j, i));
                }
                count++;
            } else {
                if(i > 0 && text.charAt(i-1) == ' ') {
                    j = i;
                }
            }
            if(i == n-1 && text.charAt(i) != ' ') {
                list.add(text.substring(j, n));
            }
        }

        if(count == 0) return text;
        if(list.size() == 1){
            return list.get(0) + " ".repeat(count);
        }
        int x = count / (list.size() - 1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            if(i < list.size() - 1) {
                sb.append(" ".repeat(Math.max(0, x)));
            }
        }
        sb.append(" ".repeat(Math.max(0, n - sb.length())));
        return sb.toString();
    }
}
