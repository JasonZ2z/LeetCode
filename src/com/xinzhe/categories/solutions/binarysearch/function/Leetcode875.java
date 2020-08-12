package com.xinzhe.categories.solutions.binarysearch.function;

import java.util.Arrays;

/**
 * @author Xin
 * @date 2020/4/13 18:39
 * Title : 875. 爱吃香蕉的珂珂
 * Description : 珂珂喜欢吃香蕉。这里有 N 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 H 小时后回来。
 *              珂珂可以决定她吃香蕉的速度 K （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 K 根。如果这堆香蕉少于 K 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。  
 *              珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
 *              返回她可以在 H 小时内吃掉所有香蕉的最小速度 K（K 为整数）
 * link : https://leetcode-cn.com/problems/koko-eating-bananas
 * Level : Medium
 */
public class Leetcode875 {
    public static void main(String[] args) {
        int[] arr = {312884470};
        System.out.println(minEatingSpeed(arr, 968709470));
    }
    public static int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        Arrays.sort(piles);
        if(n == 1) return piles[0]/h+1;
        if(n == h) return piles[n-1];
        int left = 0, right = piles[n-1];
        while(left < right){
            int mid = left + ((right - left) >> 1);
            int count = 0;
            for (int pile : piles) {

                //向上取整 ： count += pile + mid - 1 / mid;
                if (pile <= mid) count++;
                else {
                    int tmp = pile / mid;
                    if (pile % mid == 0) {
                        count += tmp;
                    } else {
                        count += tmp + 1;
                    }
                }
            }
            if(count > h) {
                left = mid + 1;
            } else {
                right = mid;
            }

        }
        return left;
    }
}
