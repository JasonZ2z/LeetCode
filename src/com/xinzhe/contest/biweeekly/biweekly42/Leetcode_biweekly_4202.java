package com.xinzhe.contest.biweeekly.biweekly42;

/**
 * @author Xin
 * @date 2020/12/26
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_biweekly_4202 {
    public static void main(String[] args) {
        Leetcode_biweekly_4202 lc = new Leetcode_biweekly_4202();
        int[][] arr = {{5,2},{5,4},{10,3},{20,1}};
        System.out.println(lc.averageWaitingTime(arr));
    }
    public double averageWaitingTime(int[][] customers) {
        long start = customers[0][0] + customers[0][1];
        long sum = customers[0][1];

        for (int i = 1; i < customers.length; ++i) {
            int[] cus = customers[i];
            if(cus[0] > start) {
                start = cus[0];
            }
            sum += start + cus[1] - cus[0];
            start += cus[1];
        }
        return sum * 1.0 / customers.length;
    }
}