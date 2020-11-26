package com.xinzhe.categories.solutions.trie;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Xin
 * @date 2020/11/26
 * Title : 1268. 搜索推荐系统
 * Description : 给你一个产品数组products和一个字符串searchWord，products 数组中每个产品都是一个字符串。
 *               请你设计一个推荐系统，在依次输入单词searchWord 的每一个字母后，推荐products 数组中前缀与searchWord 相同的最多三个产品。如果前缀相同的可推荐产品超过三个，请按字典序返回最小的三个。
 *              请你以二维列表的形式，返回在输入searchWord每个字母后相应的推荐产品的列表。
 * link : https://leetcode-cn.com/problems/search-suggestions-system
 * Level : Medium
 */
//todo need to review
public class Leetcode1268 {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        TrieNode root = new TrieNode();
        for (String product : products) {
            TrieNode cur = root;
            for (char c : product.toCharArray()) {
                int i = c - 'a';
                if(cur.node[i] == null){
                    cur.node[i] = new TrieNode();
                }
                cur = cur.node[i];
            }
            cur.str = product;
            cur.count++;
        }
        List<List<String>> res = new ArrayList<>();
        for (char c : searchWord.toCharArray()) {
            root = root == null ? null : root.node[c - 'a'];
            res.add(search(root, c));
        }
        return res;
    }

    private List<String> search(TrieNode cur, char c) {
        List<String> list = new ArrayList<>();
        if(cur == null ) {
            return list;
        }
        dfs(cur, list);
        return list;
    }

    private boolean dfs(TrieNode cur, List<String> list) {
        if(cur.count > 0) {
            for (int i = 0; i < cur.count; i++) {
                list.add(cur.str);
                if(list.size() == 3) return true;
            }
        }
        for (TrieNode trieNode : cur.node) {
            if(trieNode != null) {
                if(dfs(trieNode, list)) return true;
            }
        }
        return false;
    }


    class TrieNode {
        int count;
        String str;
        TrieNode[] node;
        public TrieNode() {
            count = 0;
            str = "";
            node = new TrieNode[26];
        }
    }
}
