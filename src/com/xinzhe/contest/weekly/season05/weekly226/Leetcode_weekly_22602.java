package com.xinzhe.contest.weekly.season05.weekly226;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Xin
 * @date 2021/01/31
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_weekly_22602 {
    public static void main(String[] args) {
        Leetcode_weekly_22602 lc = new Leetcode_weekly_22602();
        int[][] arr = {{2,1},{3,4},{3,2}};
        System.out.println(Arrays.toString(lc.restoreArray(arr)));
    }

    static int inf = (int)1e6;
    Map<Integer, Node> map = new HashMap<>();
    public int[] restoreArray(int[][] adjacentPairs) {
        for (int[] pair : adjacentPairs) {
            if(map.containsKey(pair[0])) {
                Node node = map.get(pair[0]);
                node.right = pair[1];
                node.count++;
            } else {
                map.put(pair[0], new Node(pair[0], pair[1], 1));
            }
            if(map.containsKey(pair[1])) {
                Node node = map.get(pair[1]);
                node.right = pair[0];
                node.count++;
            } else {
                map.put(pair[1], new Node(pair[1], pair[0], 1));
            }
        }
        int len = map.size();
        int l = inf, r = inf;
        for (Map.Entry<Integer, Node> entry : map.entrySet()) {
            if(entry.getValue().count == 1) {
                if(l == inf) {
                    l = entry.getKey();
                } else{
                    r = entry.getKey();
                    break;
                }
            }
        }
        int[] dp = new int[len];
        dp[0] = l; dp[len - 1] = r;
        for (int i = 1; i < len -1; ++i) {
            if(i == 1) {
                dp[i] = map.get(dp[i-1]).left;
            }else {
                Node node = map.get(dp[i-1]);
                if(node.left == dp[i-2]) {
                    dp[i] = node.right;
                } else {
                    dp[i] = node.left;
                }
            }

        }
        return dp;
    }

    class Node {
        int val;
        int left;
        int right = inf;
        int count;

        public Node(int val, int left, int count) {
            this.val = val;
            this.left = left;
            this.count = count;
        }
    }
}
