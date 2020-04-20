package com.xinzhe.order.day10;

/**
 * @Author Xin
 * @create 2020/4/18 14:55
 * Title :
 * Description :
 * link :
 * Level :
 */
public class Leetcode_single_041804 {
    public static void main(String[] args) {
        int[] jump = {2, 5, 1, 1, 1, 1};
        System.out.println(minJump(jump));
        System.out.println(minJump2(jump));

    }
    public static int minJump(int[] jump) {
        int n = jump.length;
        int[] dp = new int[n+1];

        dp[0] = 0;
        for (int i = 1; i <= n; ++i) {
            dp[i] = n;
            for(int j = i-1; j >= 0; --j) {
                if(i == n) {
                    if(j + jump[j] >= i){
                        dp[i] = Math.min(dp[i], dp[j] + 1);
                    }
                } else {
                    if(j + jump[j] == i) {
                        dp[i] = Math.min(dp[i], dp[j] + 1);
                    } else if(j + jump[j] > i) {
                        dp[i] = Math.min(dp[i], dp[j] + 2);
                    }
                }
            }
        }
        return dp[n];
    }
    public static int minJump2(int[] jump){
        int count = 0;
        int n = jump.length;
        int i=0;
        while (i < n){
            int tmp = jump[i];
            if(i + tmp >= n) return count+1;
            if(tmp == 1) {
                count++;
                i++;
            } else {
                int max = 0;
                int index = 0;
                for (int j = 1; j <= tmp; ++j) {
                    if(jump[i+j] + i+j > max){
                        max = jump[i+j] + i+j;
                        index = j;
                    }
                }
                if(index == tmp) count += 1;
                else count += 2;
                i += index;
            }

        }
        return count;
    }
}
