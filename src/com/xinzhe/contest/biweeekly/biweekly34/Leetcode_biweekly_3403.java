package com.xinzhe.contest.biweeekly.biweekly34;

/**
 * @author Xin
 * @date 2020/9/5
 * Title :
 * Description :
 * link :
 * Level : Medium
 */
public class Leetcode_biweekly_3403 {
    public static void main(String[] args) {
        Leetcode_biweekly_3403 lc = new Leetcode_biweekly_3403();
        int[] arr = {6,3,10,11,15,20,13,3,18,12};
        System.out.println(lc.findLengthOfShortestSubarray(arr));
    }

    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;
        int i = 0, j = n-1;
        while(i < n-1 && arr[i] <= arr[i+1]){
            i++;
        }
        if(i == n-1) return 0;
        while(j > 0 && arr[j] >= arr[j-1]){
            j--;
        }
        int res = Math.min(n-i - 1, j);

        int l = 0, r = j;

        while (l <= i && r <= n-1) {
            if(arr[l] <= arr[r]) {
                res = Math.min(res, r - l - 1);
                i++;
            } else {
                j++;
            }
        }
        return res;
    }
}
