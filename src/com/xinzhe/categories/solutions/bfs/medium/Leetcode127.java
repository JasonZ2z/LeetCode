package com.xinzhe.categories.solutions.bfs.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Xin
 * @date 2020/3/31 17:34
 * Title : 127. 单词接龙
 * Description : 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
 *              每次转换只能改变一个字母。转换过程中的中间单词必须是字典中的单词。
 *      说明:
 *          如果不存在这样的转换序列，返回 0。
 *          所有单词具有相同的长度。
 *          所有单词只由小写字母组成。
 *          字典中不存在重复的单词。
 *          你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * link : https://leetcode-cn.com/problems/word-ladder
 * Level : Medium
 */
//todo need to review
//构造虚拟节点避免访问全部链表
public class Leetcode127 {
    public static void main(String[] args) {
        Leetcode127 lc = new Leetcode127();
        List<String> list = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        System.out.println(lc.ladderLength("hit", "cog", list));
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int n = wordList.size();
        HashSet<String> set = new HashSet<>(wordList);
        if(n == 0 || !set.contains(endWord)) return 0;
        set.remove(beginWord);
        HashSet<String> used = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            steps++;
            for (int i = 0; i < size; i++) {
                char[] arr = queue.poll().toCharArray();
                for (int j = 0; j < arr.length; j++) {
                    char orig = arr[j];
                    for (char k = 'a'; k <= 'z'; k++) {
                        if (k == orig) continue;
                        arr[j] = k;
                        String tmp = new String(arr);
                        if (!set.contains(tmp) || used.contains(tmp)) continue;
                        if (tmp.equals(endWord)) return steps + 1;
                        queue.offer(tmp);
                        used.add(tmp);
                    }
                    arr[j] = orig;
                }
            }
        }
        return 0;
    }

    //双向BFS
    HashSet<String> set;
    HashSet<String> used = new HashSet<>();
    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        int n = wordList.size();
        this.set = new HashSet<>(wordList);
        if(n == 0 || !set.contains(endWord)) return 0;
        HashSet<String> beginUsed = new HashSet<>();
        HashSet<String> endUsed = new HashSet<>();
        beginUsed.add(beginWord);
        endUsed.add(endWord);
        return bfs(beginUsed, endUsed, 2);
    }

    private int bfs(HashSet<String> begin, HashSet<String> end, int steps) {
        if(begin.size() == 0) return 0;
        if(begin.size() > end.size()) return bfs(end, begin, steps);
        HashSet<String> next = new HashSet<>();
        for (String s : begin) {
            char[] arr = s.toCharArray();
            for (int j = 0; j < arr.length; j++) {
                char orig = arr[j];
                for (char k = 'a'; k <= 'z'; k++) {
                    if (k == orig) continue;
                    arr[j] = k;
                    String tmp = new String(arr);
                    if(set.contains(tmp)) {
                        if(end.contains(tmp)) return steps;
                        if(!used.contains(tmp)) {
                            next.add(tmp);
                            used.add(tmp);
                        }
                    }
                }
                arr[j] = orig;
            }
        }
        return bfs(next, end, steps + 1);
    }
}
