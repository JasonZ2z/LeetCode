package com.xinzhe.categories.solutions.binarysearch.function;

/**
 * @author Xin
 * @date 2020/4/13 18:39
 * Title : 875. 爱吃香蕉的珂珂
 * Description : 珂珂喜欢吃香蕉。这里有 N 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 H 小时后回来。
 *              珂珂可以决定她吃香蕉的速度 K （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 K 根。如果这堆香蕉少于 K 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。
 *              珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
 *              返回她可以在 H 小时内吃掉所有香蕉的最小速度 K（K 为整数）
 * link : https://leetcode-cn.com/problems/koko-eating-bananas
 * Level : Medium
 */
public class Leetcode875 {
    public int minEatingSpeed(int[] piles, int h) {
        int min = 1, max = 0;
        for (int p : piles) max = Math.max(max, p);
        while(min < max) {
            int mid = min + (max - min) / 2;
            if(cal(piles, mid, h)) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        return max;
    }
    public boolean cal(int[] piles, int k, int h) {
        long res = 0;
        for(int i : piles) {
            res += (i - 1) / k + 1;
            if(res > h) return false;
        }
        return true;
    }
}
