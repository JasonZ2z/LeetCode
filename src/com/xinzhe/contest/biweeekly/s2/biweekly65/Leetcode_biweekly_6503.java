package com.xinzhe.contest.biweeekly.s2.biweekly65;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Xin
 * @date 2021/11/13
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_biweekly_6503 {
    public static void main(String[] args) {
        Leetcode_biweekly_6503 lc = new Leetcode_biweekly_6503();
//        int[][] arr = {{1,2},{3,2},{2,4},{5,6},{3,5}};
//        int[] t = {1,2,3,4,5,6};
//        System.out.println(Arrays.toString(lc.maximumBeauty(arr, t)));

        int[][] arr = {{10,100}};
        int[] t = {1};
        System.out.println(Arrays.toString(lc.maximumBeauty(arr, t)));

    }
    public int[] maximumBeauty(int[][] items, int[] queries) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(0, 0);
        for (int[] item : items) {
            if(map.containsKey(item[0])) {
                map.put(item[0], Math.max(map.get(item[0]), item[1]));
            }else {
                map.put(item[0], item[1]);
            }
        }
        int pre = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pre = Math.max(pre, entry.getValue());
            map.put(entry.getKey(), pre);
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            res[i] = map.floorEntry(queries[i]).getValue();
        }
        return res;
    }
}