package com.xinzhe.contest.weekly.season04.weekly200;

import java.util.Arrays;

/**
 * @author Xin
 * @date 2020/8/2
 * Title : 1535. 找出数组游戏的赢家
 * Description : 给你一个由 不同 整数组成的整数数组 arr 和一个整数 k 。每回合游戏都在数组的前两个元素（即 arr[0] 和 arr[1] ）之间进行。
 *              比较 arr[0] 与 arr[1] 的大小，较大的整数将会取得这一回合的胜利并保留在位置 0 ，较小的整数移至数组的末尾。当一个整数赢得 k 个连续回合时，游戏结束，该整数就是比赛的 赢家 。
 *              返回赢得比赛的整数。题目数据 保证 游戏存在赢家。
 * link : https://leetcode-cn.com/problems/find-the-winner-of-an-array-game
 * Level : Medium
 */
public class Leetcode_weekly_20002 {
    public static void main(String[] args) {
        Leetcode_weekly_20002 lc = new Leetcode_weekly_20002();
        int[] arr ={963,541,112,470,285,93,24,953,536,363,575,522,390,9,873,940,921,198,75};
        System.out.println(lc.getWinner(arr, 6));
    }
    public int getWinner(int[] arr, int k) {
        int n = arr.length;
        if(k >= n) return Arrays.stream(arr).max().orElse(0);
        if(k == 1) return Math.max(arr[0], arr[1]);

        int[] copy = new int[n* 2];
        System.arraycopy(arr, 0,copy,0, n);
        System.arraycopy(arr, 0,copy,n, n);
        for (int i = 0; i < n; ++i) {
            int count = 0;
            for (int j = i+1; j<2*n; j++) {
                if(copy[j] < copy[i]) {
                    count++;
                } else {
                    break;
                }
            }
            if(count >= k-1) {
                if(i == 0) {
                    if(count > k) {
                        return arr[i];
                    }
                } else {
                    return arr[i];
                }
            }
        }
        return 0;
    }

    public int getWinner2(int[] arr, int k) {
        int cur = arr[0], win = 0;
        for (int i = 1; i < arr.length; ++i) {
            if (arr[i] > cur) {
                cur = arr[i];
                win = 0;
            }
            if (++win == k) break;
        }
        return cur;
    }
}
