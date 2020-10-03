package com.xinzhe.contest.weekly.season03.weekly128;

import java.util.Arrays;

/**
 * @author Xin
 * @date 2020/9/22
 * Title : 1011. 在 D 天内送达包裹的能力
 * Description : 传送带上的包裹必须在 D 天内从一个港口运送到另一个港口。
 *              传送带上的第 i 个包裹的重量为 weights[i]。每一天，我们都会按给出重量的顺序往传送带上装载包裹。我们装载的重量不会超过船的最大运载重量。
 *              返回能在 D 天内将传送带上的所有包裹送达的船的最低运载能力。
 * link : https://leetcode-cn.com/problems/capacity-to-ship-packages-within-d-days
 * Level : Easy
 */

public class Leetcode_weekly_12803 {
    public static void main(String[] args) {
        Leetcode_weekly_12803 lc = new Leetcode_weekly_12803();
        int[] arr = {1,2,3,1,1};
        lc.shipWithinDays(arr, 4);
    }
    public int shipWithinDays(int[] weights, int D) {
        int l = 0, r = Arrays.stream(weights).sum();
        while(l < r) {
            int mid = l + ((r - l) >> 1);
            if(helper(weights, mid, D)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private boolean helper(int[] w, int mid, int D){
        int count = 0, sum = 0;
        for(int i : w) {
            if(i > mid) return false;
            sum += i;
            if(sum > mid) {
                sum = i;
                count++;
            }
        }
        if(sum > 0) count++;
        return count <= D;
    }
}
