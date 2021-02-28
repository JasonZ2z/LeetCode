package com.xinzhe.contest.weekly.season05.weekly230;

/**
 * @author Xin
 * @date 2021/02/28
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_weekly_23002 {
    public static void main(String[] args) {
        Leetcode_weekly_23002 lc = new Leetcode_weekly_23002();
        int[] arr1 = {1,7};
        int[] arr2 = {3,4};
        System.out.println(lc.closestCost(arr1, arr2, 10));
    }
    int min = Integer.MAX_VALUE;
    int[] toppingCost;
    int target;
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        this.toppingCost = toppingCosts;
        this.target = target;

        for (int baseCost : baseCosts) {
            if(baseCost == target) return target;
            if(dfs(baseCost, 0)) return target;
        }
        return min;
    }

    private boolean dfs(int sum, int i) {
        if(sum == target) return true;
        min = helper(sum , min);
        if(sum > target || i == toppingCost.length) return false;
        for (int j = 0; j < 3; ++j) {
            if(dfs(sum + j * toppingCost[i], i+1)) return true;
        }
        return false;
    }

    private int helper(int i, int j) {
        int x = Math.abs(i - target);
        int y = Math.abs(j - target);
        if(x == y) return Math.min(i, j);
        if(x > y) return j;
        return i;
    }
}
