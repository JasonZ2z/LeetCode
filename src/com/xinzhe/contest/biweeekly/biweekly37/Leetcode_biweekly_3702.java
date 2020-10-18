package com.xinzhe.contest.biweeekly.biweekly37;

/**
 * @author Xin
 * @date 2020/10/17
 * Title :
 * Description :
 * link :
 * Level :
 */
public class Leetcode_biweekly_3702 {
    public static void main(String[] args) {

    }

    public int[] bestCoordinate(int[][] towers, int radius) {
        int n = towers.length;
        int max = 0, p = 0, q = 0;
        for (int i = 0; i <= 50; ++i) {
            for (int j = 0; j <= 50 ; ++j) {
                int x = 0;
                for (int k = 0; k < n; ++k) {
                    x += getLen(towers, i,j, k, radius);
                }
                if(x > max) {
                    p = i;
                    q = j;
                    max = x;

                }
            }
        }
        return new int[]{p, q};
    }

    private int getLen(int[][] towers, int i, int j, int k, int radius) {
        double len = Math.sqrt(Math.pow(i - towers[k][0],2) + Math.pow(j - towers[k][1], 2));
        if(len <= radius) {
            return (int) Math.floor(towers[k][2] / (1 + len));
        }
        return 0;
    }
}
