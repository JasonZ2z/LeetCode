package com.xinzhe.sword.chapter17;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Xin
 * @date 2020/12/03
 * Title : 17.15. 最长单词
 * Description : 给定一组单词words，编写一个程序，找出其中的最长单词，且该单词由这组单词中的其他单词组合而成。
 *              若有多个长度相同的结果，返回其中字典序最小的一项，若没有符合要求的单词则返回空字符串。
 * link : https://leetcode-cn.com/problems/longest-word-lcci
 * Level : Medium
 */

public class Interview_1715 {
    public static void main(String[] args) {
        String[] arr = {"looked","just","like","her","brother"};
        Interview_1715 lc = new Interview_1715();
    }
    public String longestWord(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() == b.length() ? a.compareTo(b) : b.length() - a.length());
        Set<String> set = new HashSet<>(Arrays.asList(words));
        for (String s : words) {
            set.remove(s);
            if(find(set, s)) return s;
        }
        return "";
    }
    public boolean find(Set<String> set, String word){
        if(word.length() == 0)
            return true;
        for(int i = 0; i < word.length(); i++){
            if(set.contains(word.substring(0,i+1)) && find(set,word.substring(i+1)))
                return true;
        }
        return false;
    }
}
