package com.xinzhe.contest.weekly.season05.weekly205;

/**
 * @author Xin
 * @date 2020/9/6
 * Title :
 * Description :
 * link :
 * Level :
 */
public class Leetcode_weekly_20503 {
    public static void main(String[] args) {
        Leetcode_weekly_20503 lc = new Leetcode_weekly_20503();
        int[] arr = {1,2,3,4,5};
        String s  = "abaac";
        System.out.println(lc.minCost(s, arr));
    }
    public int minCost(String s, int[] cost) {
        //s = " " + s + " ";
        int n = s.length();
        char[] arr = s.toCharArray();
        int res = 0;
        int i = 0;
        while (i < n-1) {
            if(arr[i] == arr[i+1]) {
                int j = i+1;
                while(j < n && arr[j] == arr[i]) {
                    j++;
                }
                int max = 0, sum = 0;
                for(int k = i; k< j; k++) {
                    max = Math.max(max, cost[k]);
                    sum += cost[k];
                }
                res += sum - max;
                i = j;

            } else {
                i++;
            }
        }
        return  res;

    }
}
