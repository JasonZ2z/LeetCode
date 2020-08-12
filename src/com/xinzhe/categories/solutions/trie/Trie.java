package com.xinzhe.categories.solutions.trie;

/**
 * @author Xin
 * @date 2020/3/28 20:41
 * Title : 208. 实现 Trie (前缀树)
 * Description : 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 *      示例
 *      Trie trie = new Trie();
 *      trie.insert("apple");
 *      trie.search("apple");   // 返回 true
 *      trie.search("app");     // 返回 false
 *      trie.startsWith("app"); // 返回 true
 *      trie.insert("app");
 *      trie.search("app");     // 返回 true
 * link : https://leetcode-cn.com/problems/implement-trie-prefix-tree
 * Level : Medium
 */
public class Trie {
    class TrieNode{
        public boolean isEnd;
        public TrieNode[] node;
        public TrieNode(){
            isEnd = false;
            node = new TrieNode[26];
        }
    }

    private TrieNode root;
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if(cur.node[index] == null){
                cur.node[index] = new TrieNode();
            }
            cur = cur.node[index];
        }
        cur.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if(cur.node[index] == null){
                return false;
            }
            cur = cur.node[index];
        }
        return cur.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if(cur.node[index] != null){
                cur = cur.node[index];
            }else {
                return false;
            }
        }
        return true;
    }

    public int add(String word) {
        TrieNode cur = root;
        boolean isNew = false;
        for(int i = word.length() -1; i >= 0; i--) {
            int index = word.charAt(i) - 'a';
            if(cur.node[index] == null){
                isNew = true;
                cur.node[index] = new TrieNode();
            }
            cur = cur.node[index];
        }
        return  isNew ? word.length() + 1 : 0;
    }

}
