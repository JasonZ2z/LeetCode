package com.xinzhe.categories.solutions.trie;

import java.util.Arrays;
import java.util.List;

/**
 * @author Xin
 * @date 2020/8/28
 * Title : 648. 单词替换
 * Description : 在英语中，我们有一个叫做 词根(root)的概念，它可以跟着其他一些词组成另一个较长的单词——我们称这个词为 继承词(successor)。
 *              例如，词根an，跟随着单词 other(其他)，可以形成新的单词 another(另一个)。现在，给定一个由许多词根组成的词典和一个句子。
 *              你需要将句子中的所有继承词用词根替换掉。如果继承词有许多可以形成它的词根，则用最短的词根替换它。你需要输出替换之后的句子。
 * link : https://leetcode-cn.com/problems/replace-words
 * Level : Medium
 */

public class Leetcode648 {
    public static void main(String[] args) {
        List<String> dict = Arrays.asList("cat", "bat", "rat");
        String s = "the cattle was rattled by the battery";
        Leetcode648 lc = new Leetcode648();
        System.out.println(lc.replaceWords(dict, s));
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        String[] arr = sentence.split(" ");
        Trie root = new Trie();
        for (String dict : dictionary) {
            Trie cur = root;
            for (char c : dict.toCharArray()) {
                int i = c - 'a';
                if(cur.node[i] == null) cur.node[i] = new Trie();
                cur = cur.node[i];
            }
            cur.end = true;
        }
        StringBuilder sb = new StringBuilder();
        for (String s : arr) {
            Trie cur = root;
            StringBuilder tmp = new StringBuilder();
            for (char c : s.toCharArray()) {
                int i = c - 'a';
                if(cur.node[i] == null) {
                    sb.append(s).append(" ");
                    break;
                }
                tmp.append(c);
                if(cur.node[i].end) {
                    sb.append(tmp).append(" ");
                    break;
                }
                cur = cur.node[i];
            }
        }
        return sb.toString().trim();
    }

    class Trie{
        Trie[] node;
        boolean end;

        public Trie() {
            node = new Trie[26];
            end = false;
        }
    }
}
