package com.xinzhe.contest.weekly.season05.weekly213;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Xin
 * @date 2020/11/01
 * Title : 1640. 能否连接形成数组
 * Description : 给你一个整数数组 arr ，数组中的每个整数 互不相同 。另有一个由整数数组构成的数组 pieces，其中的整数也 互不相同 。请你以 任意顺序 连接 pieces 中的数组以形成 arr 。
 *              但是，不允许 对每个数组 pieces[i] 中的整数重新排序。如果可以连接 pieces 中的数组形成 arr ，返回 true ；否则，返回 false 。
 * link : https://leetcode-cn.com/problems/check-array-formation-through-concatenation
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
