package com.xinzhe.contest.weekly.season05.weekly217;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Xin
 * @date 2020/11/29
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_weekly_21703 {
    public static void main(String[] args) {
        Leetcode_weekly_21703 lc = new Leetcode_weekly_21703();
//        int[] arr = {28,50,76,80,64,30,32,84,53,8};  //4
//        System.out.println(lc.minMoves(arr, 84));
        int[] arr = {1,2,2,1};  //4
        System.out.println(lc.minMoves(arr, 2));
    }
    public int minMoves(int[] nums, int limit) {
        int n = nums.length;
        int[] tmp = new int[n];

        for (int i = 0; i < n/2; i++) {
            tmp[i] = nums[i] + nums[n-1 - i];
        }
        int[] cnt = new int[200001];
        int max = 0;
        for (int i = 0; i < n/2; i++) {
            if(tmp[i] == 0) continue;
            cnt[tmp[i]]++;
            max = Math.max(max, cnt[tmp[i]]);
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 2; i < cnt.length; i++) {
            if(cnt[i] == 0) continue;
            if(cnt[i] == max) list.add(i);
        }
        Integer x = list.get((list.size() - 1) / 2);
        int count = 0;
        for (int i = 0; i < n/2; i++) {
            if(tmp[i] >= x && nums[i] > x && nums[n-1-i] > x) count+=2;
            else if(tmp[i] != x) count++;
        }
        return count;


    }



}
