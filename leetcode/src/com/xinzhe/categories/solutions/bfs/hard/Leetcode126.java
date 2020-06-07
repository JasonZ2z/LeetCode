package com.xinzhe.categories.solutions.bfs.hard;

import java.util.*;

/**
 * @Author Xin
 * @create 2020/3/31 17:34
 * Title : 126. 单词接龙 II
 * Description : 给定两个单词（beginWord 和 endWord）和一个字典，找出所有从 beginWord 到 endWord 的最短转换序列。转换需遵循如下规则：
 *              每次转换只能改变一个字母。转换过程中的中间单词必须是字典中的单词。
 *      说明:
 *          如果不存在这样的转换序列，返回 0。
 *          所有单词具有相同的长度。
 *          所有单词只由小写字母组成。
 *          字典中不存在重复的单词。
 *          你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * link : https://leetcode-cn.com/problems/word-ladder-ii/
 * Level : Hard
 */
//todo undo
public class Leetcode126 {
    public static void main(String[] args) {
        String a ="hit";
        String b = "cog";
        List<String> list = Arrays.asList("hot","dot","dog","lot","log","cog");
        System.out.println(findLadders(a,b,list));

    }
    //超时
    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        int index = wordList.indexOf(endWord);
        if(index == -1) return res;
        int n = wordList.size();

        Queue<List<String>> queue = new LinkedList<>();
        Queue<boolean[]> visited = new LinkedList<>();
        boolean[] visit = new boolean[n];

        int index1 = wordList.indexOf(beginWord);
        if(index1 != -1) visit[index1] = true;

        queue.offer(new ArrayList<>(Arrays.asList(beginWord)));
        visited.offer(visit);
        boolean flag = false;
        while (!queue.isEmpty() && !flag){
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                List<String> path = queue.poll();
                boolean[] sub_visit = visited.poll();
                String s = path.get(path.size() - 1);

                for (int j = 0; j < wordList.size(); ++j) {
                    if(sub_visit[j]) continue;
                    if(!canConvert(s, wordList.get(j))) continue;

                    List<String> pathList = new ArrayList<>(path);
                    pathList.add(wordList.get(j));
                    boolean[] clone = sub_visit.clone();
                    if(wordList.get(j).equals(endWord)){
                        flag = true;
                        res.add(pathList);
                    }
                    clone[j] = true;
                    queue.add(pathList);
                    visited.offer(clone);
                }
            }
        }
        return res;
    }

    public static boolean canConvert(String start, String s) {
        int count = 0;
        for (int i = 0; i < s.length(); ++i) {
            if(start.charAt(i) != s.charAt(i)){
                ++count;
                if(count > 1) return false;
            }
        }
        return count == 1;
    }
}
