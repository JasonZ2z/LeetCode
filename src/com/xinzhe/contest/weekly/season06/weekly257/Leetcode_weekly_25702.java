package com.xinzhe.contest.weekly.season06.weekly257;

import java.util.Arrays;

/**
 * @author Xin
 * @date 2021/09/05
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_weekly_25702 {
    public static void main(String[] args) {
        Leetcode_weekly_25702 lc = new Leetcode_weekly_25702();
        int[][] arr = {{7,9},{10,7},{6,9},{10,4},{7,5},{7,10}};
        System.out.println(lc.numberOfWeakCharacters(arr));

    }
    public int numberOfWeakCharacters(int[][] properties) {
        int count = 0, max = 0;
        Arrays.sort(properties, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        for (int[] property : properties) {
            count += max > property[1] ? 1 : 0;
            max = Math.max(max, property[1]);
        }
        return count;
    }
}
