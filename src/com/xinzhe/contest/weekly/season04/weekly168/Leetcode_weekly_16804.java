package com.xinzhe.contest.weekly.season04.weekly168;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * @author Xin
 * @date 2020/6/01
 * Title : 1298. 你能从盒子里获得的最大糖果数
 * Description : 给你 n 个盒子，每个盒子的格式为 [status, candies, keys, containedBoxes] ，其中：
 * 状态字 status[i]：整数，如果 box[i] 是开的，那么是 1 ，否则是 0 。
 * 糖果数 candies[i]: 整数，表示 box[i] 中糖果的数目。
 * 钥匙 keys[i]：数组，表示你打开 box[i] 后，可以得到一些盒子的钥匙，每个元素分别为该钥匙对应盒子的下标。
 * 内含的盒子 containedBoxes[i]：整数，表示放在 box[i] 里的盒子所对应的下标。
 * 给你一个 initialBoxes 数组，表示你现在得到的盒子，你可以获得里面的糖果，也可以用盒子里的钥匙打开新的盒子，还可以继续探索从这个盒子里找到的其他盒子。
 * link : https://leetcode-cn.com/problems/maximum-candies-you-can-get-from-boxes
 * Level : Hard
 * Comment 168周赛04
 */

public class Leetcode_weekly_16804 {
    public static void main(String[] args) {
        int[] status = {1, 0, 1, 0};
        int[] candies = {7, 5, 4, 100};
        int[][] keys = {{}, {}, {1}, {}};
        int[][] containedBoxes = {{1, 2}, {3}, {}, {}};
        int[] initialBoxes = {0};
        System.out.println(maxCandies(status, candies, keys, containedBoxes, initialBoxes));
    }

    public static int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        int n = status.length;
        Set<Integer> boxSet = new HashSet<>();
        Set<Integer> keySet = new HashSet<>();
        boolean[] visited = new boolean[n];

        int res = 0;
        LinkedList<Integer> list = new LinkedList<>();
        for (int i : initialBoxes) {
            boxSet.add(i);
            if (status[i] == 1) {
                list.offer(i);
                visited[i] = true;
            }
        }
        while (!list.isEmpty()) {
            int cur = list.poll();

            res += candies[cur];
            for (int key : keys[cur]) {
                keySet.add(key);
                if (!visited[key] && boxSet.contains(key)) {
                    list.offer(key);
                    visited[key] = true;
                }
            }
            for (int contain : containedBoxes[cur]) {
                boxSet.add(contain);
                if (!visited[contain] && (keySet.contains(contain) || status[cur] == 1)) {
                    list.offer(contain);
                    visited[contain] = true;
                }
            }
        }
        return res;
    }
}
