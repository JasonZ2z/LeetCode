package com.xinzhe.contest.weekly.season03.weekly122;

import java.util.Arrays;

/**
 * @author Xin
 * @date 2020/9/25
 * Title :
 * Description :
 * link :
 * Level : Easy
 */

public class Leetcode_weekly_12201 {
    public static void main(String[] args) {
        Leetcode_weekly_12201 lc = new Leetcode_weekly_12201();
        int[] arr = {2,-3,-1,5,-4};
    }

    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int n = queries.length;
        int[] ans  = new int[n];
        int sum = Arrays.stream(A).filter(a -> a%2==0).sum();
        for(int i=0; i<n; i++) {
            int val = queries[i][0], index = queries[i][1];
            int tmp = A[index];
            A[index] = tmp + val;
            if(tmp % 2 == 0) sum -= tmp;
            if(A[index] % 2 == 0) sum += A[index];
            ans[i] = sum;
        }
        return ans;
    }
}
