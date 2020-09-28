package com.xinzhe.contest.weekly.season03.weekly122;

import java.util.Arrays;

/**
 * @author Xin
 * @date 2020/9/25
 * Title : 985. 查询后的偶数和
 * Description : 给出一个整数数组 A 和一个查询数组 queries。
 *              对于第 i 次查询，有 val = queries[i][0], index = queries[i][1]，我们会把 val 加到 A[index] 上。然后，第 i 次查询的答案是 A 中偶数值的和。
 *              （此处给定的 index = queries[i][1] 是从 0 开始的索引，每次查询都会永久修改数组 A。）
 *              返回所有查询的答案。你的答案应当以数组 answer 给出，answer[i] 为第 i 次查询的答案。
 * link : https://leetcode-cn.com/problems/sum-of-even-numbers-after-queries
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
