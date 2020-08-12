package com.xinzhe.categories.solutions.backtrack.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author Xin
 * @create 2020/3/11 18:15
 * Title : 491. 递增子序列
 * Description : 给你一个整数数组 A，只有可以将其划分为三个和相等的非空部分时才返回 true，否则返回 false。
 * link : https://leetcode-cn.com/problems/partition-array-into-three-parts-with-equal-sum/
 * Level : Medium
 */
public class Leetcode491 {
    public static void main(String[] args) {
        int[] arr = {4,6,7,7};
        System.out.println(findSubsequences(arr));
    }
    private static Set<List<Integer>> res = new HashSet<>();
    public static List<List<Integer>> findSubsequences(int[] nums) {
        if(nums.length < 2) return new ArrayList<>();
        bfs(nums, new ArrayList<>(), 0);
        return new ArrayList<>(res);
    }

    private static void bfs(int[] nums, ArrayList<Integer> track, int start) {
        if(track.size() >= 2){
            res.add(new ArrayList<>(track));
        }
        if(start > nums.length) return;
        for (int i = start; i < nums.length; i++) {
            if(track.size() == 0 || nums[i] >= track.get(track.size()-1)) {
                track.add(nums[i]);
                bfs(nums, track, i + 1);
                track.remove(track.size() - 1);
            }
        }
    }
}
