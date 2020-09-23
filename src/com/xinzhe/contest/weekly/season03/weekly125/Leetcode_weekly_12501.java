package com.xinzhe.contest.weekly.season03.weekly125;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author Xin
 * @date 2020/9/23
 * Title : 997. 找到小镇的法官
 * Description :
 * link :
 * Level : Easy
 */

public class Leetcode_weekly_12501 {
    public static void main(String[] args) {
        Leetcode_weekly_12501 lc = new Leetcode_weekly_12501();
        int[] arr = {2,-3,-1,5,-4};
    }

    public int findJudge(int N, int[][] trust) {
        HashSet<Integer>[] dp = new HashSet[N];
        for (int i = 0; i < N; ++i) {
            dp[i] = new HashSet<>();
        }
        for (int[] t : trust) {
            dp[t[1]-1].add(t[0]-1);
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; ++i) {
            if(dp[i].size() == N-1){
                list.add(i);
            }
        }
        if(list.size() != 1) return -1;
        int index = list.get(0);
        for (int i = 0; i < N; ++i) {
            if(dp[i].contains(index)){
                return -1;
            }
        }
        return index+1;
    }
}
