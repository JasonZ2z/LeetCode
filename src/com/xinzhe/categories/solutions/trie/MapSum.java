package com.xinzhe.categories.solutions.trie;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Xin
 * @date 2020/8/28
 * Title : 677. 键值映射
 * Description : 实现一个 MapSum 类里的两个方法，insert 和 sum。
 *          对于方法 insert，你将得到一对（字符串，整数）的键值对。字符串表示键，整数表示值。如果键已经存在，那么原来的键值对将被替代成新的键值对。
 *          对于方法 sum，你将得到一个表示前缀的字符串，你需要返回所有以该前缀开头的键的值的总和。
 * link : https://leetcode-cn.com/problems/map-sum-pairs
 * Level : Medium
 */

public class MapSum {
    Trie root;
    Map<String, Integer> map = new HashMap<>();
    /** Initialize your data structure here. */
    public MapSum() {
        root = new Trie();
    }

    public void insert(String key, int val) {
        int res = 0, old = 0;
        if(map.containsKey(key)) old = map.get(key);
        Trie cur = root;
        for(char c : key.toCharArray()) {
            int i = c - 'a';
            if(cur.node[i] == null) {
                cur.node[i] = new Trie();
            }
            cur.val += val - old;
            cur = cur.node[i];
        }
        cur.val += val - old;
        map.put(key, val);
    }

    public int sum(String prefix) {
        Trie cur = root;
        for(char c : prefix.toCharArray()) {
            int i = c - 'a';
            if(cur.node[i] == null) {
                return 0;
            }
            cur = cur.node[i];
        }
        return cur.val;
    }

    class Trie{
        Trie[] node;
        int val;
        public Trie(){
            node = new Trie[26];
            val = 0;
        }
    }
}
