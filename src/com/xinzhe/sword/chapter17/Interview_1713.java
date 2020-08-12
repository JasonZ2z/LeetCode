package com.xinzhe.sword.chapter17;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @Author Xin
 * @create 2020/6/22
 * Title : 17.13. 恢复空格
 * Description : 长篇文章中的空格、标点都删掉了，并且大写也弄成了小写。在处理标点符号和大小写之前，你得先把它断成词语。
 *              当然了，你有一本厚厚的词典dictionary，不过，有些词没在词典里。假设文章用sentence表示，设计一个算法，把文章断开，要求未识别的字符最少，返回未识别的字符数。
 * link : https://leetcode-cn.com/problems/re-space-lcci
 * Level : Medium
 * Tag : @trie, @dp
 */

public class Interview_1713 {
    public static void main(String[] args) {
        String[] arr = {"looked","just","like","her","brother"};
        Interview_1713 lc = new Interview_1713();
        System.out.println(lc.respace(arr, "jesslookedjustliketimherbrother"));
        System.out.println(lc.respace2(arr, "jesslookedjustliketimherbrother"));
    }
    public int respace(String[] dictionary, String sentence) {
        Set<String> set = Arrays.stream(dictionary).collect(Collectors.toSet());
        sentence = " " + sentence;
        int len = sentence.length();
        int[] dp = new int[len];
        dp[0] = 0;
        for (int i = 1; i < len; ++i) {
            dp[i] = dp[i-1] + 1;
            for(int j = i ; j > 0; --j) {
                if(set.contains(sentence.substring(j,i+1))) {
                    dp[i] = Math.min(dp[i], dp[j-1]);
                }
            }
        }
        return dp[len-1];
    }

    TrieNode root;
    public int respace2(String[] dictionary, String sentence) {
        root = new TrieNode();
        for (String s : dictionary) {
            buildTree(s);
        }
        int n = sentence.length();
        int[] dp = new int[n+1];
        for(int i = n-1; i >= 0; --i) {
            dp[i] = n-i;
            TrieNode node = root;
            for (int j = i; j < n; ++j) {
                int c = sentence.charAt(j) - 'a';
                if(node.child[c] == null) {
                    dp[i] = Math.min(dp[i], j-i+1 + dp[j+1]);
                    break;
                }
                node = node.child[c];
                dp[i] = Math.min(dp[i], node.isEnd ? dp[j+1] : j-i+1 + dp[j+1]);

            }
        }
        return dp[0];
    }

    private void buildTree(String s) {
        TrieNode node = root;
        for (int i = 0; i < s.length(); ++i) {
            int j = s.charAt(i) - 'a';
            if(node.child[j] == null) {
                node.child[j] = new TrieNode();
            }
            node = node.child[j];
        }
        node.isEnd = true;
    }

    class TrieNode {
        TrieNode[] child;
        boolean isEnd;

        public TrieNode() {
            child = new TrieNode[26];
            isEnd = false;
        }
    }

}
