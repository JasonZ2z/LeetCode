package com.xinzhe.contest.weekly.season05.weekly205;

/**
 * @author Xin
 * @date 2020/9/6
 * Title : 1578. 避免重复字母的最小删除成本
 * Description : 给你一个字符串 s 和一个整数数组 cost ，其中 cost[i] 是从 s 中删除字符 i 的代价。
 *              返回使字符串任意相邻两个字母不相同的最小删除成本。请注意，删除一个字符后，删除其他字符的成本不会改变。
 * link : https://leetcode-cn.com/problems/minimum-deletion-cost-to-avoid-repeating-letters
 * Level : Medium
 */
public class Leetcode_weekly_20503 {
    public static void main(String[] args) {
        Leetcode_weekly_20503 lc = new Leetcode_weekly_20503();
        int[] arr = {1,2,3,4,5};
        String s  = "abaac";
        System.out.println(lc.minCost(s, arr));
    }
    public int minCost(String s, int[] cost) {
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
