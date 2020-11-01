package com.xinzhe.contest.weekly.season05.weekly213;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Xin
 * @date 2020/11/01
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_weekly_21301 {
    public static void main(String[] args) {
        Leetcode_weekly_21301 lc = new Leetcode_weekly_21301();
        int[] arr = {3,5};
    }
    public boolean canFormArray(int[] arr, int[][] pieces) {
        int n = arr.length;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(arr[i], i);
        }
        boolean[] used = new boolean[n];
        for (int[] piece : pieces) {
            int x = piece[0];
            if(map.containsKey(x)) {
                int y = map.get(x);
                used[y] = true;
                for (int i = 1; i < piece.length; i++) {
                    if(!map.containsKey(piece[i])) return false;
                    Integer index = map.get(piece[i]);
                    if(index != y + 1) return false;
                    used[index] = true;
                    y++;
                }
            }
        }

        for (boolean b : used) {
            if(!b) return false;
        }
        return true;
    }
}
