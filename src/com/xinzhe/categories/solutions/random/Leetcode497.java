package com.xinzhe.categories.solutions.random;

import java.util.Random;
import java.util.TreeMap;

/**
 * @author Xin
 * @date 2020/8/24
 * Title : 497. 非重叠矩形中的随机点
 * Description : 给定一个非重叠轴对齐矩形的列表 rects，写一个函数 pick 随机均匀地选取矩形覆盖的空间中的整数点。
 * link : https://leetcode-cn.com/problems/random-point-in-non-overlapping-rectangles/
 * Level : Medium
 */
//todo need to review
public class Leetcode497 {
    int sum = 0;
    Random r = new Random();
    TreeMap<Integer, int[]> map = new TreeMap<>(); // pick 1
    TreeMap<Integer, Integer> treeMap = new TreeMap<>(); // pick 2
    int[][] rects; // pick 2
    public static void main(String[] args) {
    }
    public Leetcode497(int[][] rects) {
        this.r = new Random();
        this.rects = rects;
        for(int i = 0; i < rects.length; i++){
            int x = rects[i][2] - rects[i][0] + 1;
            int y = rects[i][3] - rects[i][1] + 1;
            sum += x * y;
            map.put(sum, rects[i]); //pick 1
            treeMap.put(sum, i); // pick 2
        }
    }
    // 两次 random
    public int[] pick() {
        int cur = r.nextInt(sum) + 1;
        int key = map.ceilingKey(cur);
        int [] area = map.get(key);
        return new int[]{area[0] + r.nextInt(area[2] - area[0] + 1),
                area[1] + r.nextInt(area[3] - area[1] + 1)};

    }
    // 一次 random
    public int[] pick2() {
        int area = r.nextInt(sum) + 1;
        int ceilingArea = treeMap.ceilingKey(area);
        int[] rect = rects[treeMap.get(ceilingArea)];
        int offset = ceilingArea - area;
        int col = rect[3] - rect[1] + 1;
        return new int[]{rect[0] + offset / col, rect[1] + offset % col};
    }
}
