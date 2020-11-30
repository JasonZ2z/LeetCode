package com.xinzhe.categories.solutions.greedy.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author Xin
 * @date 2020/11/30
 * Title : 767. 重构字符串
 * Description : 给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。若可行，输出任意可行的结果。若不可行，返回空字符串。
 * link : https://leetcode-cn.com/problems/reorganize-string/
 * Level : Medium
 */

//todo
    // tips 出现次数最多的字符不能超过1半
    //
public class Leetcode767 {
    public static void main(String[] args) {
        Leetcode767 lc = new Leetcode767();
        System.out.println(lc.reorganizeString("bfrbs"));
    }
    public String reorganizeString(String S) {
        int n = S.length();
        int max = 0;
        Map<Character, Integer> map = new HashMap<>(26);
        for (char c : S.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
            max = Math.max(max, map.get(c));
        }
        if(max > (n + 1) / 2) return "";
        char[] res = new char[n];
        PriorityQueue<Map.Entry<Character, Integer>> queue = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            queue.offer(entry);
        }
        char pre = ' ';
        for (int i = 0; i < n; i++) {
            Map.Entry<Character, Integer> poll = queue.poll();
            int val = poll.getValue();
            char key = poll.getKey();
            if(key != pre) {
                res[i] = key;
                pre = key;
                if(val > 1) {
                    poll.setValue(val - 1);
                    queue.offer(poll);
                }

            } else {
                Map.Entry<Character, Integer> next = queue.poll();
                res[i] = next.getKey();
                pre =  next.getKey();
                if(next.getValue() > 1) {
                    next.setValue(next.getValue() - 1);
                    queue.offer(next);
                }
                queue.offer(poll);
            }
        }
        return new String(res);
    }
}
