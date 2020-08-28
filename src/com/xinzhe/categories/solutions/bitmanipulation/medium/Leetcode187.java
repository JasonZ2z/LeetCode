package com.xinzhe.categories.solutions.bitmanipulation.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Xin
 * @date 2020-08-17 15:46:45
 * Title : 187. Repeated DNA Sequences
 * tag: 位运算 哈希表
 */
//所有 DNA 都由一系列缩写为 A，C，G 和 T 的核苷酸组成，例如：“ACGAATTCCG”。在研究 DNA 时，识别 DNA 中的重复序列有时会对研究非常有帮助。
// 编写一个函数来查找目标子串，目标子串的长度为 10，且在 DNA 字符串 s 中出现次数超过一次。
// 示例：
// 输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
//输出：["AAAAACCCCC", "CCCCCAAAAA"]

class Leetcode187 {
    public static void main(String[] args) {
        Leetcode187 lc = new Leetcode187();
        System.out.println(lc.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
    }

    class Solution {
        public List<String> findRepeatedDnaSequences(String s) {
            Set<String> set = new HashSet<>();
            Set<String> res = new HashSet<>();
            int n = s.length();

            for(int i=0; i<=n-10; i++){
                String tmp = s.substring(i, i+10);
                if(set.contains(tmp)) {
                    res.add(tmp);
                }else{
                    set.add(tmp);
                }
            }
            return new ArrayList<>(res);
        }
    }


    List<Character> dict = Arrays.asList('A', 'C', 'G', 'T');
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        int n = s.length(); if(n <= 10) return res;
        char[] arr = s.toCharArray();
        Map<Integer, Integer> map = new HashMap<>();
        int mask = 0;
        for(int i=0; i<n; i++) {
            int j = dict.indexOf(arr[i]);
            if(i < 9) {
                mask += j;
            } else {
                mask &= 0xfcfffff;
                mask += j;
                map.put(mask, map.getOrDefault(mask, 0) + 1);
            }
            System.out.println(Integer.toBinaryString(mask));
            mask <<=2;
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() > 1) {
                res.add(convert(entry.getKey()));
            }
        }
        return res;
    }

    private String convert(int x) {
        StringBuilder sb = new StringBuilder();
        while(x > 0) {
            sb.append(dict.get(x & 3));
            x >>= 2;
        }
        while (sb.length() < 10) {
            sb.append('A');
        }
        return sb.reverse().toString();
    }
}
