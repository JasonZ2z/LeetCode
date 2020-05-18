package com.xinzhe.contest.weekly.weekly186;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author Xin
 * @create 2020/4/24
 * Title : 1423. 可获得的最大点数
 * Description : 几张卡牌 排成一行，每张卡牌都有一个对应的点数。点数由整数数组 cardPoints 给出。
 *              每次行动，你可以从行的开头或者末尾拿一张卡牌，最终你必须正好拿 k 张卡牌。
 *              你的点数就是你拿到手中的所有卡牌的点数之和。
 *              给你一个整数数组 cardPoints 和整数 k，请你返回可以获得的最大点数。
 * link : https://leetcode-cn.com/problems/maximum-points-you-can-obtain-from-cards
 * Level : Medium
 * Comment : 186周赛02
 */
public class Leetcode_weekly_18602 {
    public static void main(String[] args) {
        Leetcode_weekly_18602 test1 = new Leetcode_weekly_18602();
        int[] arr = {1,2,3,4,5,6,1};
        System.out.println(test1.maxScore(arr, 3));

    }
    //dfs 超时
    int max = Integer.MIN_VALUE;
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        if(k >= n) {
            return Arrays.stream(cardPoints).boxed().mapToInt(Integer::intValue).sum();
        }
        LinkedList<Integer> list = new LinkedList<>();
        for (int cardPoint : cardPoints) {
            list.add(cardPoint);
        }
        dfs(list, k, 0);
        return max;
    }

    private void dfs(LinkedList<Integer> list, int k, int sum) {
        if(k == 0) {
            max = Math.max(sum, max);
            return;
        }
        if(k < 0) return;
        //if(sum < max) return;
        LinkedList<Integer> tmp = new LinkedList<>(list);
        int first = tmp.get(0);
        tmp.removeFirst();
        dfs(tmp, k-1, sum+first);

        int last = list.get(list.size() - 1);
        list.removeLast();
        dfs(list, k-1, sum+ last);
    }

    //先求出前k个数的总和，然后前面去掉一个，后面加上一个
    public int maxScore1(int[] cardPoints, int k){
        int n = cardPoints.length;
        if(k >= n) {
            return Arrays.stream(cardPoints).boxed().mapToInt(Integer::intValue).sum();
        }
        int sum = 0;
        for (int i = 0; i < k; ++i) {
            sum += cardPoints[i];
        }
        int res = sum;
        for(int i = k-1; i >= 0; --i) {
            sum += cardPoints[n-1-(k-1 - i)] - cardPoints[i];
            res = Math.max(res, sum);
        }
        return res;
    }
}
