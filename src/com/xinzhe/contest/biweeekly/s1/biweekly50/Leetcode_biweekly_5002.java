package com.xinzhe.contest.biweeekly.s1.biweekly50;

/**
 * @author Xin
 * @date 2021/04/17
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_biweekly_5002 {
    public static void main(String[] args) {
        Leetcode_biweekly_5002 lc = new Leetcode_biweekly_5002();
    }
    public int[] countPoints(int[][] points, int[][] queries) {
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int r = query[2] * query[2];
            int count = 0;
            for (int[] point : points) {
                if(r >= helper(point[0], point[1], query[0], query[1])) {
                    count++;
                }
            }
            res[i] = count;
        }
        return res;
    }

    private double helper(int i, int j, int x, int y) {
        return Math.pow(x - i, 2) + Math.pow(y - j, 2);
    }
}