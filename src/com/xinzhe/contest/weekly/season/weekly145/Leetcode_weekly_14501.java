package com.xinzhe.contest.weekly.season.weekly145;

/**
 * @author Xin
 * @date 2020/8/13
 * Title : 1122. 数组的相对排序
 * Description : 给你两个数组，arr1 和 arr2，arr2 中的元素各不相同arr2 中的每个元素都出现在 arr1 中
 *              对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
 * link : https://leetcode-cn.com/problems/relative-sort-array
 * Level : Easy
 */

public class Leetcode_weekly_14501 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] dp = new int[1001];
        for(int i : arr1) {
            dp[i]++;
        }
        int i = 0;
        for (int j : arr2) {
            while(dp[j]-- > 0) {
                arr1[i++] = j;
            }
        }
        for(int j=0; j<1001; j++) {
            while(dp[j]-- > 0) {
                arr1[i++] = j;
            }
        }
        return arr1;
    }

}
