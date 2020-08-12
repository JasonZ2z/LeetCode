package com.xinzhe.categories.solutions.trie;

/**
 * @Author Xin
 * @create 2020/3/28 20:41
 * Title : 211. 添加与搜索单词 - 数据结构设计
 * Description : 设计一个支持以下两种操作的数据结构：
 *
 * void addWord(word)
 * bool search(word)
 * link : https://leetcode-cn.com/problems/add-and-search-word-data-structure-design/description/
 * Level : Medium
 */
class WordDictionary {
    public static void main(String[] args) {
        WordDictionary wd = new WordDictionary();
        wd.addWord("bad");
        wd.addWord("dad");
        wd.addWord("mad");
        System.out.println(wd.search("pad"));
        System.out.println(wd.search("bad"));
        System.out.println(wd.search(".ad"));
        System.out.println(wd.search("b.."));
    }

    /** Initialize your data structure here. */
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode cur = root;
        for(int i=0; i< word.length(); i++) {
            int j = word.charAt(i) - 'a';
            if(cur.node[j] == null) {
                cur.node[j] = new TrieNode();
            }
            cur = cur.node[j];
        }
        cur.isEnd = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return dfs(root, word, 0);
    }

    public boolean dfs(TrieNode root, String word, int index) {
        if(index == word.length()) {
            return root.isEnd;
        }
        if(word.charAt(index) == '.') {
            for(int i=0; i< 26; i++) {
                if(dfs(root.node[i], word, index + 1)){
                    return true;
                }
            }
            return false;
        } else {
            int j = word.charAt(index) - 'a';
            return dfs(root.node[j], word, index+1);
        }
    }

    static class TrieNode {
        boolean isEnd;
        TrieNode[] node;
        public TrieNode(){
            node = new TrieNode[26];
        }
    }
}