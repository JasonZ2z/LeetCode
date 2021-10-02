package com.xinzhe.contest.weekly.season06.weekly259;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Xin
 * @date 2021/09/19
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class DetectSquares {
    public static void main(String[] args) {
        DetectSquares lc = new DetectSquares();
        lc.add(new int[]{5,10});
        lc.add(new int[]{10,5});
        lc.add(new int[]{10,10});
        System.out.println(lc.count(new int[]{5,5}));
        lc.add(new int[]{3,0});
        lc.add(new int[]{8,0});
        lc.add(new int[]{8,5});
        System.out.println(lc.count(new int[]{3,5}));
        lc.add(new int[]{9,0});
        lc.add(new int[]{9,8});
        lc.add(new int[]{1,8});
        System.out.println(lc.count(new int[]{1,0}));
        lc.add(new int[]{0,0});
        lc.add(new int[]{8,0});
        lc.add(new int[]{8,8});
        System.out.println(lc.count(new int[]{0,8}));
    }
    Map<Integer, Set<Integer>> line;
    Map<Integer, Set<Integer>> row;
    Map<Integer, Integer> map;
    public DetectSquares() {
        this.line = new HashMap<>();
        this.row = new HashMap<>();
        this.map = new HashMap<>();
    }

    public void add(int[] point) {
        int x = point[0], y = point[1];
        int val = x * 1000 + y;
        map.put(val, map.getOrDefault(val, 0) + 1);
        line.computeIfAbsent(x, a -> new HashSet<>()).add(y);
        row.computeIfAbsent(y, a -> new HashSet<>()).add(x);
    }

    public int count(int[] point) {
        int count = 0;
        int x = point[0], y = point[1];
        for (int i : row.getOrDefault(y, new HashSet<>())) {
            int len = i - x;
            count += map.getOrDefault(i * 1000 + y, 0) * map.getOrDefault(i * 1000 + y + len, 0) * map.getOrDefault(x * 1000 + y + len, 0);
            count += map.getOrDefault(i * 1000 + y, 0) * map.getOrDefault(i * 1000 + y - len, 0) * map.getOrDefault(x * 1000 + y - len, 0);
        }
        return count;
    }

}
