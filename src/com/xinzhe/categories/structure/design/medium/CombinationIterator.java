package com.xinzhe.categories.structure.design.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Xin
 * @date 2020/8/14
 * Title : 1286. 字母组合迭代器
 * Description : 请你设计一个迭代器类，包括以下内容：
 *              一个构造函数，输入参数包括：一个 有序且字符唯一 的字符串 characters（该字符串只包含小写英文字母）和一个数字 combinationLength 。
 *              函数 next() ，按 字典序 返回长度为 combinationLength 的下一个字母组合。
 *              函数 hasNext() ，只有存在长度为 combinationLength 的下一个字母组合时，才返回 True；否则，返回 False。
 * link : https://leetcode-cn.com/problems/iterator-for-combination
 * Level : Medium
 */

class CombinationIterator {
    List<String> dict = new ArrayList<>();
    int index = 0;
    int len;
    public CombinationIterator(String characters, int m) {
        dfs(characters, 0, m, "");
        dict.sort(String::compareTo);
        this.len =  dict.size();
    }

    private void dfs(String s, int index, int m, String trace) {
        if(trace.length() == m) {
            dict.add(trace);
            return;
        }
        for (int i = index; i < s.length(); ++i) {
            trace += s.charAt(i);
            dfs(s, i+1, m, trace);
            trace = trace.substring(0,trace.length()-1);
        }
    }

    public String next() {
        return dict.get(index++);

    }

    public boolean hasNext() {
        return index < len;
    }
}
