package com.xinzhe.contest.summer2020;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * @author Xin
 * @date 2020/9/12
 * Title :
 * Description :
 * link :
 * Level :
 */
public class Leetcode_singel_002 {

    static final int MOD = (int)1e9 + 7;
    public int breakfastNumber(int[] staple, int[] drinks, int x) {
        Arrays.sort(staple);

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < staple.length; i++) {
            map.put(staple[i] , i + 1);
        }
        long c = 0;
        for (int drink : drinks) {
            if(x > drink) {
                Integer key = map.floorKey(x - drink);
                if(key == null) continue;
                c += map.get(key);
            }
        }
        return (int)(c % MOD);
    }
}
