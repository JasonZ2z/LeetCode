package com.xinzhe.categories.solutions.trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Xin
 * @date 2020/8/6
 * Title : 336. 回文对
 * Description : 给定一组唯一的单词， 找出所有不同 的索引对(i, j)，使得列表中的两个单词， words[i] + words[j] ，可拼接成回文串。
 * link : https://leetcode-cn.com/problems/palindrome-pairs/
 * Level : Hard
 */
//todo too hard to resolve
public class Leetcode336 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> palindromePairs(String[] words) {
        TrieNode root = new TrieNode();
        for (int i = 0; i < words.length; i++) add(root, words[i], i);
        for (int i = 0; i < words.length; i++) search(root, words[i], i);
        return res;
    }

    private void search(TrieNode root, String word, int i) {
        for (int j = 0; j < word.length(); ++j) {
            if(root.index >= 0 && root.index != i && ok(word, j, word.length()-1)){
                res.add(Arrays.asList(i, root.index));
            }
            root = root.node[word.charAt(j) - 'a'];
            if(root == null) return;
        }
        for (int j : root.list) {
            if(i == j) continue;
            res.add(Arrays.asList(i,j));
        }
    }

    private void add(TrieNode root, String word, int index) {
        char[] arr = word.toCharArray();
        for (int i = arr.length - 1; i >= 0; i--) {
            int j = arr[i] - 'a';
            if(root.node[j] == null) root.node[j] = new TrieNode();
            if(ok(word, 0, i)) root.list.add(index);
            root = root.node[j];
        }
        root.list.add(index);
        root.index = index;
    }

    public boolean ok(String s, int p, int q) {
        while(p < q) {
            if(s.charAt(p++) != s.charAt(q--)) {
                return false;
            }
        }
        return true;
    }

    class TrieNode{
        TrieNode[] node;
        int index;
        List<Integer> list;

        public TrieNode(){
            node = new TrieNode[26];
            index = -1;
            list = new ArrayList<>();
        }
    }
}
