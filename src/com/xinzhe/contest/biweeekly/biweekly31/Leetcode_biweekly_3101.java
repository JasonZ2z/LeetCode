package com.xinzhe.contest.biweeekly.biweekly31;

/**
 * @author Xin
 * @date 2020/7/25
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_biweekly_3101 {
    public static void main(String[] args) {
        Leetcode_biweekly_3101 lc = new Leetcode_biweekly_3101();
        //int[] arr = {1,2,3,2,1};
        //int[] arr = {3,1,5,4,2};
        int[] arr = {4,2,3,2,2,5,5,2};
        System.out.println(lc.minNumberOperations(arr));
    }

    public int minNumberOperations(int[] target) {
        int n = target.length;
        return helper(target, 0, n-1, 0);
    }

    public int helper(int[] target, int left, int right, int pre) {
        int res = 0;
        if(right == left) {
            return target[left] - pre;
        }
        if(right > left) {
            int min = Integer.MAX_VALUE;
            int max = 0;
            for (int i = left; i <= right; ++i) {
                min = Math.min(min, target[i]);
                max = Math.max(max, target[i]);
                if(i> left && i< right && target[i] <= target[i-1] && target[i] <= target[i+1]) {
                    res += helper(target, left, i-1, target[i]);
                    res += helper(target, i+1, right, target[i]);
                    res += target[i] - pre;
                    return res;
                }
            }
            return res + max - pre;
        }
        return res;
    }
}
