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
public class Leetcode_weekly_21304 {
    public static void main(String[] args) {
        Leetcode_weekly_21304 lc = new Leetcode_weekly_21304();
        int[] arr = {2,3};
        System.out.println(lc.kthSmallestPath(arr, 1));
        System.out.println("11".substring(1,1));
    }
    Map<int[], Long> map = new HashMap<>();
    public String kthSmallestPath(int[] destination, int k) {
        int m = destination[0], n = destination[1];
        count(0,0, m, n);
        StringBuilder sb = new StringBuilder();
        dfs(0,0,m,n, k, sb);
        return sb.toString();
    }

    private void dfs(int i, int j, int m, int n,  long k, StringBuilder s) {
        if(k == 0) return;
        long h = 0;
        if(j + 1 < n) {
            h = map.getOrDefault(new int[]{i, j+1} ,0L);
        }
        if(i + 1 < m && k > h) {
            dfs(i+1, j, m, n, k - h, s.append("V"));
        } else if(j + 1 < n){
            dfs(i, j+1, m, n, k, s.append("H"));
        }

    }


    private long count(int i, int j, int m, int n) {
        if(i == m-1 && j == n-1) {
            map.put(new int[]{i, j}, 0L);
            return 0L;
        }
        long left = i < m ? count(i + 1, j, m, n) : 0L;
        long right = j < n ? count(i, j + 1, m, n) : 0L;
        map.put(new int[]{i, j}, left + right);
        return left + right;
    }
}
