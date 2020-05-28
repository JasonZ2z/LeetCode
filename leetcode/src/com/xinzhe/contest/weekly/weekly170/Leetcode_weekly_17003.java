package com.xinzhe.contest.weekly.weekly170;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author Xin
 * @create 2020/5/27
 * Title : 1311. 获取你好友已观看的视频
 * Description : 有 n 个人，每个人都有一个  0 到 n-1 的唯一 id 。
 * 给你数组 watchedVideos  和 friends ，其中 watchedVideos[i]  和 friends[i] 分别表示 id = i 的人观看过的视频列表和他的好友列表。
 * Level 1 的视频包含所有你好友观看过的视频，level 2 的视频包含所有你好友的好友观看过的视频，以此类推。一般的，Level 为 k 的视频包含所有从你出发，最短距离为 k 的好友观看过的视频。
 * 给定你的 id  和一个 level 值，请你找出所有指定 level 的视频，并将它们按观看频率升序返回。如果有频率相同的视频，请将它们按字母顺序从小到大排列。
 * link : https://leetcode-cn.com/problems/get-watched-videos-by-your-friends
 * Level : Medium
 * Comment 170周赛03
 */

public class Leetcode_weekly_17003 {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        Map<String, Integer> res = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(id);
        visited.add(id);
        while (!queue.isEmpty() && level > 0) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                int cur = queue.poll();
                for (int j = 0; j < friends[cur].length; ++j) {
                    if (!visited.contains(friends[cur][j])) {
                        queue.offer(friends[cur][j]);
                        visited.add(friends[cur][j]);
                    }
                }

            }
            level--;
        }

        while (!queue.isEmpty()) {
            int i = queue.poll();
            for (int j = 0; j < watchedVideos.get(i).size(); ++j) {
                res.put(watchedVideos.get(i).get(j), res.getOrDefault(watchedVideos.get(i).get(j), 0) + 1);
            }
        }
        return res.entrySet().stream()
                .sorted((a, b) -> a.getValue().intValue() == b.getValue().intValue() ? a.getKey().compareTo(b.getKey()) : a.getValue() - b.getValue())
                .map(Map.Entry::getKey).collect(Collectors.toList());
    }
}


