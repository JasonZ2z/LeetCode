package com.xinzhe.contest.biweeekly.biweekly38;

/**
 * @author Xin
 * @date 2020/10/31
 * Title :
 * Description :
 * link : 
 * Level : Easy
 */
public class Leetcode_biweekly_3804 {
    public static void main(String[] args) {
        Leetcode_biweekly_3804 lc = new Leetcode_biweekly_3804();
        String[] arr = {"acca","bbbb","caca"};
        System.out.println(lc.numWays(arr, "aba"));
    }

    int Mod = (int)1e9 + 7;
    public int numWays(String[] words, String target) {
        int[][] map = new int[words[0].length()][26];
        for (String word : words) {
            for (int i = 0; i < map.length; i++) {
                map[i][word.charAt(i) - 'a']++;
            }
        }
        return (int) numWays(0, 0, map, target, new Long[map.length][target.length()]);
    }

    private long numWays(int index, int j, int[][] map, String target, Long[][] dp) {
        if (j == target.length()) {
            return 1;
        } else if (map.length - index < target.length() - j) {
            return 0;
        } else if (dp[index][j] == null) {
            dp[index][j] = 0L;
            for (int i = index; i < map.length; i++) {
                if (map[i][target.charAt(j) - 'a'] > 0) {
                    dp[index][j] = (dp[index][j]
                            + map[i][target.charAt(j) - 'a'] * numWays(i + 1, j + 1, map, target, dp)) % Mod;
                }
            }
        }
        return dp[index][j];
    }
}
