package com.xinzhe.categories.solutions.bfs.medium;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * @Author Xin
 * @create 2020/3/31 17:34
 * Title : 127. 单词接龙
 * Description : 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
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

public class Leetcode127 {
    //BFS
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return 0;
        boolean[] visited = new boolean[wordList.size()];
        int index = wordList.indexOf(beginWord);
        if(index >= 0) visited[index] = true;
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int count = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            ++count;
            for (int i = 0; i < size; ++i) {
                String start = queue.poll();
                for (int j = 0; j < wordList.size(); j++) {
                    String s = wordList.get(j);
                    if(visited[j])continue;
                    if(!canConvert(start, s)) continue;
                    if(s.equals(endWord)) return ++count;
                    visited[j] = true;
                    queue.offer(s);
                }
            }
        }
        return 0;
    }

    public boolean canConvert(String start, String s) {
        int count = 0;
        for (int i = 0; i < s.length(); ++i) {
            if(start.charAt(i) != s.charAt(i)){
                ++count;
                if(count > 1) return false;
            }
        }
        return count == 1;
    }

    //双向BFS
    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        int end = wordList.indexOf(endWord);
        if(end == -1) return 0;
        wordList.add(beginWord);
        int start = wordList.size() - 1;
        Queue<Integer> queue1 = new LinkedList<>();
        Queue<Integer> queue2 = new LinkedList<>();

        Set<Integer> visited1 = new HashSet<>();
        Set<Integer> visited2 = new HashSet<>();

        queue1.offer(start);
        queue2.offer(end);
        visited1.add(start);
        visited2.add(end);
        int count1 =0, count2 = 0;
        while (!queue1.isEmpty() && !queue2.isEmpty()){
            ++count1;
            int size1 = queue1.size();
            for (int i = 0; i < size1; ++i) {
                String s = wordList.get(queue1.poll());
                for (int j = 0; j < wordList.size(); ++j) {
                    if (visited1.contains(j)) continue;
                    if(!canConvert(s, wordList.get(j))) continue;
                    if (visited2.contains(j)) return count1+count2+1;
                    visited1.add(j);
                    queue1.offer(j);
                }
            }
            ++count2;
            int size2 = queue2.size();
            for (int i = 0; i < size2; ++i) {
                String s = wordList.get(queue2.poll());
                for (int j = 0; j < wordList.size(); ++j) {
                    if(visited2.contains(j)) continue;
                    if(!canConvert(s, wordList.get(j))) continue;
                    if(visited1.contains(j)) return count1+count2+1;
                    visited2.add(j);
                    queue2.offer(j);
                }
            }
        }
        return 0;
    }

    //双向BFS优化写法
    public int ladderLength3(String beginWord, String endWord, List<String> wordList) {
        int index2 = wordList.indexOf(endWord);
        if(index2 == -1) return 0;

        int n = wordList.size();
        Queue<String> queue1 = new LinkedList<>();
        Queue<String> queue2 = new LinkedList<>();

        boolean[] visited1 = new boolean[n];
        boolean[] visited2 = new boolean[n];

        queue1.offer(beginWord);
        queue2.offer(endWord);

        int index1 = wordList.indexOf(beginWord);
        if(index1 != -1) visited1[index1] = true;
        visited2[index2] = true;
        int count = 0;

        while (!queue1.isEmpty() && !queue2.isEmpty()){
            //交换队列，每次都处理长度小的队列
            if(queue1.size() > queue2.size()){
                Queue<String> tmp_que = new LinkedList<>(queue1);
                queue1 = queue2;
                queue2 = tmp_que;

                boolean[] tmp_visited = visited1;
                visited1 = visited2;
                visited2 = tmp_visited;
            }
            int size = queue1.size();
            ++count;
            for (int i = 0; i < size; i++) {
                String s = queue1.poll();
                for (int j = 0; j < wordList.size(); ++j) {
                    if(visited1[j]) continue;
                    if(!canConvert(s, wordList.get(j))) continue;
                    if(visited2[j]) return ++count;
                    visited1[j] = true;
                    queue1.offer(wordList.get(j));
                }
            }
        }
        return 0;
    }
}
