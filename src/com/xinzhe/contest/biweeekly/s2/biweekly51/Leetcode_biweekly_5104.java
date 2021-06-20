package com.xinzhe.contest.biweeekly.s2.biweekly51;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * @author Xin
 * @date 2021/05/01
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_biweekly_5104 {
    public static void main(String[] args) {
        Leetcode_biweekly_5104 lc = new Leetcode_biweekly_5104();
    }
    public int[] closestRoom(int[][] rooms, int[][] queries) {
        Integer[] index = new Integer[queries.length];
        for (int i = 0; i < index.length; i++) {
            index[i] = i;
        }
        Arrays.sort(rooms, (a, b) -> b[1] - a[1]);
        Arrays.sort(index, (a, b) -> queries[b][1] - queries[a][1]);
        TreeSet<Integer> set = new TreeSet<>();
        int[] result = new int[queries.length];
        for (int i = 0, j = 0; i < index.length; i++) {
            while (j < rooms.length && rooms[j][1] >= queries[index[i]][1]) {
                set.add(rooms[j++][0]);
            }
            Integer floor = set.floor(queries[index[i]][0]), ceiling = set.ceiling(queries[index[i]][0]);
            if (floor == null && ceiling == null) {
                result[index[i]] = -1;
            } else {
                if (queries[index[i]][0]
                        - (floor == null ? -999999999 : floor) <= (ceiling == null ? 999999999 : ceiling)
                        - queries[index[i]][0]) {
                    result[index[i]] = floor;
                } else {
                    result[index[i]] = ceiling;
                }
            }
        }
        return result;
    }

}