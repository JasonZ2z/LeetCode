package com.xinzhe.contest.biweeekly.biweekly32;

/**
 * @Author Xin
 * @create 2020/8/8
 * Title :
 * Description :
 * link :
 * Level :
 */
public class Leetcode_biweekly_3201 {
    public static void main(String[] args) {
        Leetcode_biweekly_3201 lc = new Leetcode_biweekly_3201();
        int[] arr = {2,3,4,7,11};
        System.out.println(lc.findKthPositive(arr, 5));
    }
    public int findKthPositive(int[] arr, int k) {
        int n = arr.length;
        int j = 0, i =1;
        int count = 0;
        for (; i < 5000; ++i) {
            if(j < n && arr[j] == i){
                j++;
            } else {
                count++;
                if(count == k) {
                    return i;
                }
            }
        }
        return i;
    }
}
