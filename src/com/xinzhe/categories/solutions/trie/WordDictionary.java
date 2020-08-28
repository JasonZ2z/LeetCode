package com.xinzhe.categories.solutions.trie;

/**
 * @author Xin
 * @date 2020/3/28 20:41
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

    Trie root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new Trie();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        Trie cur = root;
        for(char c : word.toCharArray()) {
            int i = c - 'a';
            if(cur.node[i] ==null) cur.node[i] = new Trie();
            cur = cur.node[i];
        }
        cur.end = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return dfs(root, word, 0);
    }

    public boolean dfs(Trie cur, String word, int index) {
        if(index == word.length()) return cur.end;
        if(cur == null) return false;
        if(word.charAt(index) == '.') {
            for(int i=0; i<26; i++) {
                if(dfs(cur.node[i], word, index + 1)){
                    return true;
                }
            }
        } else {
            int i = word.charAt(index) - 'a';
            return dfs(cur.node[i], word, index + 1);
        }
        return false;
    }

    class Trie{
        Trie[] node;
        boolean end;

        public Trie(){
            node = new Trie[26];
        }
    }
}