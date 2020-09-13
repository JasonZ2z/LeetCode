package com.xinzhe.contest.summer2020;

/**
 * @author Xin
 * @date 2020/9/12
 * Title :
 * Description :
 * link :
 * Level :
 */
public class Leetcode_singel_003 {
    public static void main(String[] args) {
        Leetcode_singel_003 lc = new Leetcode_singel_003();
        System.out.println(lc.minimumOperations("rrryyyrryyyrr"));
        System.out.println(lc.minimumOperations("ryr"));
        System.out.println(lc.minimumOperations("yry"));
        System.out.println(lc.minimumOperations("yyyrrrrryyrrryyyy"));
    }
    public int minimumOperations(String leaves) {
        int n = leaves.length();
        char[] arr = leaves.toCharArray();
        int res = 0;
        if(!leaves.startsWith("r")) {
            res++;
            arr[0] = 'r';
        }
        if(!leaves.endsWith("r")) {
            res++;
            arr[n-1] = 'r';
        }

        int i =0, j = n-1;

        for (; i < n; ++i) {
            if(arr[i] == 'y') break;
        }
        if(i == n) return res + 1;
        for(; j >= 0; --j) {
            if(arr[j] == 'y') break;
        }
        if(i == j)return res;

        int max = j - i + 1;

        int cr = 0, cy = 0;
        for (int k = i; k <= j ; ++k) {
            if(arr[k] == 'y') cy++;
            else cr++;
        }
        if(cr == max) return res + 1;
        if(cy == max) return res;
        //pre[0] : r;
        //pre[1] : y
        int[][] pre = new int[j+2][2];
        pre[i][1] = 1;
        for (int k = i+1; k <= j+1; ++k) {
            if(arr[k] == 'r') {
                pre[k][0] = pre[k-1][0] + 1;
                pre[k][1] = pre[k-1][1];
            } else {
                pre[k][0] = pre[k-1][0];
                pre[k][1] = pre[k-1][1] + 1;
            }
        }

        int min = cr;
        for (int k = i; k <= j; ++k) {
            if(arr[k] == arr[k-1]) continue;
            for (int l = j; l > k && pre[l][1] - pre[k][1] > 0; --l) {
                if(arr[l] == arr[l+1]) continue;
                min = Math.min(pre[k-1][1] + pre[j+1][1] - pre[l+1][1] + pre[l][0] - pre[k][0], min);
            }
        }
        return min + res;
    }

    public int minimumOperations2(String leaves) {
        int n = leaves.length();
        char[] arr = leaves.toCharArray();
        int[][] dp = new int[n+1][3];

        if(arr[0] == 'r') {
            dp[0][0] = 0;
            dp[0][1] = n;
            dp[0][2] = n;
        } else {
            dp[0][0] = 1;
            dp[0][1] = n;
            dp[0][2] = n;
        }
        for (int i = 1; i < n-1; ++i) {
            if(arr[i] == 'r') {
                dp[i][0] = dp[i-1][0];
                dp[i][1] = Math.min(dp[i-1][1] + 1, dp[i-1][0] + 1);
                dp[i][2] = Math.min(dp[i-1][2], dp[i-1][1]);
            }else {
                dp[i][0] = dp[i-1][0] + 1;
                dp[i][1] = Math.min(dp[i-1][1], dp[i-1][0]);
                dp[i][2] = Math.min(dp[i-1][2] + 1, dp[i-1][1]);
            }
        }

        return dp[n-1][2];
    }
}
