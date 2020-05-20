package com.xinzhe.contest.biweeekly.biweekly19;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @Author Xin
 * @create 2020/5/20
 * Title : 1345. 跳跃游戏 IV
 * Description : 给你一个整数数组 arr ，你一开始在数组的第一个元素处（下标为 0）。每一步，你可以从下标 i 跳到下标：
 * i + 1 满足：i + 1 < arr.length
 * i - 1 满足：i - 1 >= 0
 * j 满足：arr[i] == arr[j] 且 i != j
 * 请你返回到达数组最后一个元素的下标处所需的 最少操作次数 。注意：任何时候你都不能跳到数组外面。
 * link : https://leetcode-cn.com/problems/jump-game-iv
 * Level : Medium
 * Comment 19双周赛04
 */
//todo need to review
public class Leetcode_biweekly_1904 {
    public static void main(String[] args) {
        int[] a = {25, -28, -51, 61, -74, -51, -30, 58, 36, 68, -80, -64, 25, -30, -53, 36, -74, 61, -100, -30, -52};
        System.out.println(minJumps(a));
    }

    public static int minJumps(int[] arr) {
        int n = arr.length;
        // <value, List<Index>>
        Map<Integer, List<Integer>> map = new HashMap<>();
        boolean[] visited = new boolean[n];
        Arrays.fill(visited, true);
        for (int i = 0; i < arr.length; i++) {
            List<Integer> list = map.computeIfAbsent(arr[i], a -> new ArrayList<>());
            list.add(i);
        }
        Queue<Data> queue = new LinkedList<>();
        queue.add(new Data(n - 1, arr[n - 1], 0));
        while (!queue.isEmpty()) {
            Data data = queue.poll();
            visited[data.index] = false;
            if (data.index == 0) return data.step;
            if (data.index + 1 < n && visited[data.index + 1])
                queue.add(new Data(data.index + 1, arr[data.index + 1], data.step + 1));
            if (data.index - 1 >= 0 && visited[data.index - 1])
                queue.add(new Data(data.index - 1, arr[data.index - 1], data.step + 1));
            map.get(data.val).forEach(i -> {
                if (visited[i]) queue.add(new Data(i, arr[i], data.step + 1));
            });
        }
        return -1;
    }

    static class Data {
        int index;
        int val;
        int step;

        public Data(int index, int val, int step) {
            this.index = index;
            this.val = val;
            this.step = step;
        }
    }

}
