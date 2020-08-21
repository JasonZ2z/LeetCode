package com.xinzhe.contest.weekly.season03.weekly140;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Xin
 * @date 2020/8/21
 * Title : 1079. 活字印刷
 * Description : 你有一套活字字模 tiles，其中每个字模上都刻有一个字母 tiles[i]。返回你可以印出的非空字母序列的数目。 注意：本题中，每个活字字模只能使用一次。
 * link : https://leetcode-cn.com/problems/letter-tile-possibilities/
 * Level : Medium
 */

public class Leetcode_weekly_14002 {
    public static void main(String[] args) {
        Leetcode_weekly_14002 lc = new Leetcode_weekly_14002();
        System.out.println(lc.numTilePossibilities("AAABBC"));
    }
    Set<String> set = new HashSet<>();
    public int numTilePossibilities(String tiles) {
        char[] arr = tiles.toCharArray();
        boolean[] used = new boolean[arr.length];
        helper(arr, "", used);
        System.out.println(set);
        return set.size()-1;
    }

    private void helper(char[] arr, String s, boolean[] used) {
        if(s.length() > arr.length) return;
        set.add(s);
        for (int i=0; i<arr.length; i++) {
            if(!used[i]) {
                used[i] = true;
                helper(arr, s + arr[i], used);
                used[i] = false;
            }
        }
    }
}
