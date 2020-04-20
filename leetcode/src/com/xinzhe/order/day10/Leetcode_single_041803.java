package com.xinzhe.order.day10;

import java.util.Arrays;

/**
 * @Author Xin
 * @create 2020/4/18 14:55
 * Title :
 * Description :
 * link :
 * Level :
 */
public class Leetcode_single_041803 {
    public static void main(String[] args) {
        int[][] a = {{0,4,5}, {4,8,8}, {8,6,1}, {10,10,0}};
        int[][] b = {{12,11,16},{20,2,6}, {9,2,6}, {10,18,3}, {8,14,15}};
        //System.out.println(Arrays.toString(getTriggerTime(a, b)));
        System.out.println(Arrays.toString(getTriggerTime2(a, b)));
    }
    public static int[] getTriggerTime(int[][] increase, int[][] requirements) {
        int c= 0, r=0, h=0;
        int count = 0;
        int day = requirements.length;
        int[] res = new int[day];
        Arrays.fill(res, -1);
        for (int[] ints : increase) {
            c += ints[0];
            r += ints[1];
            h += ints[2];
            count++;
            for (int j = 0; j < day; ++j) {
                int rc = requirements[j][0];
                int rr = requirements[j][1];
                int rh = requirements[j][2];
                if(rc == 0 && rr == 0 && rh== 0) res[j] = 0;
                 else if (res[j] == -1 && c >= rc && r >= rr && h >= rh) {
                    res[j] = count;
                }
            }
        }
        return res;
    }

    public static int[] getTriggerTime2(int[][] increase, int[][] requirements){
        int day = requirements.length;
        int[] res = new int[day];
        Arrays.fill(res, -1);
        int n = increase.length;
        for (int i = 1; i < n; ++i) {
            increase[i][0] += increase[i-1][0] ;
            increase[i][1] += increase[i-1][1] ;
            increase[i][2] += increase[i-1][2] ;
        }

        for (int i = 0; i < day; ++i) {
            int left = 0, right = n-1;
            while(left < right){
                int mid = left + ((right - left) >>1);
                if(judge(increase[mid], requirements[i])) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            if(judge(increase[left], requirements[i])) {
                if(requirements[i][0] == 0 && requirements[i][1] == 0 && requirements[i][2]== 0) res[i] = 0;
                else res[i] = left + 1;
            }
        }
        return res;
    }

    private static boolean judge(int[] increase, int[] requirement) {

        return increase[0] >= requirement[0]
                && increase[1] >= requirement[1]
                && increase[2] >= requirement[2];
    }

}
