package com.xinzhe.order.day07;

import com.xinzhe.categories.structure.design.medium.Trie;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @Author Xin
 * @create 2020/3/28 10:46
 * Title : 820. 单词的压缩编码
 * Description : 给定一个单词列表，我们将这个列表编码成一个索引字符串 S 与一个索引列表 A。
 *              例如，如果这个列表是 ["time", "me", "bell"]，我们就可以将其表示为 S = "time#bell#" 和 indexes = [0, 2, 5]。
 *              对于每一个索引，我们可以通过从字符串 S 中索引的位置开始读取字符串，直到 "#" 结束，来恢复我们之前的单词列表。
 *              那么成功对给定单词列表进行编码的最小字符串长度是多少呢？
 * link : https://leetcode-cn.com/problems/short-encoding-of-words
 * Level : Medium
 */
public class Leetcode820 {
    public int minimumLengthEncoding3(String[] words) {
        int res = 0;
        Trie tree = new Trie();
        Arrays.sort(words, (s1,s2) -> s2.length()-s1.length());
        for (String word : words) {
            res += tree.add(word);
        }
        return res;

    }
    public int minimumLengthEncoding(String[] words) {
        if(words.length == 0) return 0;
        Arrays.sort(words, (s1,s2) -> s2.length()-s1.length());
        StringBuilder sb = new StringBuilder(words[0] + "#");
        for (String word : words) {
            if(sb.lastIndexOf(word+"#") < 0){
                sb.append(word).append("#");
            }
        }
        return sb.length();
    }

    public int minimumLengthEncoding2(String[] words) {
        HashSet<String> set = new HashSet(Arrays.asList(words));
        for (String word: words) {
            for (int k = 1; k < word.length(); ++k)
                set.remove(word.substring(k));
        }

        int ans = 0;
        for (String word: set)
            ans += word.length() + 1;
        return ans;
    }

}
