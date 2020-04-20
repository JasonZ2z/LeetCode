package com.xinzhe.order.day10;

/**
 * @Author Xin
 * @create 2020/4/18 14:55
 * Title :
 * Description :
 * link :
 * Level :
 */
public class Leetcode_single_041802 {
    static int count = 0;
    public static int numWays(int n, int[][] relation, int k) {
        bfs(relation, k, 0, n-1);
        return count;
    }

    private static void bfs(int[][] relation, int k, int end, int target) {
        if(k == 0 && end == target){
            count++;
            return;
        }
        if(k <= 0) return;
        for (int[] ints : relation) {
            if (ints[0] == end) {
                bfs(relation, k - 1, ints[1], target);
            }
        }
    }

    public static void main(String[] args) {
        int[][] arr = {{0,2}, {2,1}, {3,4}, {2,3}, {1,4}, {2,0}, {0,4}};
        System.out.println(numWays(5, arr, 3));

    }
}
