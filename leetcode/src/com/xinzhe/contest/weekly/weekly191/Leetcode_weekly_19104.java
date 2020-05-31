package com.xinzhe.contest.weekly.weekly191;

import java.util.Arrays;

/**
 * @Author Xin
 * @create 2020/5/31
 * Title :
 * Description :
 * link :
 * Level : Hard
 * Comment 191周赛04
 */
//todo undo
public class Leetcode_weekly_19104 {
    public static void main(String[] args) {
        int[] arr = {2, 1, 1};
        System.out.println(getProbability(arr));
    }

    public static double getProbability(int[] balls) {
        int n = balls.length;
        int sum = Arrays.stream(balls).sum();
        double res = 1;
        for (int i = 1; i <= sum; ++i) {
            res *= i;
        }
        for (int value : balls) {
            int tmp = value;
            while (tmp > 1) {
                res /= tmp--;
            }
        }
        System.out.println("res   " + res);
        int[] pre = new int[n + 1];
        pre[0] = 1;
        for (int i = 0; i < n; ++i) {
            pre[i + 1] = pre[i] * balls[i];
        }
        System.out.println(Arrays.toString(pre));
        double next = 0;
        for (int ball : balls) {
            next += (double) pre[n] / ball;
        }
        System.out.println("next   " + next);
        return next / res;
    }

}
