package com.xinzhe.contest.weekly.season05.weekly222;

import java.util.Arrays;

/**
 * @author Xin
 * @date 2020/12/27
 * Title :
 * Description :
 * link :
 * Level :
 */
public class Leetcode_weekly_22201 {
    public static void main(String[] args) {
        Leetcode_weekly_22201 lc = new Leetcode_weekly_22201();
        int[] arr = {3,5};
    }
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        int sum = 0;
        for (int[] boxType : boxTypes) {
            if (truckSize >= boxType[0]) {
                sum += boxType[0] * boxType[1];
                truckSize -= boxType[0];
                if(truckSize == 0) break;
            } else {
                sum += truckSize * boxType[1];
                break;
            }
        }
        return sum;
    }
}
